package com.austin.yungyangdd.domain.ingredient.dto.response.simpleResponse;


import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class IngredientSimpleResponse {
    private Long id;
    private String name;
    private Long contetn;
    private List<SymptomResponse> symptomResponseList;


    public IngredientSimpleResponse(Nutrient nutrient){
        this.id=nutrient.getIngredient().getId();
        this.name= nutrient.getIngredient().getName();
        this.contetn= nutrient.getContent();//함량
        this.symptomResponseList=nutrient.getIngredient().getIngredientSymptom().stream().map(SymptomResponse::new).collect(Collectors.toList());

    }
    public IngredientSimpleResponse(Ingredient ingredient){
        this.id= ingredient.getId();
        this.name= ingredient.getName();
        this.contetn= null;



    }
}
