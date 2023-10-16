package com.version1.TestSpringBootApp.model.polymorphic.standard;

import lombok.Data;

@Data
public class FuelVehicle extends Vehicle {

    // type

    String fuelType;
    String transmissionType;
}
