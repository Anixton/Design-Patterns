package com.musicplayer;

public interface State {
    public State play();
    public State pause();
    public State stop();
    public State rewind();
    public State advance();
}
