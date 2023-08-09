package com.version1.TestSpringBootApp.controller;

import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.repository.PersonRepository;
import com.version1.TestSpringBootApp.service.PersonFactory;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
        return "Hello Everyone";
    }

//    @PostMapping
//    @Transactional
//    public Person testPostController(@RequestBody @Valid Person person) {
//        //never hit this line
//        Person p = personRepository.save(person); // throws new Database error
//
//        System.out.println(p.getFirstName() + " " + p.getSurname());
//        return p;
//    }

    @PostMapping("/path/firstname/{firstName}/surname/{surname}/handleCode/{handleCode}")
    public Person testPath(
            @PathVariable String firstName,
            @PathVariable String surname,
            @PathVariable String handleCode
    ) {
        Person person = new Person(firstName, surname);
        personFactory.returnService(handleCode).handlePersonData(person);
        return person;
    }

//    @PostMapping("/requestParam")
////    @PostMapping("{firstName}/{surname}")
//    public Person testVariable(
//            @RequestParam String firstName,
//            @RequestParam String surname
//    ) {
//        personFactory.
//
//    }

}
