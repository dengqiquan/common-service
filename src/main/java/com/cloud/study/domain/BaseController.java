package com.cloud.study.domain;

import com.cloud.study.enums.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rex on 2019/8/9.
 */
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    /**
     *  返回失败状态码数据
     * @param codeEnum 状态码枚举
     * @param message 错误信息
     * @param <T> 返回泛型数据
     * @return 结果
     */
    protected <T> Response<T> failure(ResponseCodeEnum codeEnum, String message){
        Response<T> response =  new Response<>();
        response.failure(message);
        response.getMeta().setCode(codeEnum.getCode());
        return response;
    }

    /**
     * 返回默认错误编码，错误信息
     * @param message 错误信息
     * @param <T>  返回泛型数据
     * @return 结果
     */
    protected <T> Response<T> failure(String message){
        Response<T> response =  new Response<>();
        response.failure(message);
        return response;
    }

    /**
     * 返回默认错误编码，错误信息，数据
     * @param message 错误信息
     * @param <T>  返回泛型数据
     * @return 结果
     */
    protected <T> Response<T> failure(ResponseCodeEnum codeEnum, String message, T data){
        Response<T> response =  new Response<>();
        response.failure(message);
        response.getMeta().setCode(codeEnum.getCode());
        response.setData(data);
        return response;
    }

    /**
     * 返回成功结果
     * @param data 结果
     * @param <T> 泛型对象
     * @return 结果
     */
    protected <T> Response<T> success(T data){
        Response<T> response =  new Response<>();
        response.success(data);
        return response;
    }

    /**
     * 通用成功和失败返回
     * @param successFlag 成功标志
     * @param data 返回数据
     * @param errorMsg 错误消息
     * @return
     */
    protected Response success(boolean successFlag, Object data, String errorMsg){
        if(successFlag){
            return success(data);
        }else{
            return new Response().failure(data, errorMsg);
        }
    }

}
