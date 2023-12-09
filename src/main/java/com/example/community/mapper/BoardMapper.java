package com.example.community.mapper;

import com.example.community.domain.BoardVO;
import com.example.community.domain.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

@Mapper
public interface BoardMapper {
    // 모든 레코드 조회
    List<BoardVO> getList(Criteria criteria);

    // Criteria 객체 전달 받아 해당 페이지 게시물 목록 조회
    List<BoardVO> getListWithPaging(Criteria criteria);

    // CREATE
    void create(BoardVO boardVO);

    // CREATE id를 알필요가 있을때
    void createSelectKey(BoardVO boardVO);

    // READ
    BoardVO read(Long id);

    // UPDATE
    int update(BoardVO boardVO);

    // DELETE
    int delete(Long id);

    // 전체 게시물의 개수를 조회
    long getTotal(Criteria criteria);

    // 게시판 조회수
    long boardHit(Long id) throws Exception;
}
