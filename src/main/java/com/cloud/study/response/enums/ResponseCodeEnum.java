package com.cloud.study.response.enums;

/**
 * Created by Rex on 2019/8/14.
 * @Author xianxiong
 */
public enum ResponseCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 警告
     */
    WARNING(300, "警告"),
    /**
     * 失败
     */
    FAIL(400, "失败");

    private int code;
    private String msg;

    ResponseCodeEnum(int rCode,String rMsg){
        this.code = rCode;
        this.msg = rMsg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
