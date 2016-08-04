package codekata;

import static org.junit.Assert.*;

import org.junit.Test;


public class DeviceDriverTest {

    @Test
    public void read_should_read_from_hardware() {
        MockFlashMemoryDevice hardware = new MockFlashMemoryDevice();
        DeviceDriver driver = new DeviceDriver(hardware);

        byte data = driver.read(0xFF);

        assertEquals(0, data);
        assertEquals("read not called", 1, hardware.readCallsCount);
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