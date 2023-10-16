package com.version1.TestSpringBootApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.model.PersonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.Instant;

@SpringBootTest
public class JacksonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void serialise() throws JsonProcessingException { // write as string from object
        Person p = new Person("foo", "bar", Date.from(Instant.now()));
        System.out.println(objectMapper.writeValueAsString(p));
    }

    @Test
    public void deserialise() throws JsonProcessingException {
        String personString = "{\"firstName\":1,\"surname\":\"bar\",\"dob\":\"2023-10-04T12:20:56.340+00:00\"}";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        PersonDto p = objectMapper.readValue(personString, PersonDto.class);
        System.out.println("The persons first name is " + p.getFirst() + " and surname is " + p.getSecond());
    }
}
