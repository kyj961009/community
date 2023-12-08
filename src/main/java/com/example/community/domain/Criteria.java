package com.example.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
    // 현재 페이지
    private int page;

    // 페이지당 보여줄 게시물의 수
    private int rowsPerPage;

    public Criteria() {
        this(1,10);
    }
}
