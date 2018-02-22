package com.katas;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

public class RoverAPITest {

    private Rover roverMock;
    private RoverAPI roverAPI;

    @Before
    public void setUp() {
        roverMock = Mockito.mock(Rover.class);
        roverAPI = new RoverAPI(roverMock);
    }

    @Test
    public void should_accept_character_commands() {
        boolean result = roverAPI.handle(new char[]{'a'});

        assertThat(result, is(true));
    }

    @Test
    public void can_handle_forward_command() {
        roverAPI.handle(new char[]{'f'});

        verify(roverMock).moveForward();
    }
}
