package com.austin.yungyangdd.global.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsRequest {

    private String phone;
}
