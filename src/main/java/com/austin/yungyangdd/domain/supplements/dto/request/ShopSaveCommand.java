package com.austin.yungyangdd.domain.supplements.dto.request;

import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.supplements.domain.type.ShopType;
import com.austin.yungyangdd.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ShopSaveCommand {

    private String name;
    private ShopType shopType;
    private User master;
    private String tel;
    private Address address;


    public void setUser(User user){
        this.master=user;

    }








}
