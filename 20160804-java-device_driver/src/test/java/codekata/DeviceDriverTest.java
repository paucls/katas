package codekata;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class DeviceDriverTest {

    private FlashMemoryDevice deviceMock;
    private DeviceDriver driver;

    @Before
    public void setup() {
        deviceMock = Mockito.mock(FlashMemoryDevice.class);
        driver = new DeviceDriver(deviceMock);
    }

    @Test
    public void read_should_read_from_hardware() {
        // Arrange
        when(deviceMock.read(anyLong())).thenReturn((byte) 0);

        // Act
        byte data = driver.read(0xFF);

        // Assert
        verify(deviceMock).read(0xFF);
        assertThat(data, is((byte) 0));
    }

    @Test
    public void write_should_begin_with_a_program_command() {
        // Arrange
        when(deviceMock.read(0x0)).thenReturn((byte) 0b11111111);

        // Act
        driver.write(0xFF, (byte) 10);

        // Assert
        verify(deviceMock).write(0x0, (byte) 0x40);
    }

    @Test
    public void write_should_make_a_call_to_write_data_to_address() {
        // Arrange
        when(deviceMock.read(0x0)).thenReturn((byte) 0b11111111);

        // Act
        driver.write(0xFF, (byte) 10);

        // Assert
        verify(deviceMock).write(0x0, (byte) 0x40);
        verify(deviceMock).write(0xFF, (byte) 10);
    }

    @Test
    public void write_should_wait_until_operation_completes_checking_ready_bit() {
        // Arrange
        when(deviceMock.read(0x0))
                .thenReturn((byte) 0)
                .thenReturn((byte) 0)
                .thenReturn((byte) 0b11111111);

        // Act
        driver.write(0xFF, (byte) 10);

        // Assert
        verify(deviceMock, times(3)).read(0x0);
    }

    @Test
    public void write_should_check_after_successful_completion_that_correct_value_was_written() {
        // Arrange
        when(deviceMock.read(0x0)).thenReturn((byte) 0b01000000);
        when(deviceMock.read(0xFF)).thenReturn((byte) 10);

        // Act
        driver.write(0xFF, (byte) 10);

        // Assert
        verify(deviceMock).read(0xFF);
    }

    @Test
    public void write_should_not_check_value_after_completion_with_error() {
        // Arrange
        when(deviceMock.read(0x0)).thenReturn((byte) 0b01000001);
        when(deviceMock.read(0xFF)).thenReturn((byte) 10);

        // Act
        driver.write(0xFF, (byte) 10);

        // Assert
        verify(deviceMock, never()).read(0xFF);
    }

}