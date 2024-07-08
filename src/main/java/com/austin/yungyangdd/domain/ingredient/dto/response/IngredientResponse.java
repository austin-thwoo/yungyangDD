package com.austin.yungyangdd.domain.ingredient.dto.response;


import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;

import com.austin.yungyangdd.domain.ingredient.dto.response.simpleResponse.SymptomResponse;
import com.austin.yungyangdd.domain.supplements.dto.response.simpleResponse.SupplementSimpleResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class IngredientResponse {
    private Long id;
    private List<SupplementSimpleResponse> supplementList;
    private List<SymptomResponse> symptomList;

    public IngredientResponse(Ingredient ingredient){
        this.id= ingredient.getId();
        this.supplementList=ingredient.getNutrients().stream().map(SupplementSimpleResponse::new).collect(Collectors.toList());
        this.symptomList=ingredient.getIngredientSymptom().stream().map(SymptomResponse::new).collect(Collectors.toList());

    }



}
