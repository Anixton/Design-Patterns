package com.musicplayer;

public class AdvanceState implements State{
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
        System.out.println("Rewinding music.");
        return new RewindState();
    }

    @Override
    public State advance() {
        System.out.println("Already advancing.");
        return this;
    }
}
