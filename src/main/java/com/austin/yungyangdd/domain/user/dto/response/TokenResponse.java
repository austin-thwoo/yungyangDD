package com.austin.yungyangdd.domain.user.dto.response;


import com.austin.yungyangdd.domain.user.dto.request.TokenDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponse {

    private String token;
    private UserResponse user;

    public TokenResponse(TokenDTO dto) {
        this.token = dto.getToken();
        this.user = new UserResponse(dto.getUser());



    }

}
