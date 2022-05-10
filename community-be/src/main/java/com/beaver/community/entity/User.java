package com.beaver.community.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "USER")
    private List<Board> boards;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.statue = true;
    }
}
