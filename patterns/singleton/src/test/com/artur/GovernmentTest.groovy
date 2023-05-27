package com.artur


import spock.lang.Specification

class GovernmentTest extends Specification {

    def "should laws equals 0"() {
        expect:
        Government.lawsEnacted() == 0
    }

    def "should laws equals 1 when initialized"() {
        given:
        Government.getInstance()

        expect:
        Government.lawsEnacted() == 1
    }

    def "should laws contains law encanted"() {
        given:
        def government = Government.getInstance()

        when:
        def result = government.isEnacted("The government shall not break the constitution")

        then:
        result
    }

    def "should not add new law when duplicate"() {
        given:
        def government = Government.getInstance()

        when:
        government.enact("The government shall not break the constitution")

        then:
        Government.lawsEnacted() == 1
    }

    def "should add new law"() {
        given:
        def government = Government.getInstance()

        when:
        government.enact("The government shall not break the constitution 2")

        then:
        Government.lawsEnacted() == 2
    }

}
