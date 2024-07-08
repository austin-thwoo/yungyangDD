package com.austin.yungyangdd.domain.supplements.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class ShopNotFoundException extends BusinessException {
    public ShopNotFoundException(String value) {
        super(value, ErrorCode.SHOP_NOT_FOUND);
    }
}
