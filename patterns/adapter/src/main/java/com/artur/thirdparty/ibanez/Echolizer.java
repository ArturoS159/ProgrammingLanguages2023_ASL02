package com.artur.thirdparty.ibanez;

import com.artur.Soundtrack;

public class Echolizer {
    private final int echoLevel;

    public Echolizer(int echoLevel) {
        this.echoLevel = echoLevel;
    }

    public void echolize(Soundtrack soundtrack) {
        StringBuilder echoText = new StringBuilder();
        for (int echoNum = 0; echoNum < echoLevel; echoNum++) {
            echoText.append(" Adding echo ")
                    .append((echoNum + 1));
        }
        soundtrack.setSound(soundtrack.getSound() + echoText);
    }
}
