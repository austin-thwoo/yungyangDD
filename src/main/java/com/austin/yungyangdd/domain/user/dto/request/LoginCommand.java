package com.austin.yungyangdd.domain.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginCommand {
    private String username;
    private String password;


}
