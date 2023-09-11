package com.version1.TestSpringBootApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.version1.TestSpringBootApp.model.HandleCode;
import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.service.PersonFactory;
import com.version1.TestSpringBootApp.service.PrintDetailsPersonService;
import com.version1.TestSpringBootApp.service.SaveToDBPersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
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

    @Mock
    private PrintDetailsPersonService printDetailsPersonService;
    @Mock
    private SaveToDBPersonService saveToDBPersonService;

    ObjectMapper objectMapper = new ObjectMapper();

    private final static String CONTEXT_PATH = "/api/v1/test";

    @Test
    public void testGetMapping() throws Exception {
        mockMvc.perform(
                get(CONTEXT_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));

    }

    @ParameterizedTest
    @EnumSource(HandleCode.class)
    public void testPostMapping(HandleCode code) throws Exception {
        when(personFactory.returnService(code))
                .thenReturn(code == HandleCode.database ? saveToDBPersonService : printDetailsPersonService);
        MvcResult result = mockMvc.perform(
                        post(CONTEXT_PATH+ "/path/firstname/John/surname/Doe/handleCode/" + code)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();

        Person outputPerson = objectMapper.readValue(resultAsString, Person.class);

        assertNotNull(outputPerson);
        assertEquals("John", outputPerson.getFirstName());
        assertEquals("Doe", outputPerson.getSurname());

    }

}