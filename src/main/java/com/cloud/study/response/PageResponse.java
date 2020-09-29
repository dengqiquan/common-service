package com.cloud.study.response;

import com.cloud.study.enums.ResponseState;
import com.cloud.study.utils.HttpResponseUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rex on 2019/8/7.
 */
public class PageResponse<T> extends Response<List<T>> {
    private Long total;
    private Integer begin;
    private Integer size;

    public PageResponse() {
        this.success();
    }

    private void setResponseHeader() {
        if(this.begin != null && this.total != null)
            HttpResponseUtil.getResponse().setHeader("Content-Range", "items=" + this.begin + "-" + (this.begin.longValue() + (long) this.size) + "/" + this.total);
    }

    @JsonIgnore
    public List getRows() {
        return (List)this.getData();
    }

    public PageResponse total(Long total) {
        this.total = total;
        this.setResponseHeader();
        return this;
    }

    public PageResponse begin(Integer begin) {
        this.begin = begin;
        this.setResponseHeader();
        return this;
    }

    public PageResponse rows(List data) {
        this.setData(data);
        this.size = data.size();
        this.setResponseHeader();
        return this;
    }

    public PageResponse failure() {
        this.meta = new Response.Meta(ResponseState.FAIL);
        return this;
    }

    public PageResponse failure(String message) {
        this.meta = new Response.Meta(ResponseState.FAIL, message);
        return this;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getBegin() {
        return this.begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
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
