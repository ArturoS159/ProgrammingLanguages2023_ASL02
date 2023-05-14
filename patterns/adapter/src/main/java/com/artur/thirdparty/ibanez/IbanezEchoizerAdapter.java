package com.artur.thirdparty.ibanez;

import com.artur.SoundEffect;
import com.artur.Soundtrack;

public class IbanezEchoizerAdapter implements SoundEffect {
    private final Echolizer echolizer;

    public IbanezEchoizerAdapter(Echolizer echolizer) {
        this.echolizer = echolizer;
    }

    @Override
    public void apply(Soundtrack soundtrack) {
        echolizer.echolize(soundtrack);
    }
}
