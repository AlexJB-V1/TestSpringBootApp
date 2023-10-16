package com.version1.TestSpringBootApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.version1.TestSpringBootApp.model.polymorphic.annotation.VehicleSubType;
import com.version1.TestSpringBootApp.model.polymorphic.standard.ElectricVehicle;
import com.version1.TestSpringBootApp.model.polymorphic.standard.Vehicle;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolymorphicDeserialisationTest {

    @Test
    public void whenDeserializingPolymorphic_thenCorrect() throws JsonProcessingException {
//        String json = "{\"jacksonValue\":\"ELECTRIC_VEHICLE\",\"autonomy\":\"500\",\"chargingTime\":\"200\"}";
        String jsonElec = "{\"jacksonValue\":\"ELECTRIC\",\"autonomy\":\"500\",\"chargingTime\":\"200\"}";
        String jsonFuel = "{\"jacksonValue\":\"FUEL\",\"fuelType\":\"petrol\",\"transmissionType\":\"auto\"}";
//        String json = "{\"type\":\"ELECTRIC_VEHICLE\",\"fuelType\":\"500\",\"transmissionType\":\"200\"}";

        Vehicle vehicle = new ObjectMapper().readValue(jsonElec, Vehicle.class);

//        System.out.println(vehicle);

        ElectricVehicle ev = (ElectricVehicle) vehicle;

        assertEquals(ElectricVehicle.class, vehicle.getClass());
    }

    private ObjectMapper getCustomObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        Reflections reflections = new Reflections("com.baeldung.jackson.polymorphicdeserialization.reflection");
        Set<Class<?>> subtypes = reflections.getTypesAnnotatedWith(VehicleSubType.class);

        for (Class<?> subType : subtypes) {
            VehicleSubType annotation = subType.getAnnotation(VehicleSubType.class);
            if (annotation != null) {
                String typeName = annotation.value();
                objectMapper.registerSubtypes(new NamedType(subType, typeName));
            }
        }

        return objectMapper;
    }

}
