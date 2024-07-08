package com.austin.yungyangdd.domain.supplements.repository;

import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplementsJpaRepository extends JpaRepository<Supplements,Long> {
}
