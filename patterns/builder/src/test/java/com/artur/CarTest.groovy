package com.artur

import com.artur.engine.DiselEngine
import spock.lang.Specification

class CarTest extends Specification {

    def "should test step builder"() {
        given:
        def car = Car.builder()
        .brand("Audi")
        .model("A3")
        .color(Color.PINK)\
        .fuelConsumption(12.2)
        .tank(32)
        .engine(new DiselEngine())
        .build()

        expect:
        car != null
    }

}
