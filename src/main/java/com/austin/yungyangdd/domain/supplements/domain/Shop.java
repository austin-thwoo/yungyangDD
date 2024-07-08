package com.austin.yungyangdd.domain.supplements.domain;

import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.supplements.domain.type.ShopType;
import com.austin.yungyangdd.domain.supplements.dto.request.ShopSaveCommand;
import com.austin.yungyangdd.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_SHOP")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User master;

    @Embedded
    private Address address;

    private String tel;

    @Enumerated(EnumType.STRING)
    private ShopType type;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<SaleShop> saleShop = new ArrayList<>();


    public static Shop create(ShopSaveCommand saveCommand) {
        return Shop.builder()
                .name(saveCommand.getName())
                .master(saveCommand.getMaster())
                .address(saveCommand.getAddress())
                .tel(saveCommand.getTel())
                .type(saveCommand.getShopType())
                .build();
    }

    public void addSaleShop(SaleShop saleShop) {
        this.saleShop.add(saleShop);
    }
}
