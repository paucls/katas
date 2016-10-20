package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.*;

import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AlarmTest {

    Sensor sensorMock;
    Alarm alarm;

    @Before
    public void setUp() {
        sensorMock = mock(Sensor.class);
        alarm = new Alarm(sensorMock);
    }

    @Test
    public void isAlarmOn_should_be_false_for_a_new_alarm_instance() {
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void check_should_set_alarm_on_when_pressure_falls_up_range() {
        when(sensorMock.popNextPressurePsiValue()).thenReturn(22.00);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void check_should_set_alarm_on_when_pressure_falls_down_range() {
        when(sensorMock.popNextPressurePsiValue()).thenReturn(16.00);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void check_should_set_alarm_off_when_pressure_is_in_range() {
        when(sensorMock.popNextPressurePsiValue()).thenReturn(17.00);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));

        when(sensorMock.popNextPressurePsiValue()).thenReturn(21.00);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }
}