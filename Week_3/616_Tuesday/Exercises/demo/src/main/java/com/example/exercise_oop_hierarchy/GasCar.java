package com.example.exercise_oop_hierarchy;

public class GasCar extends Vehicle{
    // TODO fields: e.g. litersPer100Km, pricePerLiter
    private int milesPerGallon;
    private double pricePerLiter;

    

    public GasCar(String make, int modelYear) {
        super(make, modelYear);
    }



    public GasCar(String make, int modelYear, int milesPerGallon, double pricePerLiter) {
        super(make, modelYear);
        this.milesPerGallon = milesPerGallon;
        this.pricePerLiter = pricePerLiter;
    }

    

    public double getPricePerLiter() {
        return pricePerLiter;
    }



    public void setPricePerLiter(int pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }



    @Override
    public double fuelCostPer100Km() {
        float numberOfLiters = 1000/milesPerGallon;
        double costPer1000km = pricePerLiter * numberOfLiters;
        return costPer1000km;
    }

}


