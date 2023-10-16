package com.version1.TestSpringBootApp.model.polymorphic.standard;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ElectricVehicle extends Vehicle {

    // type

    String autonomy;
    String chargingTime;
}
