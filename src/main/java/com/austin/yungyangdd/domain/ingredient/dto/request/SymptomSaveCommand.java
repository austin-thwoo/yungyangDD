package com.austin.yungyangdd.domain.ingredient.dto.request;

import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.supplements.domain.type.ShopType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SymptomSaveCommand {

    private String name;
    private ShopType shopType;
    private String master;
    private String tel;
    private Address address;








}
