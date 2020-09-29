package com.cloud.study.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: TODO
 * @author: dqq
 * @date: 2020/9/29 14:56
 */

public class HttpResponseUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpResponseUtil.class);

    public HttpResponseUtil() {
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    public static void writeObject(Object object) {
        String  json = JSON.toJSONString(object);
        HttpServletResponse response = getResponse();

        try {
            response.setContentType("application/json");
            ServletOutputStream e = response.getOutputStream();
            e.write(json.getBytes());
        } catch (IOException var5) {
            logger.error("向Response写对象IO异常", var5);
        }

    }
}
