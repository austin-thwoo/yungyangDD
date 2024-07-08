package com.austin.yungyangdd.domain.supplements.dto.request;

import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;

import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import com.austin.yungyangdd.domain.supplements.dto.dto.SupplementShopDto;
import com.austin.yungyangdd.domain.supplements.dto.dto.SupplementingredientDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class SupplementSaveCommand {

    private String name;
    private String secondName;
    private Long recommendAge;
    private Long manufacturerId;


    private List<SupplementShopDto> shopDtos;
    private List<SupplementingredientDto> ingredientDtos;






}
