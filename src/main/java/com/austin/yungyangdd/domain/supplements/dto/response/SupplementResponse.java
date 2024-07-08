package com.austin.yungyangdd.domain.supplements.dto.response;

import com.austin.yungyangdd.domain.common.models.AgeCount;
import com.austin.yungyangdd.domain.ingredient.dto.response.simpleResponse.IngredientSimpleResponse;
import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import com.austin.yungyangdd.domain.supplements.domain.Manufacturer;
import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import com.austin.yungyangdd.domain.supplements.dto.response.simpleResponse.ShopSimpleResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SupplementResponse {
    private Long id;

    private String name;
    private String secondName;
    private Long recommendAge;
    private AgeCount ageCount;
    private Manufacturer manufacturer;
    private List<ShopSimpleResponse> saleShopList;
    private List<IngredientSimpleResponse> nutientList;


    public SupplementResponse (Supplements supplements){
        this.id = supplements.getId();
        this.name= supplements.getName();
        this.secondName=supplements.getSecondName();
        this.recommendAge= supplements.getRecommendAge();
        this.ageCount=supplements.getAgeCount();
        this.manufacturer=supplements.getManufacturer();
        this.saleShopList= supplements.getSaleShop().stream().map(ShopSimpleResponse::new).collect(Collectors.toList());
        this.nutientList=supplements.getNutrients().stream().map(IngredientSimpleResponse::new).collect(Collectors.toList());




    }

}
