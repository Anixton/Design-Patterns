package com.musicplayer;

public class Music {
    private String name;
    private String artist;
    private int seconds;

    public Music(String name, String artist, int seconds) {
        this.name = name;
        this.artist = artist;
        this.seconds = seconds;
    }

    public Music() {
        this.name = "Unknown";
        this.artist = "Unknown";
        this.seconds = 0;
    }   

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return "Music: " + name + " by " + artist + " - " + seconds + " seconds";
    }
}
