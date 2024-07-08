package com.austin.yungyangdd.domain.user.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(String value) {
        super(value, ErrorCode.USER_NOT_FOUND);
    }
}
