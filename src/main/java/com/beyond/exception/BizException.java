package com.beyond.exception;


import com.beyond.constants.Code;

/**
 * @author beyond
 * @since 2022/11/11
 */
public class BizException extends RuntimeException {


    private final String code;

    public BizException(final String message) {
        this(Code.FAILURE, message);
    }

    public BizException(final String code, final String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
