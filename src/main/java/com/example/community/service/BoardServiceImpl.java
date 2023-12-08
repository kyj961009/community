package com.example.community.service;

import com.example.community.domain.BoardVO;
import com.example.community.domain.Criteria;
import com.example.community.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper mapper;

    @Override
    public void register(BoardVO boardVO) {
        log.info("register = {}", boardVO);

        mapper.createSelectKey(boardVO);
    }

    @Override
    public BoardVO get(Long id) {
        log.info("id = {}", id);

        return mapper.read(id);
    }

    @Override
    public boolean update(BoardVO boardVO) {
        log.info("register = {}", boardVO);

        return mapper.update(boardVO) == 1;
    }

    @Override
    public boolean delete(Long id) {
        log.info("delete = {}", id);
        return mapper.delete(id) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        log.info("getList");
        return mapper.getList(new Criteria(3,10));
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("getList with criteria={}", criteria);
        return mapper.getListWithPaging(criteria);
    }

    @Override
    public long getTotal(Criteria criteria) {
        log.info("getTotal = {}", criteria);

        return mapper.getTotal(criteria);
    }
}
