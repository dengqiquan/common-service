package com.cloud.study.response;


import com.cloud.study.enums.ResponseState;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * Created by Rex on 2019/8/7.
 */
public class Response<T> implements Serializable {
    protected Meta meta;
    protected T data;

    public Response() {
    }

    public Boolean checkState() {
        return Boolean.valueOf(this.meta.getCode() == ResponseState.SUCCESS.getCode());
    }

    public Response success() {
        this.meta = new Meta(ResponseState.SUCCESS);
        return this;
    }

    public Response warning() {
        this.meta = new Meta(ResponseState.WARNING);
        return this;
    }

    public Response success(T data) {
        this.success();
        this.data = data;
        return this;
    }

    public Response message(String message) {
        this.getMeta().setMessage(message);
        return this;
    }

    public Response data(T data) {
        this.data = data;
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.getMeta().getCode() == ResponseState.SUCCESS.getCode();
    }

    public Response failure() {
        this.meta = new Meta(ResponseState.FAIL);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(ResponseState.FAIL, message);
        return this;
    }

    public Response failure(T data, String message) {
        this.failure(message);
        this.data = data;
        return this;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public T getData() {
        return this.data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }

    public static class Meta implements Serializable {
        private int code;
        private String message;

        public Meta() {
        }

        public Meta(ResponseState responseState) {
            this.setCode(responseState.getCode());
            this.message = responseState.getCodeInfo();
        }

        public Meta(ResponseState responseState, String message) {
            if(message == null) {
                message = responseState.getCodeInfo();
            }
            this.code = responseState.getCode();
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setCode(ResponseState state) {
            this.code = state.getCode();
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
