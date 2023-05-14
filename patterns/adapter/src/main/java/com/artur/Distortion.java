package com.artur;

public class Distortion implements SoundEffect {
    @Override
    public void apply(Soundtrack soundtrack) {
        soundtrack.setSound(soundtrack.getSound() + " Adding distortion as in Master of Puppets");
    }
}
