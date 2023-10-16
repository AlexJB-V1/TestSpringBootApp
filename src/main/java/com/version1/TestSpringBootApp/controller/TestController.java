package com.version1.TestSpringBootApp.controller;

import com.version1.TestSpringBootApp.model.HandleCode;
import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.model.polymorphic.standard.ElectricVehicle;
import com.version1.TestSpringBootApp.model.polymorphic.standard.FuelVehicle;
import com.version1.TestSpringBootApp.model.polymorphic.standard.Vehicle;
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

    @PostMapping("vehicle")
    public String testPath(@RequestBody Vehicle v) { // electric, fuel, hydrogen, aeroplane
//        switch (v) {
//            ElectricVehicle.class ->{// do something}
//            FuelVehicle.class ->{// do something else}
//            else{
//                        // something else
//                    }
//            }
//            }
        if (v.getClass() == ElectricVehicle.class) {
            // do some electric stuff
        } else if (v.getClass() == FuelVehicle.class) {
            // fuel stuff
        }
        return "";
    }

    private void printType(Vehicle v) {
        System.out.println(v.jacksonValue);
    }
}
