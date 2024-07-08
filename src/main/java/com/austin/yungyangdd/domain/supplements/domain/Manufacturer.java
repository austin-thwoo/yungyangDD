package com.austin.yungyangdd.domain.supplements.domain;

import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.supplements.dto.request.ManufacturerSaveCommand;
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
@Table(name = "T_MANUFACTURER")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String owner;

    private String tel;


    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Supplements> supplement  =new ArrayList<>();

    public static Manufacturer create(ManufacturerSaveCommand saveCommand) {
        return Manufacturer.builder()
                .name(saveCommand.getName())
                .address(saveCommand.getAddress())
                .owner(saveCommand.getOwner())
                .tel(saveCommand.getTel())
        .build();
    }

    public void addSupplements(List<Supplements> supplementsList) {
        this.supplement.addAll(supplementsList);

    }
}
