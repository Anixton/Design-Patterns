package com.musicplayer;

public class RewindState implements State {
    @Override
    public State play() {
        System.out.println("Starting music.");
        return new PlayState();
    }

    @Override
    public State pause() {
        System.out.println("Pausing music.");
        return new PauseState();
    }

    @Override
    public State stop() {
        System.out.println("Stopping music.");
        return new StopState();
    }

    @Override
    public State rewind() {
        System.out.println("Already rewinding.");
        return this;
    }

    @Override
    public State advance() {
        System.out.println("Advancing music.");
        return new AdvanceState();
    }
}
