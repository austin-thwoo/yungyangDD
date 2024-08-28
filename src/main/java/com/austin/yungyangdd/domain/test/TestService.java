package com.austin.yungyangdd.domain.test;


import com.austin.yungyangdd.domain.user.persistance.UserRepositorySupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TestService {

    private final TestJpaRepository testJpaRepository;
    private final UserRepositorySupport userRepositorySupport;

    @Transactional
    public Boolean test() {
        List<test> testList = userRepositorySupport.findByFourString(4);
        String word = "liq";
        String key = "리큐";
        String ke = "랩신";

        for (test tt : testList) {

            Long count = 0L;
            log.info(tt.getName());
            if (!tt.getName().contains("liq")
                    && !tt.getName().contains("리큐")
                    && !tt.getName().contains("labccin")
                    && !tt.getName().contains("LABCCIN")
                    && !tt.getName().contains("랩신")
                    && !tt.getName().contains("lechatlard")
                    && !tt.getName().contains("lechatlard1802")
                    && !tt.getName().contains("1802")
                    && !tt.getName().contains("르샤트라1802")) {
                continue;
            }
            count ++;
            String filteredString= "";
            if (tt.getName().contains("liq")
                    && tt.getName().contains("리큐")
                    && tt.getName().contains("랩신")){
                 filteredString = tt.getName().replace(key, "");
                 filteredString = filteredString.replace(word, "");
                filteredString = filteredString.replace(ke, "");

            }
            if (filteredString.length()<4){
            count++;

            }
            log.info(tt.getName());
            tt.setBrand(count);




        }
        return null;
    }
}