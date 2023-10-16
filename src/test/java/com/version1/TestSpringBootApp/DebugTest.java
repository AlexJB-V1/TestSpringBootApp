package com.version1.TestSpringBootApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.version1.TestSpringBootApp.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebugTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() {

        int assertValue = 0;

        Person p = new Person("test", "person");

        for (int i = 0; i < 10; i++) {
            p.setSurname("test" + i);
            System.out.println("surname = " + p.getSurname());
        }

        System.out.println("Print something");
        assertEquals("test9", p.getSurname());
    }
}
