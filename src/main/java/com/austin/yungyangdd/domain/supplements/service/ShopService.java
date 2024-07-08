package com.austin.yungyangdd.domain.supplements.service;


import com.austin.yungyangdd.domain.supplements.domain.Shop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import com.austin.yungyangdd.domain.supplements.dto.response.ShopResponse;
import com.austin.yungyangdd.domain.supplements.dto.response.SupplementResponse;
import com.austin.yungyangdd.domain.supplements.repository.SupplementsRepositorySupport;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.persistance.UserRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {


    private final SupplementsRepositorySupport supplementsRepositorySupport;
    private final UserRepositorySupport userRepositorySupport;


    @Transactional
    public ShopResponse findByShopId(Long shopId,String query) {
        Shop shop = findById(shopId);
        if (query!=null){
            List<Supplements> s  =getSupplementList(query);
            return new ShopResponse(shop,s);
        }
        return new ShopResponse(shop);

    }

    private List<Supplements> getSupplementList(String query) {
        return supplementsRepositorySupport.findAllSupplementsByQuery(query);

    }

    private Shop findById(Long shopId) {
        Shop shop = supplementsRepositorySupport.findShopById(shopId);
        return shop;
    }

    public List<SupplementResponse> recommendByMe(User principal) {
        User user = getUser(principal.getId());
        List<Supplements> supplementsList=recommendedSupplementsByAge(user.getAge());
        return supplementsList.stream().map(SupplementResponse::new).collect(Collectors.toList());





    }

    private List<Supplements> recommendedSupplementsByAge(Long age) {
        return supplementsRepositorySupport.findAllSupplementsByAge(age);
    }

    private User getUser(Long userId) {
        return userRepositorySupport.findUserById(userId);

    }

    public List<SupplementResponse> recommendByAge(Long age) {
        return recommendedSupplementsByAge(age).stream().map(SupplementResponse::new).collect(Collectors.toList());
    }

    public SupplementResponse findSupplementById(Long supplemenetId) {
        return new SupplementResponse(getSUpplementById(supplemenetId));
    }

    private Supplements getSUpplementById(Long supplemenetId) {
        return supplementsRepositorySupport.findSupplementById(supplemenetId);
    }
}
