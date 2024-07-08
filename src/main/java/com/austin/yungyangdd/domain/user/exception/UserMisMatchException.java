package com.austin.yungyangdd.domain.user.exception;

import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class UserMisMatchException extends BusinessException {

    public UserMisMatchException(String message) {
        super(message, ErrorCode.USER_MIS_MATCH);
    }
}
