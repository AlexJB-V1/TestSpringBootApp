package com.version1.TestSpringBootApp;

import com.version1.TestSpringBootApp.model.User;
import com.version1.TestSpringBootApp.model.UserLombok;
import com.version1.TestSpringBootApp.model.UserLombokDefault;
import com.version1.TestSpringBootApp.model.UserOptional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    @Disabled
    public void builderTest() {

        UserOptional u = new UserOptional.UserBuilder()
                .firstName("Alex")
                .build();

        System.out.println("Users Last Name as lower case " + u.getLastName().toLowerCase());
    }

    @Test
    public void builderTest2() {
        User u = new User.UserBuilder("Alex", "Bloomfield")
                .age(23)
                .build();

        System.out.println("Users Last Name as lower case " + u.getLastName().toLowerCase());
    }

    @Test
    public void builderTest3() {
        UserLombok u = UserLombok
                .builder()
                .firstName("Alex")
                .build();

        System.out.println("Users Last Name as lower case " + u.getLastName().toLowerCase());
    }

    @Test
    public void builderTest4() {
        UserLombokDefault u = UserLombokDefault.builder().firstName("Alex").lastName("Bloomfield").build();

        System.out.println("Users Last Name as lower case " + u.getLastName().toLowerCase());
    }

}
