package com.example.community.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class BoardControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/community/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testList2() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/community/list");

        ModelMap modelMap = Objects.requireNonNull(mockMvc.perform(builder)
                .andReturn()
                .getModelAndView()).getModelMap();

        log.info("modelMap = {}", modelMap);
    }

    @Test
    public void testRead() throws Exception {
        mockMvc.perform(get("/community/read")
                .param("id","60"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testWrite() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/community/write")
                .param("title","[TEST] BoardControllerTest#testWrite")
                .param("content","[TEST] BoardControllerTest#testWrite")
                .param("writer","ADMIN");

        mockMvc.perform(builder)
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

    @Test
    public void testUpdate() throws Exception {
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders.post("/community/update")
                .param("id","60")
                .param("title","[TEST] BoardControllerTest#testUpdate")
                .param("content","BoardControllerTest#testUpdate")
                .param("writer","ADMIN");
        mockMvc.perform(builders)
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

    @Test
    public void testDelete() throws Exception {
        // MockMvc 객체의 perform 메서드로 요청 수행
        mockMvc.perform(get("/community/delete").param("id","91"))
                .andExpect(status().is3xxRedirection())         // 응답 상태 코드(302) 검증
                .andDo(print());                                // 요청과 응답 결과를 출력
    }
}