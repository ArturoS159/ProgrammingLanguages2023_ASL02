package com.artur;

public class Car {
    private CarColor color;
    private CarMake make;
    private double fuelConsumption;
    private int tankCapacity;

    public Car(CarColor colorr, CarMake make, double fuel, int tankCapacity) {
        this.color = colorr;
        this.make = make;
        this.fuelConsumption = fuel;
        this.tankCapacity = tankCapacity;
    }

    public CarColor getColor() {
        return color;
    }

    public CarMake getMake() {
        return make;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }
}
