package com.austin.yungyangdd.domain.ingredient.dto.response.simpleResponse;


import com.austin.yungyangdd.domain.ingredient.domain.IngredientSymptom;
import com.austin.yungyangdd.domain.ingredient.domain.Symptom;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SymptomResponse {

    private Long id;
    private String symptom;


public SymptomResponse(Symptom symptom){
    this.id= symptom.getId();
    this.symptom=symptom.getSymptoms();

}
    public SymptomResponse(IngredientSymptom ingredientSymptom){
        this.id= ingredientSymptom.getSymptom().getId();
        this.symptom=ingredientSymptom.getSymptom().getSymptoms();

    }

}
