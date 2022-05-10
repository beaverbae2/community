package com.beaver.community.user;

import com.beaver.community.entity.User;
import com.beaver.community.repository.BoardRepository;
import com.beaver.community.repository.UserRespository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 회원 가입, 회원 정보 수정, 회원 탈퇴
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTest {
    @Autowired private UserRespository userRespository;

    @Test
    @DisplayName("회원 가입")
    void join() {
        // given
        User user = User.builder()
                .email("test@test.com")
                .password("as1234")
                .build();

        // when
        userRespository.save(user);

        // then
        User findUser = userRespository.findByEmail(user.getEmail()).orElseThrow();
        assertThat(user).isEqualTo(findUser);
    }
}