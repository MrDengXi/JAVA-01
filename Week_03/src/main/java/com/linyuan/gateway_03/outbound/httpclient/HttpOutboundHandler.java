package com.linyuan.gateway_03.outbound.httpclient;

import com.linyuan.gateway_03.filter.HttpRequestFilter;
import com.linyuan.gateway_03.filter.HttpResponseFilter;
import com.linyuan.gateway_03.filter.impl.HeadHttpResponseFilterImpl;
import com.linyuan.gateway_03.filter.impl.HttpRequestFilterImpl;
import com.linyuan.gateway_03.router.HttpEndpointRouter;
import com.linyuan.gateway_03.router.impl.HttpEndpointRouterImpl;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @Author DengXi
 * @Date 2021/1/27 3:37 下午
 * @desc:描述
 */
public class HttpOutboundHandler extends ChannelOutboundHandlerAdapter {

    private CloseableHttpAsyncClient httpclient;

    private String backendUrl;

    private HttpEndpointRouter router = new HttpEndpointRouterImpl();

    private HttpResponseFilter responseFilter = new HeadHttpResponseFilterImpl();

    public HttpOutboundHandler() {
        int cores = Runtime.getRuntime().availableProcessors() * 2;

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(500000)
                .setSocketTimeout(500000)
                .setConnectionRequestTimeout(10000)
                .build();

        // 配置io线程
        IOReactorConfig ioReactorConfig = IOReactorConfig.custom().
                setIoThreadCount(Runtime.getRuntime().availableProcessors())
                .setSoKeepAlive(true)
                .build();
        // 设置连接池大小
        ConnectingIOReactor ioReactor = null;
        try {
            ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
        } catch (IOReactorException e) {
            e.printStackTrace();
        }
        PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(ioReactor);
        connManager.setMaxTotal(100);
        connManager.setDefaultMaxPerRoute(100);


        httpclient = HttpAsyncClients.custom().setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig)
                .setDefaultIOReactorConfig(ioReactorConfig)
                .build();
        httpclient.start();
    }

    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        String url = router.route();
        fetchGet(fullRequest, ctx, url);
    }

    private void fetchGet(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String url) {
        final HttpGet httpGet = new HttpGet(url);
        //httpGet.setProtocolVersion(HttpVersion.HTTP_1_0);
        httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        httpclient.execute(httpGet, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(final HttpResponse endpointResponse) {
                //System.out.println("有结果啦");
                try {
                    handleResponse(fullRequest, ctx, endpointResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }

            @Override
            public void failed(final Exception ex) {
                httpGet.abort();
                ex.printStackTrace();
                exceptionCaught(ctx, ex);
            }

            @Override
            public void cancelled() {
                httpGet.abort();
            }
        });

    }


    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final HttpResponse endpointResponse) throws Exception {
        FullHttpResponse response = null;
        try {
            byte[] body = EntityUtils.toByteArray(endpointResponse.getEntity());

            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
            responseFilter.filter(response, ctx);
        } catch (Exception e) {
            e.printStackTrace();
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(response);
                }
            }
            ctx.flush();
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        FullHttpResponse response = null;
        response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        ctx.write(response);
        cause.printStackTrace();
        ctx.flush();
    }


}
