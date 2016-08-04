package codekata;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class DeviceDriverTest {

    @Test
    public void read_should_read_from_hardware() {
        // Arrange
        FlashMemoryDevice deviceMock = Mockito.mock(FlashMemoryDevice.class);
        DeviceDriver driver = new DeviceDriver(deviceMock);

        when(deviceMock.read(anyLong())).thenReturn((byte) 0);

        // Act
        byte data = driver.read(0xFF);

        // Assert
        assertThat(data, is((byte) 0));
        verify(deviceMock).read(0xFF);
    }

}