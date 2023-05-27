package com.artur

import com.artur.thirdparty.boss.BossDelayAdapter
import com.artur.thirdparty.boss.Delay
import com.artur.thirdparty.ibanez.Echolizer
import com.artur.thirdparty.ibanez.IbanezEchoizerAdapter
import spock.lang.Specification

class ProcessorTest extends Specification {

    def "should apply distortion effect"() {
        given:
        Processor processor = new Processor(new Soundtrack("Lalala"))
        processor.addEffect(new Distortion())

        when:
        def soundtrack = processor.process()

        then:
        soundtrack.sound == "Lalala Adding distortion as in Master of Puppets"
    }

    def "should apply boss effect"() {
        given:
        Delay delay = new Delay()
        delay.initialize()
        Processor processor = new Processor(new Soundtrack("Lalala"))
        processor.addEffect(new BossDelayAdapter(delay))

        when:
        def soundtrack = processor.process()

        then:
        soundtrack.sound == "Lalala Adding delay as in Run Like Hell"
    }

    def "should apply echolizer effect"() {
        given:
        Processor processor = new Processor(new Soundtrack("Lalala"))
        processor.addEffect(new IbanezEchoizerAdapter(new Echolizer(5)))

        when:
        def soundtrack = processor.process()

        then:
        soundtrack.sound == "Lalala Adding echo 1 Adding echo 2 Adding echo 3 Adding echo 4 Adding echo 5"
    }

    def "should mix thirdparty effects"() {
        given:
        Delay delay = new Delay()
        delay.initialize()
        Processor processor = new Processor(new Soundtrack("Lalala"))
        processor.addEffect(new IbanezEchoizerAdapter(new Echolizer(2)))
        processor.addEffect(new BossDelayAdapter(delay))

        when:
        def soundtrack = processor.process()

        then:
        soundtrack.sound == "Lalala Adding echo 1 Adding echo 2 Adding delay as in Run Like Hell"
    }
}
