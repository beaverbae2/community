package com.beaver.community.service;

import com.beaver.community.entity.User;
import com.beaver.community.model.user.UserUpdateRequest;
import com.beaver.community.model.user.UserUpdateResponse;
import com.beaver.community.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRespository userRespository;

    @Transactional
    public UserUpdateResponse update(User user, UserUpdateRequest request) {
        User updatedUser = user.update(request);
        userRespository.save(updatedUser);
        return UserUpdateResponse.from(updatedUser);
    }
}
