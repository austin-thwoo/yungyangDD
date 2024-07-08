package com.austin.yungyangdd.domain.user.api;



import com.austin.yungyangdd.domain.user.application.UserCommandService;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.dto.request.ChangePasswordCommand;
import com.austin.yungyangdd.domain.user.dto.request.UserRegisterCommand;
import com.austin.yungyangdd.domain.user.dto.response.TokenResponse;
import com.austin.yungyangdd.domain.user.dto.response.UserResponse;

import com.austin.yungyangdd.global.dto.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApi {


    private final UserCommandService userCommandService;



    @ApiOperation(value = "내정보")
    @GetMapping("/me")
    public ApiResponse<TokenResponse> findMe(@AuthenticationPrincipal User principal) {
        return new ApiResponse<>(userCommandService.findById(principal));

    }

    @ApiOperation(value = "내정보 수정")
    @PutMapping("/me")
    public ApiResponse<UserResponse> updateMe(@AuthenticationPrincipal User principal,
                                              @RequestBody UserRegisterCommand command) {
        return new ApiResponse<>(userCommandService.updateMe(principal, command));
    }

    @ApiOperation(value = "비밀번호 변경")
    @PatchMapping("/password")
    public ApiResponse<Boolean> changePassword(@AuthenticationPrincipal User principal,
                                               @Validated @RequestBody ChangePasswordCommand changePasswordCommand) {
        return new ApiResponse<>(userCommandService.changePassword(principal, changePasswordCommand));
    }


}