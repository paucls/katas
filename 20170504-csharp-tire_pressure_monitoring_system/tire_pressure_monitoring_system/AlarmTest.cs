using NUnit.Framework;
using System;
namespace tire_pressure_monitoring_system
{
    [TestFixture]
    public class AlarmTest
    {
        [Test]
        public void Alarm_should_be_off_when_pressure_between_thresholds()
        {
            Alarm alarm = new Alarm();
            Assert.AreEqual(false, alarm.AlarmOn);
        }

        [Test]
        public void Alarm_should_be_on_when_pressure_exceeds_higher_threshold()
		{
			Alarm alarm = new Alarm();
			Assert.AreEqual(true, alarm.AlarmOn);
		}
    }
}
