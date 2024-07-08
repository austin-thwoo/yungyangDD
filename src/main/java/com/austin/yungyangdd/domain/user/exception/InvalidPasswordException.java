package com.austin.yungyangdd.domain.user.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException(String value) { super(value, ErrorCode.NOT_MATCH_PASSWORD);
    }
}
