package com.artur.thirdparty.boss;

import com.artur.Soundtrack;

public class Delay {

    private boolean initialized;

    public void initialize() {
        this.initialized = true;
    }

    public void addDelay(Soundtrack soundTrack) {
        if (initialized) {
            soundTrack.setSound(soundTrack.getSound() + " Adding delay as in Run Like Hell");
        }
    }
}
