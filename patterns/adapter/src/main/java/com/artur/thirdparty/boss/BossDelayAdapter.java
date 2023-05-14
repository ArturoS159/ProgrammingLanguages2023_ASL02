package com.artur.thirdparty.boss;

import com.artur.SoundEffect;
import com.artur.Soundtrack;

public class BossDelayAdapter implements SoundEffect {
    private final Delay delay;

    public BossDelayAdapter(Delay delay) {
        this.delay = delay;
    }

    @Override
    public void apply(Soundtrack soundtrack) {
        delay.addDelay(soundtrack);
    }
}
