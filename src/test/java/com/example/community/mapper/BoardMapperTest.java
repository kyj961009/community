package com.example.community.mapper;

import com.example.community.domain.BoardVO;
import com.example.community.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardMapperTest {
    @Autowired
    private BoardMapper mapper;

    @Autowired
    private BoardService service;

    @Test
    public void testGetList() {
        List<BoardVO> list = service.getList();


        for(BoardVO item : list) {
            log.info("item = {}", item);
        }
    }


}