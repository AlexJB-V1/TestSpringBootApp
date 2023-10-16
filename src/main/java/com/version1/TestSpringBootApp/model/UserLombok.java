package com.version1.TestSpringBootApp.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class UserLombok {

    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;

}
