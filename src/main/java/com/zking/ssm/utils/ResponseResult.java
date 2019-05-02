package com.zking.ssm.utils;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    //状态
    private Integer status;

    //状态信息
    private String message;

    //数据信息  当不需要数据信息时可填ResponseResult<void>
    private T data;

    public ResponseResult(){}

    public ResponseResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
