package com.austin.yungyangdd.domain.ingredient.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class SymptomNotFoundException extends BusinessException {
    public SymptomNotFoundException(String value) {
        super(value, ErrorCode.SYMPTOM_NOT_FOUND);
    }
}
