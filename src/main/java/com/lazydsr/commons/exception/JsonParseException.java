package com.lazydsr.commons.exception;

/**
 * json 转化异常
 *
 * @author : daisenrong
 */
public class JsonParseException extends RuntimeException {

    private static final long serialVersionUID = 6851366558723883813L;

    public JsonParseException(String message) {
        super(message);
    }

    public JsonParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonParseException(Throwable cause) {
        super(cause);
    }
}
