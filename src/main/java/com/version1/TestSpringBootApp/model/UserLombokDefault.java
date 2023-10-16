package com.version1.TestSpringBootApp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserLombokDefault {

    private String firstName;
    @Builder.Default private String lastName = "";
    @Builder.Default private Integer age = 0;
    private String phone;
    private String address;
}
