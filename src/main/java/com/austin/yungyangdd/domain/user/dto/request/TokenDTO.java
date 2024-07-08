package com.austin.yungyangdd.domain.user.dto.request;



import com.austin.yungyangdd.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private String token;
    private User user;
}
