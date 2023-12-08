package com.example.community.domain;


import lombok.Data;

import java.sql.Date;

@Data
public class BoardVO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updatedate;
}
