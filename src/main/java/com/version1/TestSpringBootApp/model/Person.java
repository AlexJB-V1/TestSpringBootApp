package com.version1.TestSpringBootApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Length(min = 3, max = 35)
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Aa-Zz Only")
    private String surname;

    public Person() {
    }


    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Person(String firstName, String surname, int id) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
