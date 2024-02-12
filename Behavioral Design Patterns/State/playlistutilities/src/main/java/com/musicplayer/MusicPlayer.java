package com.musicplayer;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private State state;
    private List<Music> playlist;
    private int currentTrack;
    private Boolean isPlaying;
    private Boolean isMusicPlayerOn;
    private Thread playThread;

    public MusicPlayer(List<Music> playlist) {
        this.state = new StopState();
        this.playlist = playlist;
        this.currentTrack = 0;
        this.isPlaying = false;
        this.isMusicPlayerOn = true;
    }

    public MusicPlayer() {
        this.state = new StopState();
        this.playlist = new ArrayList<Music>(); 
        this.currentTrack = 0;
        this.isPlaying = false;
        this.isMusicPlayerOn = true;
    }

    public int getMusicCount() {
        return this.playlist.size();
    }

    public void addMusic(Music music) {
        this.playlist.add(music);
    }

    public void removeMusic(Music music) {
        this.playlist.remove(music);
    }

    public boolean containsMusic(Music music) {
        if(playlist.contains(music)){
            return true;
        }
        return false;
    }

    public String getCurrentMusic() {
        if (this.playlist.isEmpty()) {
            return "No music in the playlist.";
        }
        return this.playlist.get(this.currentTrack).toString();
    }

    public void play() {
        if (getState() instanceof PlayState) {
            getCurrentMusic();
            return;
        }
        this.state = this.state.play();
        isPlaying = true;
        getCurrentMusic();

        // If a song is already playing, interrupt the thread
        if (playThread != null) {
            playThread.interrupt();
        }

        playThread = new Thread(() -> {
            try {
                Thread.sleep(playlist.get(currentTrack).getSeconds() * 1000);
                if (isPlaying) {
                    nextTrack();
                    System.out.println(getCurrentMusic());
                    play();
                }
            } catch (InterruptedException e) {
                // Don't do anything if the sleep is interrupted
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        });

        playThread.start();
    }

    public void pause() {
        this.state = this.state.pause();
        isPlaying = false;
    }

    public void stop() {
        this.state = this.state.stop();
        isMusicPlayerOn = false;
    }

    public void previousTrack() {
        if (currentTrack == 0) {
            System.out.println("No previous track.");
            return;
        } else {
            this.state = this.state.rewind();
            currentTrack--;
            play();
        }
    }

    public void nextTrack() {
        if (currentTrack == playlist.size() - 1) {
            System.out.println("No next track.");
            stop();
            return;
        }
        this.state = this.state.advance();
        currentTrack++;
        play();
    }

    public State getState() {
        return state;
    }

    public boolean isMusicPlayerOn() {
        return isMusicPlayerOn;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
