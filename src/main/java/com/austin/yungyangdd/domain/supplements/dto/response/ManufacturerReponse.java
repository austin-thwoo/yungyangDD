package com.austin.yungyangdd.domain.supplements.dto.response;

import com.austin.yungyangdd.domain.supplements.domain.Manufacturer;
import com.austin.yungyangdd.domain.supplements.dto.response.simpleResponse.SupplementSimpleResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
public class ManufacturerReponse {

    private Long id;
    private String name;
    private String owner;
    private String tel;
    private List<SupplementSimpleResponse> supplementSimpleResponseList;



    public ManufacturerReponse(Manufacturer manufacturer) {
        this.id=manufacturer.getId();
        this.name=manufacturer.getName();
        this.owner=manufacturer.getOwner();
        this.tel=manufacturer.getTel();
        this.supplementSimpleResponseList=manufacturer.getSupplement().stream().map(SupplementSimpleResponse::new).collect(Collectors.toList());
    }
}
