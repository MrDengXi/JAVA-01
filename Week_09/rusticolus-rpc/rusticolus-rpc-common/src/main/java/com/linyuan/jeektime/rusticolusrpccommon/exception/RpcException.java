package com.linyuan.jeektime.rusticolusrpccommon.exception;

/**
 * @Author linyuan
 * @desc:描述
 */
public class RpcException extends Exception{
    static final long serialVersionUID = 7818375828146090155L;

    public RpcException(){
        super();
    }

    public RpcException(String message){
        super(message);
    }

    public RpcException(String message, Throwable throwable){
        super(message, throwable);
    }

    public RpcException(Throwable throwable){
        super(throwable);
    }
}