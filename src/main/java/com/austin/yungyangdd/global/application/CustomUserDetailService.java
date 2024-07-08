package com.austin.yungyangdd.global.application;


import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.persistance.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService{


        private final UserJpaRepository userJpaRepository;


    @Override
    @Transactional
    public User loadUserByUsername(String userPK) throws UsernameNotFoundException {
        User user = userJpaRepository.findById(Long.valueOf(userPK)).orElse(null);

        if (user == null) {
            throw new AccessDeniedException(userPK);
        }
        return user;
    }


}
