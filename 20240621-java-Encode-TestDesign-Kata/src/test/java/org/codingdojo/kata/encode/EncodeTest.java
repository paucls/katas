package org.codingdojo.kata.encode;

import org.junit.jupiter.api.Test;

import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class EncodeTest {

    private final HexStringEncoder hex = new HexStringEncoder();
    private final ByteBuffer data = new ByteBuffer();

    @Test
    void should_encode_when_timer_value_is_in_range() {
        var command = aSessionModificationCmd();
        command.setXyzTimer(XyzTimerUnit.MULTIPLES_OF_HOURS, 23);

        command.encode(data);

        String hexStr = hex.encode(data);
        System.out.println("Hex: " + hexStr + "\n");
        assertEquals("03010101083791", hexStr);
    }

    @Test
    void should_encode_when_timer_value_is_outside_range() {
        var command = aSessionModificationCmd();
        command.setXyzTimer(XyzTimerUnit.MULTIPLES_OF_MINUTES, 32); // outside range(31), expect 31

        command.encode(data);

        String hexStr = hex.encode(data);
        System.out.println("Hex: " + hexStr + "\n");
        assertEquals("03010101085f91", hexStr);
    }

    @Test
    void should_encode_when_timer_is_deactivated() {
        var command = aSessionModificationCmd();
        command.setXyzTimer(XyzTimerUnit.TIMER_DEACTIVATED, 2); // deactivated, expect value 0

        command.encode(data);

        String hexStr = hex.encode(data);
        System.out.println("Hex: " + hexStr + "\n");
        assertEquals("03010101080091", hexStr);
    }

    private static SessionModificationCmd aSessionModificationCmd() {
        var command = new SessionModificationCmd(1, 1);
        command.setPqvl(1);
        return command;
    }

    private static class HexStringEncoder {

        public String encode(ByteBuffer buffer) {
            var hex = new StringBuilder();

            HexFormat format = HexFormat.of();
            while (buffer.getAvailable() > 0) {
                int octet = buffer.read();

                hex.append(format.toHighHexDigit(octet));
                hex.append(format.toLowHexDigit(octet));
            }

            return hex.toString();
        }
    }
}
