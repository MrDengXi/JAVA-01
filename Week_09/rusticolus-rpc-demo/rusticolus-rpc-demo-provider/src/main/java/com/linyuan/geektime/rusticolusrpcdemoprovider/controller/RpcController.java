package com.linyuan.geektime.rusticolusrpcdemoprovider.controller;

import com.linyuan.jeektime.rusticolusrpccommon.api.RpcReponse;
import com.linyuan.jeektime.rusticolusrpccommon.api.RpcRequest;
import com.linyuan.jeektime.rusticolusrpcserver.core.RpcServerInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linyuan
 * @desc:描述
 */
@RestController
public class RpcController {

    @Autowired
    private RpcServerInvoker serverInvoker;

    @PostMapping("/")
    public RpcReponse invoke(@RequestBody RpcRequest request){
        return serverInvoker.invoke(request);
    }
}