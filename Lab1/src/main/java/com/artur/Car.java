package com.artur;

import java.math.BigDecimal;

public class Car {
    private final CarColor color;
    private final CarMake make;
    private final BigDecimal fuelConsumption;
    private final int tankCapacity;
    private BigDecimal fuelLevel;
    private int odometer;
    private int dailyOdometer;

    public Car(CarColor color, CarMake make, BigDecimal fuelConsumption, int tankCapacity) {
        this.color = color;
        this.make = make;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.fuelLevel = BigDecimal.ZERO;
    }

    public CarColor getColor() {
        return color;
    }

    public CarMake getMake() {
        return make;
    }

    public BigDecimal getFuelConsumption() {
        return fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public BigDecimal getFuelLevel() {
        return fuelLevel;
    }

    public int getOdometer() {
        return odometer;
    }

    public int getDailyOdometer() {
        return dailyOdometer;
    }

    public void refuel(BigDecimal fuel) {
        BigDecimal refueledCar = fuelLevel.add(fuel);
        if (refueledCar.compareTo(BigDecimal.ZERO) < 0) {
            throw new RefuelException();
        } else if (refueledCar.compareTo(BigDecimal.valueOf(tankCapacity)) > 0) {
            throw new RefuelException();
        }
        fuelLevel = refueledCar;
    }
}
