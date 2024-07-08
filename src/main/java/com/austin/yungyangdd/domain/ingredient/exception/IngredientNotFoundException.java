package com.austin.yungyangdd.domain.ingredient.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class IngredientNotFoundException extends BusinessException {
    public IngredientNotFoundException(String value) {
        super(value, ErrorCode.INGREDIENT_NOT_FOUND);
    }
}
