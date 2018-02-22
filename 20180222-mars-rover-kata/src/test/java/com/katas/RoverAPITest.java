package com.katas;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.never;
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
    public void can_handle_forward_command() {
        roverAPI.handle(new char[]{'f'});

        verify(roverMock).moveForward();
    }

    @Test
    public void should_do_nothing_for_unknown_commands() {
        roverAPI.handle(new char[]{'x'});

        verify(roverMock, never()).moveForward();
    }

    @Test
    public void can_handle_backward_command() {
        roverAPI.handle(new char[]{'b'});

        verify(roverMock).moveBackward();
    }
}
