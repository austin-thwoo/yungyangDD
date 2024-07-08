package com.austin.yungyangdd.domain.user.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class DeletedUserException extends BusinessException {

    public DeletedUserException(String message) {
        super(message, ErrorCode.USER_DELETED);
    }
}
