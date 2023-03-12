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

    def "should refuel car"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 15.2, 50)

        when:
        car.refuel(BigDecimal.valueOf(liters))

        then:
        noExceptionThrown()
        car.getFuelLevel() == fuelLevel

        where:
        liters | fuelLevel
        49     | 49
        50     | 50
        0      | 0
    }

    def "should not refuel car when provided incorrect value"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 15.2, 50)

        when:
        car.refuel(BigDecimal.valueOf(liters))

        then:
        thrown(RefuelException)
        car.getFuelLevel() == fuelLevel

        where:
        liters | fuelLevel
        51     | 0
        -1     | 0
    }

    def "should not refuel car refuel more then tank capacity"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 15.2, 50)

        when:
        car.refuel(BigDecimal.valueOf(49))
        car.refuel(BigDecimal.valueOf(2))

        then:
        thrown(RefuelException)
    }
}
