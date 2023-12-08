package com.example.community.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.lang.model.type.PrimitiveType;

import static java.lang.Math.ceil;

@Getter
@ToString
public class PageMaker {
    private long total;

    private Criteria criteria;

    private int pagesPerViewPort;

    private int lastPage;

    private int startPage;

    private int endPage;

    private boolean prev;

    private boolean next;

    public PageMaker(Criteria criteria, long total, int pagesPerViewPort) {
        this.criteria = criteria;
        this.total = total;
        this.pagesPerViewPort = pagesPerViewPort;

        lastPage = (int)Math.ceil((double) total / criteria.getRowsPerPage());

        endPage = (int)Math.ceil((double) criteria.getPage()/pagesPerViewPort) * pagesPerViewPort;

        startPage = (endPage - pagesPerViewPort) + 1;

        if (startPage <= 0) startPage = 1;

        if (lastPage < endPage) endPage = lastPage;

        prev = startPage > 1;

        next = endPage < lastPage;
    }
    public PageMaker(Criteria criteria, long total) {
        this(criteria, total, 10);
    }


}
