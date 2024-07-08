package com.austin.yungyangdd.domain.user.application;

import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.dto.request.ChangePasswordCommand;
import com.austin.yungyangdd.domain.user.dto.request.TokenDTO;
import com.austin.yungyangdd.domain.user.dto.request.UserRegisterCommand;
import com.austin.yungyangdd.domain.user.dto.response.TokenResponse;
import com.austin.yungyangdd.domain.user.dto.response.UserResponse;
import com.austin.yungyangdd.domain.user.exception.DuplicationPasswordException;
import com.austin.yungyangdd.domain.user.exception.InvalidPasswordException;
import com.austin.yungyangdd.domain.user.persistance.UserJpaRepository;
import com.austin.yungyangdd.domain.user.persistance.UserRepositorySupport;

import com.austin.yungyangdd.global.provider.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserCommandService {
    private final UserRepositorySupport userRepositorySupport;
    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserUtilsService userUtilsService;
    private final TokenProvider tokenProvider;
    public UserResponse updateMe(User principal, UserRegisterCommand command) {

        User user=getUserById(principal.getId());
        user.update(command);

        return new UserResponse(user);
    }

    private User getUserById(Long userId) {
        return userRepositorySupport.findById(userId);
    }

    public Boolean changePassword(User principal, ChangePasswordCommand changePasswordCommand) {
        User user = userRepositorySupport.findById(principal.getId());

        //현재 비번이랑 같은지
        duplicationCheckPassword(changePasswordCommand.getNewPassword(), user.getPassword());
        // 현재 비밀번호 잘 입력 했는지
        this.passwordCheck(changePasswordCommand.getCurrentPassword(), user.getPassword());

        // newPassword와 checkNewPassword가 같은 지
        userUtilsService.checkEqualsNewPassword(changePasswordCommand.getNewPassword(), changePasswordCommand.getCheckNewPassword());

        // update
        user.changePassword(passwordEncoder.encode(changePasswordCommand.getNewPassword()));
        return true;
    }

    private void passwordCheck(String currentPassword, String userPassword) {
        boolean match = passwordEncoder.matches(currentPassword, userPassword);
        if (!match) {
            throw new InvalidPasswordException(currentPassword);
        }
    }


    public void duplicationCheckPassword(String newPassword, String encodedPassword) {
            if (passwordEncoder.matches(newPassword, encodedPassword)) {
                throw new DuplicationPasswordException(newPassword);
            }
        }
    public TokenResponse findById(User principal) {

        User user=getUser(principal.getId());
        String token = tokenProvider.createToken(String.valueOf(user.getId()), user.getRoles());
        TokenDTO dto = new TokenDTO(token, user);

        return new TokenResponse(dto);

    }

    private User getUser(Long userId) {
        return userRepositorySupport.findById(userId);
    }


}
