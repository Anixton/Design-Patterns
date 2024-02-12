package com.musicplayer;

public class PlayState implements State {
    public State play() {
        System.out.println("Already playing music.");
        return this;
    }

    public State pause() {
        System.out.println("Pausing music.");
        return new PauseState();
    }

    public State stop() {
        System.out.println("Stopping music.");
        return new StopState();
    }

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
