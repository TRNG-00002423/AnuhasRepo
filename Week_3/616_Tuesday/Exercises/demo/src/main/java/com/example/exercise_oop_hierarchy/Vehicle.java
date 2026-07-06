package com.example.exercise_oop_hierarchy;

/**
 * TODO: abstract Vehicle — encapsulate fields, declare abstract cost method.
 */

public abstract class Vehicle {
    // TODO private fields + ctor + getters

    private String make;
    private int modelYear;

    

    

    public Vehicle(String make, int modelYear) {
        this.make = make;
        this.modelYear = modelYear;
    }



    public String getMake() {
        return make;
    }



    public void setMake(String make) {
        this.make = make;
    }



    public int getModelYear() {
        return modelYear;
    }



    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }



    public abstract double fuelCostPer100Km();

}
