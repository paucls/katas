using NUnit.Framework;
using System;
using Rhino.Mocks;
namespace tire_pressure_monitoring_system
{
    [TestFixture]
    public class AlarmTest
    {
        [Test]
        public void Alarm_should_be_off_when_pressure_between_thresholds()
        {
            ISensor sensorStub = MockRepository.GenerateStub<ISensor>();
            sensorStub.Expect(x => x.PopNextPressurePsiValue()).Return(21);

            Alarm alarm = new Alarm(sensorStub);
            alarm.Check();

            Assert.AreEqual(false, alarm.AlarmOn);
        }

        [Test]
        public void Alarm_should_be_on_when_pressure_exceeds_higher_threshold()
        {
            var sensorStub = MockRepository.GenerateStub<ISensor>();
            sensorStub.Expect(x => x.PopNextPressurePsiValue()).Return(22);

            Alarm alarm = new Alarm(sensorStub);
            alarm.Check();

            Assert.AreEqual(true, alarm.AlarmOn);
        }
    }
}
