package com.version1.TestSpringBootApp.controller;

import com.version1.TestSpringBootApp.model.HandleCode;
import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.repository.PersonRepository;
import com.version1.TestSpringBootApp.service.PersonFactory;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final PersonFactory personFactory;

    public TestController(PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    @GetMapping
    public String testController() {
        return "Hello, World";
    }

    @PostMapping("/path/firstname/{firstName}/surname/{surname}/handleCode/{handleCode}")
    public Person testPath(
            @PathVariable String firstName,
            @PathVariable String surname,
            @PathVariable HandleCode handleCode
    ) {
        Person person = new Person(firstName, surname);
        personFactory.returnService(handleCode).handlePersonData(person);

        return person;
    }

}
