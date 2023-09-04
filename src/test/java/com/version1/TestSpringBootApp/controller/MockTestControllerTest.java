package com.version1.TestSpringBootApp.controller;

import com.version1.TestSpringBootApp.model.HandleCode;
import com.version1.TestSpringBootApp.service.PersonFactory;
import com.version1.TestSpringBootApp.service.PrintDetailsPersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
@AutoConfigureMockMvc
class MockTestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonFactory personFactory;

    private final static String CONTEXT_PATH = "/api/v1/test";

    @Test
    public void test() throws Exception {
        mockMvc.perform(
                get(CONTEXT_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));

    }

    @Test
    public void testPathMethod() throws Exception {
        Mockito.when(personFactory.returnService(HandleCode.PRINT)).thenReturn(new PrintDetailsPersonService());
        mockMvc.perform(
                post(CONTEXT_PATH + "/path/firstname/Alex/surname/Bloomfield-Smith/handleCode/NO_ACTION")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(content().string(containsString("Hello, World")));

    }

    @Test
    public void testExternalCall() throws Exception {
        Mockito.when(personFactory.returnService(HandleCode.PRINT)).thenReturn(new PrintDetailsPersonService());
        mockMvc.perform(
                        post(CONTEXT_PATH + "")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(content().string(containsString("Hello, World")));

    }


}