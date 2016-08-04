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
        assertThat(data, is((byte) 0));
        verify(deviceMock).read(0xFF);
    }

    @Test
    public void write_should_begin_with_a_program_command() {
        // Act
        driver.write(0xFF, (byte) 10);

        // Assert
        verify(deviceMock).write(0x0, (byte) 0x40);
    }

}