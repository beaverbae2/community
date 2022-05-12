package com.beaver.community.model.user;

import com.beaver.community.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class UserUpdateResponse {
    @NotNull
    private Long id;

    private String nickname;
    private String password;

    public static UserUpdateResponse from(User user) {
        return new UserUpdateResponse(user.getId(), user.getNickName(), user.getPassword());
    }
}
