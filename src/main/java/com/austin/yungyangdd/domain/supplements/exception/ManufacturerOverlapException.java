package com.austin.yungyangdd.domain.supplements.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class ManufacturerOverlapException extends BusinessException {
    public ManufacturerOverlapException(String value) {
        super(value, ErrorCode.MANUFACTURER_OVERLAP);
    }
}
