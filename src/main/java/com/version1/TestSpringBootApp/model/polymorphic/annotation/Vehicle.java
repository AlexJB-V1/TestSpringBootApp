package com.version1.TestSpringBootApp.model.polymorphic.annotation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
public class Vehicle {

    public String type;

    // standard setters and getters

    @VehicleSubType("ELECTRIC_VEHICLE")
    public static class ElectricVehicle extends Vehicle {

        String autonomy;
        String chargingTime;

        // standard setters and getters
    }

    @VehicleSubType("FUEL_VEHICLE")
    public static class FuelVehicle extends Vehicle {

        String fuelType;
        String transmissionType;

        // standard setters and getters
    }
}
