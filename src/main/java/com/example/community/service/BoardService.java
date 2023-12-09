package com.example.community.service;

import com.example.community.domain.BoardVO;
import com.example.community.domain.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {
    // CREATE
    void register(BoardVO boardVO);

    // READ
    BoardVO read(Long id) throws Exception;


    // UPDATE
    boolean update(BoardVO boardVO);

    // DELETE
    boolean delete(Long id);

    // 게시물 목록을 조회
    List<BoardVO> getList();

    List<BoardVO> getList(Criteria criteria);

    // 전체 게시물 개수 조회
    long getTotal(Criteria criteria);


}
