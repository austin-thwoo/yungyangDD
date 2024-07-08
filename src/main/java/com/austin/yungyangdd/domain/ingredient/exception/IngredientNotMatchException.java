package com.austin.yungyangdd.domain.ingredient.exception;


import com.austin.yungyangdd.global.error.exception.BusinessException;
import com.austin.yungyangdd.global.error.model.ErrorCode;

public class IngredientNotMatchException extends BusinessException {
    public IngredientNotMatchException(String value) {
        super(value, ErrorCode.INGREDIENT_NOT_MATCH);
    }
}
