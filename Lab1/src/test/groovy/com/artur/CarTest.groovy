package com.artur

import spock.lang.Specification

class CarTest extends Specification {

    def "should create car with correct parameters"() {
        when:
        var car = new Car(CarColor.RED, CarMake.LEXUS, 11.6, 55)

        then:
        car.color == CarColor.RED
        car.make == CarMake.LEXUS
        car.fuelConsumption == 11.6
        car.tankCapacity == 55
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

    def "should car properly calculate fuel consumption and fuel level"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, fuelConsumption, tankCapacity)
        car.refuel(BigDecimal.valueOf(fuelInCar))

        when:
        car.drive(kilometers)
        car.drive(additionalKilometers)

        then:
        with(car) {
            dailyOdometer == dailyOdometrExpect
            odometer == odometerExpect
            fuelLevel == fuelLevelExpect
        }

        where:
        fuelConsumption | tankCapacity | fuelInCar | kilometers | additionalKilometers | dailyOdometrExpect | odometerExpect | fuelLevelExpect
        15.2            | 50           | 50        | 100        | 0                    | 100                | 100            | 34.8
        10.0            | 11           | 11        | 100        | 0                    | 100                | 100            | 1
        12.6            | 55           | 55        | 100        | 200                  | 200                | 300            | 17.2
        8.4             | 100          | 100       | 200        | 300                  | 300                | 500            | 58.0
        10.0            | 10           | 10        | 100        | 0                    | 100                | 100            | 0
    }

    def "should car not drive when fuel in tank capacity is empty"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 5.0, 5)
        car.refuel(BigDecimal.valueOf(5))

        when:
        car.drive(101)

        then:
        thrown(NoFuelException)
    }

    def "should car restart daily odometer when it extends size"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 5.0, 50)
        car.refuel(BigDecimal.valueOf(50))

        when:
        car.drive(kilometers)

        then:
        car.dailyOdometer == dailyOdometerExpect

        where:
        kilometers | dailyOdometerExpect
        999        | 999
        1000       | 1
    }

    def "should car restart odometer when it extends size"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 0.1, 1000)
        car.refuel(BigDecimal.valueOf(1000))

        when:
        car.drive(kilometers)

        then:

        car.odometer == odometerExpect
        car.dailyOdometer == dailyOdometerExpect

        where:
        kilometers | odometerExpect | dailyOdometerExpect
        999999     | 999999         | 999
        1000000    | 1              | 1
        3050       | 3050           | 53
    }

    def "should restart daily odometer"() {
        given:
        var car = new Car(CarColor.BLUE, CarMake.AUDI, 10.0, 50)
        car.refuel(BigDecimal.valueOf(50))
        car.drive(100)

        when:
        car.resetDailyOdometer()

        then:
        car.dailyOdometer == 0
        car.odometer == 100
    }
}
