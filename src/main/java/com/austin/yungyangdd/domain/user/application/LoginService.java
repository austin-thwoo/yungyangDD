package com.austin.yungyangdd.domain.user.application;


import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.dto.request.LoginCommand;
import com.austin.yungyangdd.domain.user.dto.request.TokenDTO;
import com.austin.yungyangdd.domain.user.dto.response.TokenResponse;
import com.austin.yungyangdd.domain.user.exception.DeletedUserException;
import com.austin.yungyangdd.domain.user.exception.InvalidPasswordException;
import com.austin.yungyangdd.domain.user.persistance.UserRepositorySupport;

import com.austin.yungyangdd.global.provider.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class LoginService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepositorySupport userRepositorySupport;
    private final TokenProvider tokenProvider;
    public TokenResponse login(LoginCommand loginCommand) {

        User user=getUser(loginCommand);
        checkDeleteUser(user);
        TokenDTO tokenDTO= new TokenDTO(getToken(user),user);
        return new TokenResponse(tokenDTO);
    }

    private String getToken(User user) {
        return tokenProvider.createToken(user.getId().toString(),user.getRoles());
    }

    private User getUser(LoginCommand loginCommand) {
    return userRepositorySupport.findByUserName(loginCommand.getUsername());

    }

    private void checkDeleteUser(User user) {
        if (user.getDeletedDate()!=null){
            throw new DeletedUserException(user.getId().toString());
        }
    }
    public void checkPassword(String password, String encodedPassword) {
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw new InvalidPasswordException(password);
        }
    }
}
