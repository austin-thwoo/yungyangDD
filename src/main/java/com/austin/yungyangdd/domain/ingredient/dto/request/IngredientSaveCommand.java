package com.austin.yungyangdd.domain.ingredient.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class IngredientSaveCommand {
    private String name;
    private List<Long> symptomIds;
}
