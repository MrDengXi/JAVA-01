package com.linyuan.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 单线程的socket程序
public class HttpServer01 {
    public static void main(String[] args) throws IOException{
        ExecutorService executorService = new ThreadPoolExecutor(18, 36, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3600));

        final ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static int i=0;
    private static void service(Socket socket) {
        try {
            Thread.sleep(5);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio1";
            printWriter.println("Content-Length:" + body.getBytes().length);
            //printWriter.println("Content-body:" + body);
            printWriter.println();
            printWriter.write(body);
            printWriter.flush();
            printWriter.close();
            //socket.close();
        } catch (IOException | InterruptedException e) { // | InterruptedException e) {
            e.printStackTrace();
        }
    }
}