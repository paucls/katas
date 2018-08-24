package tddmicroexercises.tirepressuremonitoringsystem;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
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
        assertThat(alarm.isAlarmOn(), is(false));
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
    @Parameters({"17.0",
            "19.5",
            "21.0"})
    public void should_be_off_when_pressure_is_in_range(double psiValue) {
        when(sensorStub.popNextPressurePsiValue()).thenReturn(psiValue);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }
}
