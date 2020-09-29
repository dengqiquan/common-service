package com.cloud.study.enums;

public enum ResponseCodeEnum {

    SUCCESS(200, "成功"),
    WARNING(300, "警告"),
    FAIL(400, "失败");

    private int code;
    private String msg;

    private ResponseCodeEnum(int rCode, String rMsg) {
        this.code = rCode;
        this.msg = rMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
