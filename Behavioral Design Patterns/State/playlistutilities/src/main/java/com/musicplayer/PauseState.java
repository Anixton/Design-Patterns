package com.musicplayer;

public class PauseState implements State {
    @Override
    public State play() {
        System.out.println("Resuming music.");
        return new PlayState();
    }

    @Override
    public State pause() {
        System.out.println("Already paused.");
        return this;
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
        System.out.println("Advancing music.");
        return new AdvanceState();
    }
}
