package com.linyuan.jeektime.rusticolusrpccommon.api;

import lombok.Data;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
public class RpcRequest {

    private String serviceClass;

    private String method;

    private Object[] params;
}