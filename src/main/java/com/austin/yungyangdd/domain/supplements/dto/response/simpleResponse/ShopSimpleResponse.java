package com.austin.yungyangdd.domain.supplements.dto.response.simpleResponse;

import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import com.austin.yungyangdd.domain.supplements.domain.Shop;
import com.austin.yungyangdd.domain.supplements.domain.type.ShopType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ShopSimpleResponse {

    private Long id;
    private String name;

    private ShopType shopType;

    public ShopSimpleResponse(SaleShop saleShop) {
        this.id= saleShop.getShop().getId();
        this.name=saleShop.getShop().getName();
        this.shopType=saleShop.getShop().getType();

//        this.supplementSimpleResponseList= shop.getSaleShop().stream().map(SupplementSimpleResponse::new).collect(Collectors.toList());
    }



}

