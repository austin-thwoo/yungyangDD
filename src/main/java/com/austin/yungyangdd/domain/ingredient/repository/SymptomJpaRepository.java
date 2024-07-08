package com.austin.yungyangdd.domain.ingredient.repository;

import com.austin.yungyangdd.domain.ingredient.domain.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomJpaRepository  extends JpaRepository<Symptom, Long> {
}
