package com.version1.TestSpringBootApp.service;

import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveToDBPersonService implements PersonService {

    private final PersonRepository personRepository;

    public SaveToDBPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void handlePersonData(Person person) {
        personRepository.save(person);
    }
}
