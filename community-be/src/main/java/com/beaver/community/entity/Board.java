package com.beaver.community.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String contents;

    @NotNull
    private Boolean status;

    private LocalDateTime regTime;
    private LocalDateTime modTime;

    @Builder
    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.status = true;
    }
}
