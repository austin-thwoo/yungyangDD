package com.austin.yungyangdd.domain.supplements.repository;

import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientJpaRepository extends JpaRepository<Nutrient,Long> {
}
