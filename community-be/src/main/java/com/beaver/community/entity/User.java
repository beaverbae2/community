package com.beaver.community.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 8, max = 20)
    private String password;

    @NotNull
    private Boolean statue;

    private LocalDateTime regTime;
    private LocalDateTime modTime;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.statue = true;
    }
}
