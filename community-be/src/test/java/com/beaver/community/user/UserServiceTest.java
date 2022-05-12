package com.beaver.community.user;

import com.beaver.community.entity.User;
import com.beaver.community.model.user.UserUpdateRequest;
import com.beaver.community.model.user.UserUpdateResponse;
import com.beaver.community.repository.UserRespository;
import com.beaver.community.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

/**
 * 회원 가입, 회원 정보 수정, 회원 탈퇴
 */

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .email("test@test.com")
                .nickName("test")
                .password("test12")
                .build();
        userRespository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRespository.deleteAll();
    }

    @Test
    @DisplayName("회원 찾기")
    void find() {
        User user = User.builder()
                .email("test@test.com")
                .nickName("test")
                .password("test12")
                .build();

        User savedUser = userRespository.save(user);
        assertThat(user).isEqualTo(savedUser);
    }

    @Test
    @DisplayName("회원 정보 수정")
    void update() {
        UserUpdateRequest request = new UserUpdateRequest("guest", "guest12");
        UserUpdateResponse response = userService.update(user, request);

        assertThat(request.getNickname()).isEqualTo(response.getNickname());
        assertThat(request.getPassword()).isEqualTo(response.getPassword());
    }

}