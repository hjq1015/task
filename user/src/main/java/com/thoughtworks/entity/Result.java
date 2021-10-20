package com.thoughtworks.entity;

import com.thoughtworks.constant.BaseConstants;

public class Result<T>{
    private String msg = BaseConstants.SUCCESS_MSG;

    private String code = BaseConstants.SUCCESS_CODE;

    private T data;

    private Long count = 0L;

    public Result(T data, Long count){
        this(data);
        this.count = count;
    }

    public Result(T data){
        this.data = data;
    }

    public static <T> Result success(T data, Long count){
        return new Result(data, count);
    }

    public static <T> Result success(T data){
        return new Result(data);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
