package codekata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class DeviceDriverTest {

    @Test
    public void read_should_read_from_hardware() {
        MockFlashMemoryDevice hardware = new MockFlashMemoryDevice();
        DeviceDriver driver = new DeviceDriver(hardware);

        byte data = driver.read(0xFF);

        assertThat(data, is((byte) 0));
        assertThat(hardware.readCallsCount, is(1));
    }

}

class MockFlashMemoryDevice implements FlashMemoryDevice {

    int readCallsCount = 0;

    public byte read(long address) {
        readCallsCount++;
        return 0;
    }

    public void write(long address, byte data) {

    }
}