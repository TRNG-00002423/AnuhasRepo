package com.example.exercise_oop_hierarchy;

import java.util.ArrayList;
import java.util.List;


public class VehicleDemo {


    public static void main(String[] args) {
        // TODO: add GasCar, ElectricCar, optionally one that implements AutonomousCapable
        // TODO: polymorphic loop + instanceof demo
        System.out.println("Hello world!");
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new GasCar("Honda Civic", 2026, 47, 3.80));
        fleet.add(new GasCar("Volkswagen Jetta", 2025, 52, 3.9));

        fleet.add(new ElectricCar("Ford Mustang", 2025, 73, 180, 2.39, true));
        fleet.add(new ElectricCar("Nissan LEAF", 2026, 50, 175, 2.59, true));

        fleet.forEach(vehicle -> System.out.printf("Cost per 1000 km : $%.2f%n"+vehicle.fuelCostPer100Km()));
    }


}
