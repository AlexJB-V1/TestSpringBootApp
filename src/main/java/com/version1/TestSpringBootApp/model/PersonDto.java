package com.version1.TestSpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
    @JsonProperty("firstName")
    private String first;

    @JsonProperty("surname")
    private String second;
}
