package com.artur;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
            throw new RefuelException("Fuel level cannot be negative!");
        } else if (refueledCar.compareTo(BigDecimal.valueOf(tankCapacity)) > 0) {
            throw new RefuelException("Fuel level cannot more then fuelLevel: " + fuelLevel);
        }
        fuelLevel = refueledCar;
    }

    public void drive(int kilometers) {
        if(kilometers != 0){
            var fuelc = BigDecimal.valueOf(kilometers).divide(BigDecimal.valueOf(100),
                    RoundingMode.CEILING).multiply(fuelConsumption);
            if (fuelc.compareTo(fuelLevel) > 0){
                throw new NoFuelException();
            }
            dailyOdometer = kilometers;
            odometer += kilometers;
            fuelLevel = fuelLevel.subtract(fuelc);
        }
    }

}
