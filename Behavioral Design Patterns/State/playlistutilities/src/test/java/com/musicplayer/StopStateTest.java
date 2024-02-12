package com.musicplayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopStateTest {
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
        State state = new StopState();
        assertTrue(state.play() instanceof PlayState);
        assertEquals("Starting music.\r\n", outContent.toString());
    }

    @Test
    public void testPause() {
        State state = new StopState();
        assertTrue(state.pause() instanceof StopState);
        assertEquals("Can't pause. Music is already stopped.\r\n", outContent.toString());
    }

    @Test
    public void testStop() {
        State state = new StopState();
        assertTrue(state.stop() instanceof StopState);
        assertEquals("Already stopped.\r\n", outContent.toString());
    }

    @Test
    public void testRewind() {
        State state = new StopState();
        assertTrue(state.rewind() instanceof RewindState);
        assertEquals("Rewinding music.\r\n", outContent.toString());
    }

    @Test
    public void testAdvance() {
        State state = new StopState();
        assertTrue(state.advance() instanceof AdvanceState);
        assertEquals("Advancing music.\r\n", outContent.toString());
    }
}
