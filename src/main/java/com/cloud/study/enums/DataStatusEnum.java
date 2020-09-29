package com.cloud.study.enums;

/**
 * Created by Rex on 2019/8/19.
 */
public enum DataStatusEnum {

    NORMAL("0","正常"),
    DELETE("1","删除"), ;

    private String code;
    private String message;

    DataStatusEnum(String cd, String msg){
        this.code = cd;
        this.message = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
