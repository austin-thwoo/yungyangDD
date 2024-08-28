package com.austin.yungyangdd.domain.user.dto.request;

import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.user.domain.common.UserGender;
import com.austin.yungyangdd.domain.user.domain.common.UserType;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;

@NoArgsConstructor
@Getter
public class UserRegisterCommand {


    private String username;
    private String password;
    private String nickName;

    private String phoneNumber;
    private Long age;
    private UserGender gender;

    @Embedded
    private Address address;

    public void setEncodedPassword(String encodedPassword) {
        this.password= encodedPassword;
    }
}
