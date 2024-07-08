package com.austin.yungyangdd.domain.supplements.service;


import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import com.austin.yungyangdd.domain.supplements.domain.Shop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import com.austin.yungyangdd.domain.supplements.dto.dto.SaleShopDto;
import com.austin.yungyangdd.domain.supplements.dto.request.SaleShopCommand;
import com.austin.yungyangdd.domain.supplements.dto.request.ShopSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.response.ShopResponse;
import com.austin.yungyangdd.domain.supplements.repository.SaleShopJpaRepository;
import com.austin.yungyangdd.domain.supplements.repository.ShopJpaRepository;
import com.austin.yungyangdd.domain.supplements.repository.SupplementsRepositorySupport;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.persistance.UserRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ShopManageService {

    private final ShopJpaRepository shopJpaRepository;
    private final SupplementsRepositorySupport supplementsRepositorySupport;
    private final UserRepositorySupport userRepositorySupport;
    private final SaleShopJpaRepository saleShopJpaRepository;

    @Transactional
    public ShopResponse register(User principal, ShopSaveCommand saveCommand) {

         Shop shop = savePlace(getUserById(principal),saveCommand);
        return new ShopResponse(shop);
    }

    private User getUserById(User principal) {
        return userRepositorySupport.findById(principal.getId());
    }

    private Shop savePlace(User user,ShopSaveCommand saveCommand) {
        saveCommand.setUser(user);
        return shopJpaRepository.save(Shop.create(saveCommand));
    }

    @Transactional
    public ShopResponse findByShopId(Long shopId) {
        Shop shop=getShopById(shopId);

        return new ShopResponse(shop);

    }

    private Shop getShopById(Long shopId) {
        Shop shop=supplementsRepositorySupport.findShopById(shopId);
        return shop;
    }



    public ShopResponse addSupplement(User principal, SaleShopCommand saleShopCommand) {

        Shop shop=createSaleShop(saleShopCommand);
        return new ShopResponse(shop);


    }

    private Shop createSaleShop(SaleShopCommand saleShopCommand) {
        Shop shop=getShopById(saleShopCommand.getShopId());

        for (SaleShopDto dto:saleShopCommand.getSaleShopDtos()){
            Supplements supplements=getSupplementById(dto.getSupplementId());
            SaleShop saleShop=SaleShop.create(supplements,shop, dto.getPrice());
            shop.addSaleShop(saleShop);
            supplements.addSaleShop(saleShop);
            saleShopJpaRepository.save(saleShop);
        }
        return shop;
    }


    private Supplements getSupplementById(Long supplementId) {
        return supplementsRepositorySupport.findSupplementById(supplementId);
    }
}
