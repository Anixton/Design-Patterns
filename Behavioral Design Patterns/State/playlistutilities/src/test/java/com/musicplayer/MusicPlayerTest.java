package com.musicplayer;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MusicPlayerTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testDefaultConstructor() {
        MusicPlayer musicPlayer = new MusicPlayer();

        assertEquals(musicPlayer.isMusicPlayerOn(), true);
        assertEquals(musicPlayer.isPlaying(), false);
        assertEquals(musicPlayer.getMusicCount(), 0);
        assertTrue(musicPlayer.getState() instanceof StopState);
        assertEquals(musicPlayer.getCurrentMusic(),"No music in the playlist.");
    }

    @Test
    public void testContainsMusic() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Music music = new Music("Sacrifice","The Weeknd",200);
        musicPlayer.addMusic(music);

        assertTrue(musicPlayer.containsMusic(music));
    }

    @Test
    public void testPlay() {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play();
        assertTrue(musicPlayer.getState() instanceof PlayState);
        assertTrue(musicPlayer.isPlaying());
    }

    @Test
    public void testPause() {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play();
        musicPlayer.pause();
        assertTrue(musicPlayer.getState() instanceof PauseState);
        assertFalse(musicPlayer.isPlaying());
    }

    @Test
    public void testStop() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Music music1 = new Music("Blinding Lights", "The Weeknd", 201);
        Music music2 = new Music("Starboy", "The Weeknd", 230);
        Music music3 = new Music("Save Your Tears", "The Weeknd", 215);

        musicPlayer.addMusic(music1);
        musicPlayer.addMusic(music2);
        musicPlayer.addMusic(music3);


        musicPlayer.play();
        musicPlayer.stop();

        assertTrue(musicPlayer.getState() instanceof StopState);
        assertFalse(musicPlayer.isMusicPlayerOn());
    }

    @Test
    public void testNextTrack() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Music music1 = new Music("Blinding Lights", "The Weeknd", 201);
        Music music2 = new Music("Starboy", "The Weeknd", 230);
        Music music3 = new Music("Save Your Tears", "The Weeknd", 215);

        musicPlayer.addMusic(music1);
        musicPlayer.addMusic(music2);
        musicPlayer.addMusic(music3);


        musicPlayer.play();
        assertEquals(music1.toString(),musicPlayer.getCurrentMusic());

        musicPlayer.nextTrack();
        assertEquals(music2.toString(),musicPlayer.getCurrentMusic());

        musicPlayer.nextTrack();
        assertEquals(music3.toString(),musicPlayer.getCurrentMusic());

        musicPlayer.nextTrack();
        String expectedOutContent = "Starting music.\r\n"+
                                    "Advancing music.\r\n"+
                                    "Starting music.\r\n"+
                                    "Advancing music.\r\n"+
                                    "Starting music.\r\n"+
                                    "No next track.\r\n"+
                                    "Stopping music.\r\n";

        assertEquals(expectedOutContent, outContent.toString());

    }

    @Test
    public void testPreviousTrack() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Music music1 = new Music("Blinding Lights", "The Weeknd", 201);
        Music music2 = new Music("Starboy", "The Weeknd", 230);
        Music music3 = new Music("Save Your Tears", "The Weeknd", 215);

        musicPlayer.addMusic(music1);
        musicPlayer.addMusic(music2);
        musicPlayer.addMusic(music3);

        musicPlayer.play();
        musicPlayer.nextTrack();
        musicPlayer.nextTrack();

        assertEquals(music3.toString(),musicPlayer.getCurrentMusic());
        musicPlayer.previousTrack();

        assertEquals(music2.toString(),musicPlayer.getCurrentMusic());
        musicPlayer.previousTrack();

        assertEquals(music1.toString(),musicPlayer.getCurrentMusic());
        
        musicPlayer.previousTrack();
        String expectedOutContent = "Starting music.\r\n" +
                            "Advancing music.\r\n" +
                            "Starting music.\r\n" +
                            "Advancing music.\r\n" +
                            "Starting music.\r\n" +
                            "Rewinding music.\r\n" +
                            "Starting music.\r\n" +
                            "Rewinding music.\r\n" +
                            "Starting music.\r\n" +
                            "No previous track.\r\n";

        assertEquals(expectedOutContent, outContent.toString());
    }



}
