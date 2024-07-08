package com.austin.yungyangdd.global.error.exception;


import com.austin.yungyangdd.global.error.model.ErrorCode;

public class DateWrongException extends BusinessException {
    public DateWrongException(String value) {
        super(value, ErrorCode.DATE_WRONG);
    }
}
