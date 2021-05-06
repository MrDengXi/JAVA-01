package com.linyuan.jeektime.rusticolusrpccommon.api;

import com.linyuan.jeektime.rusticolusrpccommon.exception.RpcException;
import lombok.Data;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
public class RpcReponse {
    private Object result;

    private boolean status;

    private RpcException exception;
}