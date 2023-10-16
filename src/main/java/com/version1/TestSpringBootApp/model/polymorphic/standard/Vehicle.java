package com.version1.TestSpringBootApp.model.polymorphic.standard;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "jacksonValue", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ElectricVehicle.class, name = "ELECTRIC"),
        @JsonSubTypes.Type(value = FuelVehicle.class, name = "FUEL")
})
public class Vehicle {
    public String jacksonValue;
}

    // common behaviour - wheelCount; price;

    // standard setters and getters
