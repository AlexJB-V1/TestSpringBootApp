package com.version1.TestSpringBootApp.service;

import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class ImplementationService implements PersonService {

    private final PersonRepository personRepository;

    public ImplementationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void handlePersonData(Person person) {
        personRepository.save(person);


    }
}
