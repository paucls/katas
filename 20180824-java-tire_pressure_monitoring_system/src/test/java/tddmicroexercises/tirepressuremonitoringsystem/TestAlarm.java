package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarm {

    private Sensor sensorStub;
    private Alarm alarm;

    @Before
    public void setUp() {
        sensorStub = mock(Sensor.class);
        alarm = new Alarm(sensorStub);
    }

    @Test
    public void should_be_off_on_initialization() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void should_be_active_when_pressure_is_below_range() {
        when(sensorStub.popNextPressurePsiValue()).thenReturn(16.0);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void should_be_active_when_pressure_is_above_range() {
        when(sensorStub.popNextPressurePsiValue()).thenReturn(22.0);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void should_be_off_when_pressure_is_in_range() {
        when(sensorStub.popNextPressurePsiValue()).thenReturn(17.0);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));

        when(sensorStub.popNextPressurePsiValue()).thenReturn(21.0);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }
}
