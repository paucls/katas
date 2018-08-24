package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAlarm {

    @Test
    public void should_be_off_on_initialization() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }
}
