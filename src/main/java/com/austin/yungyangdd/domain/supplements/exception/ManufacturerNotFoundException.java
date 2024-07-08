package com.austin.yungyangdd.domain.supplements.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;
public class ManufacturerNotFoundException extends BusinessException {
    public ManufacturerNotFoundException(String value) {
        super(value, ErrorCode.MANUFACTURER_NOT_FOUND);
    }
}
