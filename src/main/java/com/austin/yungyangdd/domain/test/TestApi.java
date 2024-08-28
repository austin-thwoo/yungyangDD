package com.austin.yungyangdd.domain.test;


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
@RequestMapping("/test")
public class TestApi {


    private final TestService testService;



    @ApiOperation(value = "내정보")
    @GetMapping("/brand")
    public ApiResponse<Boolean> findMe() {
        return new ApiResponse<>(testService.test());

    }




}