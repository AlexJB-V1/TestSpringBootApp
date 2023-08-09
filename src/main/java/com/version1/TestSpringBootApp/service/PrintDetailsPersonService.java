package com.version1.TestSpringBootApp.service;

import com.version1.TestSpringBootApp.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PrintDetailsPersonService implements PersonService {
    @Override
    public void handlePersonData(Person person) {
        System.out.printf("Firstname: %s Surname: %s", person.getFirstName(), person.getSurname());
    }
}
