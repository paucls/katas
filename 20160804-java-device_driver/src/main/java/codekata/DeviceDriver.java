package codekata;

/**
 * This class is used by the operating system to interact with the hardware 'FlashMemoryDevice'.
 */
public class DeviceDriver {

    public static final int PROGRAM_COMMAND_ADDRESS = 0x0;
    public static final byte PROGRAM_COMMAND_DATA = (byte) 0x40;
    public static final byte READY_BIT_MASK = 0b01000000;
    public static final int ERROR_BITS_MASK = 0b10111111;
    public static final byte READY_BIT_IS_READY = 0b01000000;

    private FlashMemoryDevice hardware;

    public DeviceDriver(FlashMemoryDevice hardware) {
        this.hardware = hardware;
    }

    public byte read(long address) {
        return hardware.read(address);
    }

    public void write(long address, byte data) {
        hardware.write(PROGRAM_COMMAND_ADDRESS, PROGRAM_COMMAND_DATA);
        hardware.write(address, data);

        int commandResult;
        boolean isNotReady;
        do {
            commandResult = hardware.read(PROGRAM_COMMAND_ADDRESS);
            isNotReady = (commandResult & READY_BIT_MASK) != READY_BIT_IS_READY;
        } while (isNotReady);

        boolean noErrors = (commandResult & ERROR_BITS_MASK) == 0;
        if (noErrors) {
            hardware.read(address);
        }
    }

}