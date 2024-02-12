package com.musicplayer;

public class StopState implements State {
    @Override
    public State play() {
        System.out.println("Starting music.");
        return new PlayState();
    }

    @Override
    public State pause() {
        System.out.println("Can't pause. Music is already stopped.");
        return this;
    }

    @Override
    public State stop() {
        System.out.println("Already stopped.");
        return this;
    }

    @Override
    public State rewind() {
        System.out.println("Rewinding music.");
        return new RewindState();
    }

    @Override
    public State advance() {
        System.out.println("Advancing music.");
        return new AdvanceState();
    }
}