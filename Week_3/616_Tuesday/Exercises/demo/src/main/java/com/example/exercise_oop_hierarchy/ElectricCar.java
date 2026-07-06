package com.example.exercise_oop_hierarchy;

public class ElectricCar extends Vehicle implements AutonomousCapable{
    // TODO fields: e.g. kWhPer100Km, pricePerKWh
    private int batteryCapacityKWh;
    private int kWhPer100Km;
    private double pricePerKwh;
    private boolean SelfDriveCapable;


    



    // public ElectricCar(String make, int modelYear) {
    //     super(make, modelYear);
    // }



    


    public ElectricCar(String make, int modelYear, int batteryCapacityKWh, int kWhPer100Km, double pricePerKwh, boolean SelfDriveCapable) {
        super(make, modelYear);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.kWhPer100Km = kWhPer100Km;
        this.pricePerKwh = pricePerKwh;
        this.SelfDriveCapable = SelfDriveCapable;
    }


    




    public int getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }






    public int getkWhPer100Km() {
        return kWhPer100Km;
    }






    public void setkWhPer100Km(int kWhPer100Km) {
        this.kWhPer100Km = kWhPer100Km;
    }






    public double getPricePerKwh() {
        return pricePerKwh;
    }






    public void setPricePerKwh(int pricePerKwh) {
        this.pricePerKwh = pricePerKwh;
    }




    

    public boolean isSelfDriveCapable() {
        return SelfDriveCapable;
    }






    public void setSelfDriveCapable(boolean selfDriveCapable) {
        SelfDriveCapable = selfDriveCapable;
    }






    @Override
    public double fuelCostPer100Km() {
        double costPer1000km = pricePerKwh * kWhPer100Km;
        return costPer1000km;
    }






    @Override
    public boolean supportsSelfDrive() {
        if (this.isSelfDriveCapable()==true) {
            System.out.println("This Vehicle Supports Self Drive !");
            return true;
        } else {
            System.out.println("This Vehicle DOES NOT Support Self Drive.");
        }
        return false;
    }

}
