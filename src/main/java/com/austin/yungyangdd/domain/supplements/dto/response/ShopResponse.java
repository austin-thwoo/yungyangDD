package com.austin.yungyangdd.domain.supplements.dto.response;

import com.austin.yungyangdd.domain.supplements.domain.Shop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import com.austin.yungyangdd.domain.supplements.domain.type.ShopType;
import com.austin.yungyangdd.domain.supplements.dto.response.simpleResponse.SupplementSimpleResponse;
import com.austin.yungyangdd.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ShopResponse {

    private Long id;
    private String name;
    private User master;
    private String tel;
    private ShopType shopType;
    private List<SupplementSimpleResponse> supplementSimpleResponseList;

    public ShopResponse(Shop shop) {
        this.id= shop.getId();
        this.name=shop.getName();
        this.master=shop.getMaster();
        this.tel=shop.getTel();
        this.shopType=shop.getType();
        this.supplementSimpleResponseList= shop.getSaleShop().stream().map(SupplementSimpleResponse::new).collect(Collectors.toList());
    }
    public ShopResponse(Shop shop, List<Supplements> supplementsList) {
        this.id= shop.getId();
        this.name=shop.getName();
        this.master=shop.getMaster();
        this.tel=shop.getTel();
        this.shopType=shop.getType();
        this.supplementSimpleResponseList= supplementsList.stream().map(SupplementSimpleResponse::new).collect(Collectors.toList());
    }


}

