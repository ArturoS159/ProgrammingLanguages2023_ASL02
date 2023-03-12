package com.artur

import spock.lang.Specification

class CarTest extends Specification {

    def "should create car with correct parameters"() {
        when:
        var car = new Car(CarColor.RED, CarMake.LEXUS, 11.6, 55)

        then:
        car.getColor() == CarColor.RED
        car.getMake() == CarMake.LEXUS
        car.getFuelConsumption() == 11.6
        car.getTankCapacity() == 55
    }
}
