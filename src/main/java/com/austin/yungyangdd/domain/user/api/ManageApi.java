package com.austin.yungyangdd.domain.user.api;


import com.austin.yungyangdd.domain.user.application.ManagerCommandService;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.dto.request.UserRegisterCommand;
import com.austin.yungyangdd.domain.user.dto.response.UserResponse;
import com.austin.yungyangdd.global.dto.response.ApiListResponse;
import com.austin.yungyangdd.global.dto.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manage/user")
public class ManageApi {

    private final ManagerCommandService managerCommandService;



    @ApiOperation(value = "유저 목록")
    @GetMapping("/user")
    public ApiListResponse<UserResponse> findUserAll(@AuthenticationPrincipal User user,
                                                     @RequestParam(required = false) String userType,
                                                     @RequestParam(required = false) String query,
                                                     @RequestParam(required = false) String startDate,
                                                     @RequestParam(required = false) String endDate) {
        return managerCommandService.findUserAll(userType, query, startDate, endDate, user);
    }

    @ApiOperation(value = "유저 상세")
    @GetMapping("/user/{userId}")
    public ApiResponse<UserResponse> findUserById(@PathVariable(name = "userId") Long userId) {
        return new ApiResponse<>(managerCommandService.findUserById(userId));
    }

    @ApiOperation(value = "유저 수정")
    @PatchMapping("/user/{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable(name = "userId") Long userId,
                                                @RequestBody UserRegisterCommand command) {
        return new ApiResponse<>(managerCommandService.updateUser(userId, command));
    }

    @ApiOperation(value = "유저 삭제")
    @DeleteMapping("/user/{userId}")
    public ApiResponse<Boolean> deleteUser(@PathVariable(name = "userId") Long userId) {
        return new ApiResponse<>(managerCommandService.deleteUser(userId));
    }

    @ApiOperation(value = "유저 뽁구")
    @PatchMapping("/user/undelete/{userId}")
    public ApiResponse<Boolean> unDeleteUser(@PathVariable(name = "userId") Long userId) {
        return new ApiResponse<>(managerCommandService.unDeleteUser(userId));
    }

    @ApiOperation(value = "가입 승인")
    @PostMapping("/user/{userId}")
    public ApiResponse<Boolean> approveUser(@PathVariable Long userId,
                                            @AuthenticationPrincipal User principal) {
        return new ApiResponse<>(managerCommandService.approveUser(principal, userId));
    }




}