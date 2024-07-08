package com.austin.yungyangdd.domain.user.application;


import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.dto.request.UserRegisterCommand;
import com.austin.yungyangdd.domain.user.dto.response.UserResponse;
import com.austin.yungyangdd.domain.user.persistance.UserRepositorySupport;
import com.austin.yungyangdd.global.application.CustomDateService;
import com.austin.yungyangdd.global.dto.DateDTO;
import com.austin.yungyangdd.global.dto.response.ApiListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ManagerCommandService {


    private final UserRepositorySupport userRepositorySupport;

    private final CustomDateService customDateService;


    public ApiListResponse<UserResponse> findUserAll(String userType, String query, String startDate, String endDate, User user) {

        DateDTO dateDTO= new DateDTO();
        dateDTO=customDate(startDate,endDate,dateDTO);

        List<User> users=userRepositorySupport.findAll(userType,query,dateDTO,user.getId());

        return new ApiListResponse<>(users.stream().map(UserResponse::new).collect(Collectors.toList()));

    }
    private DateDTO customDate(String startDate, String endDate, DateDTO dateDTO) {
        return customDateService.dateConvert(startDate,endDate,dateDTO);
    }
    public UserResponse findUserById(Long userId) {
        User user = userRepositorySupport.findById(userId);
        return new UserResponse(user);
    }


    public UserResponse updateUser(Long userId, UserRegisterCommand command) {
        User user = getUserById(userId);
        return new UserResponse(user);
    }

    public boolean deleteUser(Long userId) {
        User user = getUserById(userId);
        user.setDeletedDate();
        return true;
    }

    public boolean unDeleteUser(Long userId) {
        User user = getUserById(userId);
        user.setUnDeletedDate();
        return true;
    }

    private User getUserById(Long userId) {
        return userRepositorySupport.findUserById(userId);
    }


    public boolean approveUser(User principal, Long userId) {
        User user = getUserById(userId);
        user.addRole("ROLE_USER");
        return true;
    }

}
