package codekata;

/**
 * This class is used by the operating system to interact with the hardware 'FlashMemoryDevice'.
 */
public class DeviceDriver {

    public static final int PROGRAM_COMMAND_ADDRESS = 0x0;
    public static final byte PROGRAM_COMMAND_DATA = (byte) 0x40;

    private FlashMemoryDevice hardware;

    public DeviceDriver(FlashMemoryDevice hardware) {
        this.hardware = hardware;
    }

    public byte read(long address) {
        return hardware.read(address);
    }

    public void write(long address, byte data) {
        hardware.write(PROGRAM_COMMAND_ADDRESS, PROGRAM_COMMAND_DATA);
    }

}