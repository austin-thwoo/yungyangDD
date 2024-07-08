package com.austin.yungyangdd.domain.supplements.dto.response.simpleResponse;


import com.austin.yungyangdd.domain.ingredient.domain.IngredientSymptom;
import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import com.austin.yungyangdd.domain.supplements.domain.Manufacturer;
import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SupplementSimpleResponse {
    private Long id;
    private String name;
    private Long price;

    public SupplementSimpleResponse(SaleShop  saleShop){
        this.id= saleShop.getSupplements().getId();
        this.name= saleShop.getSupplements().getName();
        this.price = saleShop.getPrice();
    }
    public SupplementSimpleResponse(Nutrient nutrient){
        this.id= nutrient.getSupplements().getId();
        this.name= nutrient.getSupplements().getName();
        this.price =null;

    }
    public SupplementSimpleResponse(Supplements supplements){
        this.id=supplements.getId();
        this.name=supplements.getName();
        this.price =null;

    }
}
