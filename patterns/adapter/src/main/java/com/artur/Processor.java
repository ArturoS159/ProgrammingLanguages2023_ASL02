package com.artur;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private final Soundtrack soundTrack;
    private final List<SoundEffect> effects = new ArrayList<>();

    public Processor(Soundtrack soundTrack) {
        this.soundTrack = soundTrack;
    }

    public void addEffect(SoundEffect effect) {
        this.effects.add(effect);
    }

    public Soundtrack process() {
        Soundtrack modifiedSoundtrack = new Soundtrack(this.soundTrack.getSound());
        effects.forEach(effect -> effect.apply(modifiedSoundtrack));
        return modifiedSoundtrack;
    }
}
