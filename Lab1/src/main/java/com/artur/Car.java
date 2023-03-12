package com.artur;

import java.math.BigDecimal;

public class Car {
    private final CarColor color;
    private final CarMake make;
    private final BigDecimal fuelConsumption;
    private final int tankCapacity;

    public Car(CarColor color, CarMake make, BigDecimal fuelConsumption, int tankCapacity) {
        this.color = color;
        this.make = make;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
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
}
