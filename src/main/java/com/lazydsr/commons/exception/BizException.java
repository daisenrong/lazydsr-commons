package com.lazydsr.commons.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author daisenrong
 * @since 2020/6/13 10:53 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BizException extends RuntimeException implements Serializable {
    /** 自定义业务错误代码 */
    private Integer errorCode;

    public BizException() {
        super();
    }

    public BizException(Integer errorCode) {
        this(errorCode, null, null);
    }

    public BizException(String message) {
        this(null, message, null);
    }

    public BizException(Throwable cause) {
        this(null, null, cause);
    }

    public BizException(Integer errorCode, String message) {
        this(errorCode, message, null);
    }

    public BizException(Integer errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public BizException(String message, Throwable cause) {
        this(null, message, cause);
    }

    public BizException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

}
