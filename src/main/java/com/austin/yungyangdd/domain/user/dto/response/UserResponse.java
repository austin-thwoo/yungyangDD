package com.austin.yungyangdd.domain.user.dto.response;



import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.domain.common.UserType;
import lombok.Getter;


@Getter
public class UserResponse {
    private final Long id;
    private final String username;
    private final String nickname;
    private final String phoneNumber;
    private final UserType userType;
    private final boolean isDeleted;
    private final Address address;


    public UserResponse(User user){
        this.id = user.getId();
        this.username= user.getUsername();
        this.nickname= user.getNickName();
        this.userType=user.getUserType();
        this.phoneNumber=user.getPhoneNumber();
        this.isDeleted= user.getDeletedDate() != null;
        this.address=user.getAddress();



    }


}
