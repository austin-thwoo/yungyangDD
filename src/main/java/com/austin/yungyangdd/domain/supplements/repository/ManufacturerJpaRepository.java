package com.austin.yungyangdd.domain.supplements.repository;


import com.austin.yungyangdd.domain.supplements.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findByName(String name);
}
