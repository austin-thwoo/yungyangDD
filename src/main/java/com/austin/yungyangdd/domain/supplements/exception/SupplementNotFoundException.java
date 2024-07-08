package com.austin.yungyangdd.domain.supplements.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class SupplementNotFoundException extends BusinessException {
    public SupplementNotFoundException(String value) {
        super(value, ErrorCode.SUPPLEMENT_NOT_FOUND);
    }
}
