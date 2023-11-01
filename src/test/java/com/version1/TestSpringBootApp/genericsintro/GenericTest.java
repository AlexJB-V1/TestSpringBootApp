package com.version1.TestSpringBootApp.genericsintro;

import com.version1.TestSpringBootApp.model.Person;
import com.version1.TestSpringBootApp.model.genericsintro.Container;
import com.version1.TestSpringBootApp.model.polymorphic.standard.ElectricVehicle;
import com.version1.TestSpringBootApp.model.polymorphic.standard.FuelVehicle;
import com.version1.TestSpringBootApp.model.polymorphic.standard.Vehicle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTest {

    @Test
    public void listTest() {

        List<String> stringList = new LinkedList<>();

        stringList.add("adsofisdfoina");
//        stringList.add(new Person());

        List<Person> personList = new ArrayList<>();
//        personList.add("adsofisdfoina");
        personList.add(new Person());

        Container<Vehicle> vehicleContainer = new Container<>();

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new FuelVehicle());
        vehicleList.add(new ElectricVehicle());

        vehicleContainer.setContentList(vehicleList);
    }

    @Test
    public void wildcards() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
//        integerList.add(3L);
        upperBoundWildcardFunction(integerList); // Method Call
//        abstractFunc(integerList); // Method Call
        lowerBoundWildcardFunction(integerList); // Method Call
        unboundWildcard(integerList);


        List<? extends Number> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(3L);
        upperBoundWildcardFunction(numbers); // Method Call
//        abstractFunc(numbers); // Method Call
//        lowerBoundWildcardFunction(numbers); // Method Call

        List<Float> floatList = new ArrayList<>();
//        lowerBoundWildcardFunction(floatList);
        upperBoundWildcardFunction(floatList);


        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2.0);
        numberList.add(3);
        numberList.add(3L);
        upperBoundWildcardFunction(numberList); // Method Call
        abstractFunc(numberList); // Method Call
        lowerBoundWildcardFunction(numberList); // Method Call
        unboundWildcard(numberList);

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
    }

    private void upperBoundWildcardFunction(List<? extends Number> numbers) {
        numbers
                .stream()
                .map(Number::intValue)
                .forEach(System.out::println);
    }

//    private void upperBoundWildcardFunction2(List<? extends Number> numbers) {
//        numbers
//                .stream()
//                .map(Integer::highestOneBit)
//                .forEach(System.out::println);
//    }
//
//    private void upperBoundWildcardFunction3(List<Integer> numbers) {
//        numbers
//                .stream()
//                .map(Integer::highestOneBit)
//                .forEach(System.out::println);
//    }

    private void lowerBoundWildcardFunction(List<? super Integer> numbers) {
        numbers.stream().map(Object::toString).forEach(System.out::println);
    }

    private void abstractFunc(List<Number> numbers) {
        numbers
                .stream()
                .map(Number::intValue)
                .forEach(System.out::println);
    }


    private void unboundWildcard(List<?> numbers) {
        numbers.stream().map(Object::toString).forEach(System.out::println);
    }


    @Test
    @Disabled
    public void wildcardVehicleTest() {

        Container<Vehicle> vehicleContainer = new Container<>();
        vehicleContainer.getContentList().add(new ElectricVehicle());
        vehicleContainer.getContentList().add(new FuelVehicle());
//        vehicleContainer.getContentList().add(new Vehicle());
        wildcardVehicleFunction(vehicleContainer);
        superclassVehicleFunction(vehicleContainer);

        Container<FuelVehicle> fuelVehicleContainer = new Container<>();
        fuelVehicleContainer.getContentList().add(new FuelVehicle());
//        fuelVehicleContainer.getContentList().add(new ElectricVehicle());
        wildcardVehicleFunction(fuelVehicleContainer);
//        superclassVehicleFunction(fuelVehicleContainer);
        fuel(fuelVehicleContainer);

        Container<ElectricVehicle> electricVehicleContainer = new Container<>();
        electricVehicleContainer.getContentList().add(new ElectricVehicle());
//        electricVehicleContainer.getContentList().add(new FuelVehicle());
        wildcardVehicleFunction(electricVehicleContainer);
//        superclassVehicleFunction(electricVehicleContainer);

    }

    private void wildcardVehicleFunction(Container<? extends Vehicle> vehicleContainer) {
        vehicleContainer
                .getContentList()
                .forEach(Vehicle::drive);
        // Vehicle Methods
    }

    private void superclassVehicleFunction(Container<Vehicle> vehicleContainer) {
        // Vehicle Methods
    }

    private void fuel(Container<FuelVehicle> vehicleContainer) {
        // Vehicle Methods
    }


}
