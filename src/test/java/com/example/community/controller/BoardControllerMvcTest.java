package com.example.community.controller;

import com.example.community.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardController.class)
public class BoardControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/community/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
