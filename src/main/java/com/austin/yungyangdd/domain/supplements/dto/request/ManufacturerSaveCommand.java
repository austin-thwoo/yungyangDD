package com.austin.yungyangdd.domain.supplements.dto.request;

import com.austin.yungyangdd.domain.common.models.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ManufacturerSaveCommand {

    private String name;
    private Address address;
    private String owner;
    private String tel;

    private List<Long> supplementIds;







}
