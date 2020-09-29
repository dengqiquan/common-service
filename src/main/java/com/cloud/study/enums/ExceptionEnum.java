package com.cloud.study.enums;

/**
 * Created by dqq on 2019/9/7.
 */
public enum ExceptionEnum {

    /**
     * 未认证（未登陆）
     */
    RUNTIME_EXCEPTION(400,"运行错误"),

    /**
     * 未认证（未登陆）
     */
    UNAUTHORIZED_EXCEPTION(401,"未认证"),
    /**
     * token失效
     */
    TOKENINVALID_EXCEPTION(402,"token失效"),
    /**
     * 接口不存在
     */
    NOT_FOUND_EXCEPTION(404,"接口不存在"),
    /**
     * 请求超时
     */
    REQUEST_TIMEOUT_EXCEPTION(408,"请求超时"),
    /**
     * 参数错误
     */
    PARAM_EXCEPTION(1000, "参数错误"),

    /**
     * 网络原因
     */
    CONNECTION_TIMEOUT_EXCEPTION(4000, "网络原因"),

    /** 001021 -- 验证码短信发送失败 */
    FAILED_CAPTCHA_SMS(001021, "验证码短信发送失败");



    private int code;
    private String msg;

    ExceptionEnum(int rCode, String rMsg){
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
