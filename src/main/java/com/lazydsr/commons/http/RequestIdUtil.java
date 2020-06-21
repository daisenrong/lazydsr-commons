package com.lazydsr.commons.http;

import java.util.UUID;

/**
 *
 * @author : daisenrong
 * @since : 2020/06/15 17:14
 */
public class RequestIdUtil {
    public static final int MAX_LENGTH = 32;
    public static final String REQUEST_ID_KEY = "requestId";

    public RequestIdUtil() {}

    /**
     * 生成requestId
     * 
     * @return str
     */
    public static String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
