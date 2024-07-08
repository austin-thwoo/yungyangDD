package com.austin.yungyangdd.domain.user.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class UserNameDuplicatedException extends BusinessException {
    public UserNameDuplicatedException(String value) {
        super(value, ErrorCode.DUPLICATED_ID);
    }
}
