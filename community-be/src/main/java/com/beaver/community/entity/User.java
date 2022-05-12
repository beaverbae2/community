package com.beaver.community.entity;

import com.beaver.community.model.user.UserUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    @Column(length = 20)
    private String nickName;

    @NotNull
    @Column(length = 20)
    private String password;

    @NotNull
    private Boolean statue;

    private LocalDateTime regTime;
    private LocalDateTime modTime;

    @OneToMany(mappedBy = "user")
    private List<Board> boards;

    @Builder
    public User(String email, String nickName, String password) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.statue = true;
    }

    public User update(UserUpdateRequest request) {
        this.nickName = request.getNickname();
        this.password = request.getPassword();

        return this;
    }

}
