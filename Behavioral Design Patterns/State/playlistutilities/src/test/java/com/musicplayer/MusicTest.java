package com.musicplayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MusicTest {
    @Test
    public void testDefaultConstructor() {
        Music music = new Music();
        assertEquals("Unknown", music.getName());
        assertEquals("Unknown", music.getArtist());
        assertEquals(0, music.getSeconds());
    }

    @Test
    public void testConstructorWithArgumentsInitializesFieldsCorrectly() {
        Music music = new Music("After Hours", "The Weeknd", 362);
        assertEquals("After Hours", music.getName());
        assertEquals("The Weeknd", music.getArtist());
        assertEquals(362, music.getSeconds());
    }

    @Test
    public void testSetName() {
        Music music = new Music();
        music.setName("After Hours");
        assertEquals("After Hours", music.getName());
    }

    @Test
    public void testSetArtist() {
        Music music = new Music();
        music.setArtist("The Weeknd");
        assertEquals("The Weeknd", music.getArtist());
    }

    @Test
    public void testSetSeconds() {
        Music music = new Music();
        music.setSeconds(362);
        assertEquals(362, music.getSeconds());
    }

    @Test
    public void testToString() {
        Music music = new Music("After Hours", "The Weeknd", 362);
        assertEquals("Music: After Hours by The Weeknd - 362 seconds", music.toString());
    }
    
}
