package com.version1.TestSpringBootApp.service;

import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class ReverseService implements PersonService {

    PersonRepository personRepository;

    public ReverseService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public void handlePersonData(Person person) {
        person.setFirstName(reverse(person.getFirstName()));
        person.setSurname(reverse(person.getSurname()));
        personRepository.save(person);
    }

    public String reverse(String in){
        in = in.toLowerCase();
        Stack<Character> stack = new Stack<>();
        StringBuilder out = new StringBuilder();
        for (Character c: in.toCharArray()) {stack.push(c);}
        while (!stack.empty()){out.append(stack.pop());}
        out.replace(0,1, out.substring(0,1).toUpperCase());
        return out.toString();
    }

}
