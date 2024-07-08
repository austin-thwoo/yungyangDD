package com.austin.yungyangdd.domain.common.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AgeCount {
    private Long teenCount;
    private Long twentyCount;
    private Long thirtyCount;
    private Long fortyCount;
    private Long fiftyCount;
    private Long sixtyCount;

}
