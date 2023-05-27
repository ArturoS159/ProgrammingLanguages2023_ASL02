package com.artur;

import com.artur.builder.*;
import com.artur.engine.Engine;

public class Car {
    private String brand;
    private String model;
    private Color color;
    private double fuelConsumption;
    private int fuelTankCapacity;
    private Engine engine;

    public static BrandSetter builder() {
        return new CarBuilder();
    }

    public Car(String brand, String model, Color color, double fuelConsumption, int fuelTankCapacity, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.fuelTankCapacity = fuelTankCapacity;
        this.engine = engine;
    }

    public static class CarBuilder implements BrandSetter, ModelSetter, ColorSetter, FuelSetter, TankSetter, EngineSetter, Builder {

        private String brand;
        private String model;
        private Color color;
        private double fuelConsumption;
        private int fuelTankCapacity;
        private Engine engine;

        private CarBuilder() {
        }

        @Override
        public ColorSetter model(String brand) {
            this.brand = brand;
            return this;
        }

        @Override
        public ModelSetter brand(String model) {
            this.model = model;
            return this;
        }

        @Override
        public FuelSetter color(Color color) {
            this.color = color;
            return this;
        }

        @Override
        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        @Override
        public TankSetter fuelConsumption(double fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        @Override
        public EngineSetter tank(int fuelTankCapacity) {
            this.fuelTankCapacity = fuelTankCapacity;
            return this;
        }

        @Override
        public Car build() {
            return new Car(
                    brand,
                    model,
                    color,
                    fuelConsumption,
                    fuelTankCapacity,
                    engine
            );
        }
    }

}
