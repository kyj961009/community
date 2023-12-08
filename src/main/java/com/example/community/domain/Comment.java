package com.example.community.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Long id;
    private Long boardId;
    private String nickname;
    private String comment;
}
