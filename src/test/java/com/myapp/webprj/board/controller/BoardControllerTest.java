package com.myapp.webprj.board.controller;

import com.myapp.webprj.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    void setMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void testList() throws Exception {

        ModelMap modelMap = mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap();

        System.out.println("modelMap = " + modelMap);

    }

    @Test
    void testRegister() throws Exception {

        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "새글을 씀")
                .param("content", "아무아무아무글")
                .param("writer", "또치"))
                .andReturn().getModelAndView().getViewName();

        System.out.println("resultPage = " + resultPage);

    }

    @Test
    void testGet() throws Exception {

        ModelMap bno = mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2"))
                .andReturn().getModelAndView().getModelMap();

        System.out.println("bno = " + bno);
    }


}