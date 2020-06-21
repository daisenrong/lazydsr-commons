package com.lazydsr.commons.response;

import com.lazydsr.commons.request.PageInfo;

/**
 * @author daisenrong
 * @since 2020/6/13 10:47 下午
 */
public class ResponseUtil {
    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> success(T data) {
        return success(data, null);
    }

    public static <T> Response<T> success(T data, PageInfo pageInfo) {
        return getResponse(0, "success", data, pageInfo);
    }

    public static <T> Response<T> fail() {
        return fail("fail");
    }

    public static <T> Response<T> fail(String message) {
        return getResponse(50000, message);
    }

    public static <T> Response<T> getResponse(Integer code, String message) {
        return getResponse(code, message, null, null);
    }

    public static <T> Response<T> getResponse(Integer code, String message, T data) {
        return getResponse(code, message, data, null);
    }

    public static <T> Response<T> getResponse(Integer code, String message, T data, PageInfo pageInfo) {
        return new Response<T>(code, message, data, pageInfo);
    }
}
