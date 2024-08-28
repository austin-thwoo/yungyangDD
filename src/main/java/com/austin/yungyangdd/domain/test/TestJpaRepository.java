package com.austin.yungyangdd.domain.test;

import com.austin.yungyangdd.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TestJpaRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);

    boolean existsByUserName(String userName);
}
