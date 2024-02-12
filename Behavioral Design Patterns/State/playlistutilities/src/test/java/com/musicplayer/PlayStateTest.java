package com.musicplayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayStateTest {
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
    public void testPlay() {
        State state = new PlayState();
        assertTrue(state.play() instanceof PlayState);
        assertEquals("Already playing music.\r\n", outContent.toString());
    }

    @Test
    public void testPause() {
        State state = new PlayState();
        assertTrue(state.pause() instanceof PauseState);
        assertEquals("Pausing music.\r\n", outContent.toString());
    }

    @Test
    public void testStop() {
        State state = new PlayState();
        assertTrue(state.stop() instanceof StopState);
        assertEquals("Stopping music.\r\n", outContent.toString());
    }

    @Test
    public void testRewind() {
        State state = new PlayState();
        assertTrue(state.rewind() instanceof RewindStateTest);
        assertEquals("Rewinding music.\r\n", outContent.toString());
    }

    @Test
    public void testAdvance() {
        State state = new PlayState();
        assertTrue(state.advance() instanceof AdvanceState);
        assertEquals("Advancing music.\r\n", outContent.toString());
    }
}
