package com.totoro.mall.util;

import java.io.Serializable;

public class RespResult<T> implements Serializable {

    private T data;

    private Integer code;

    private String message;

    public RespResult(){}

    public RespResult(RespCode respCode) {
        this.code = respCode.getCode();
        this.message=respCode.getMessage();
    }

    public RespResult(T data, RespCode respCode) {
        this.data = data;
        this.code = respCode.getCode();
        this.message=respCode.getMessage();
    }

    public RespResult(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static RespResult ok(){
        return new RespResult(null, RespCode.SUCCESS);
    }

    public static RespResult ok(Object data){
        return new RespResult(data, RespCode.SUCCESS);
    }

    public static RespResult error(){
        return new RespResult(null, RespCode.ERROR);
    }

    public static RespResult error(String message){
        return secByError(RespCode.ERROR.getCode(), message);
    }

    public static RespResult secByError(Integer code, String message){
        RespResult err = new RespResult();
        err.setCode(code);
        err.setMessage(message);
        return err;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
