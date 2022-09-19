package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private Alarm alarm;

    @Test

    public void MainTest(){
        Sensor sensor = new Sensor();
        alarm = new Alarm(sensor);
        alarm.check();
    }


    @Test

    public void testingIfAlarmIsOnWithLowerPressure(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(14.5);
        alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void testingIfAlarmIsOnWIthHigherPressure(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(123.12);
        alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());

    }
    @Test
    public void testingIfAlarmIsOFfWIthNormalPressure(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.4);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());

    }


}