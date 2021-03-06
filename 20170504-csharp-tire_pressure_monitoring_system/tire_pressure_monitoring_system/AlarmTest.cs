﻿using NUnit.Framework;
using Rhino.Mocks;
namespace tire_pressure_monitoring_system
{
    [TestFixture]
    public class AlarmTest
    {
        ISensor sensorStub;
        Alarm alarm;

        [SetUp]
        public void setUp()
        {
            sensorStub = MockRepository.GenerateStub<ISensor>();
            alarm = new Alarm(sensorStub);
        }

        [Test]
        public void Alarm_should_be_off_when_pressure_between_thresholds()
        {
            sensorStub.Expect(x => x.PopNextPressurePsiValue()).Return(21);

            alarm.Check();

            Assert.AreEqual(false, alarm.AlarmOn);
        }

        [Test]
        public void Alarm_should_be_on_when_pressure_exceeds_higher_threshold()
        {
            sensorStub.Expect(x => x.PopNextPressurePsiValue()).Return(22);

            alarm.Check();

            Assert.AreEqual(true, alarm.AlarmOn);
        }

        [Test]
        public void Alarm_should_be_on_when_pressure_falls_under_lower_threshold()
        {
            sensorStub.Expect(x => x.PopNextPressurePsiValue()).Return(16);

            alarm.Check();

            Assert.AreEqual(true, alarm.AlarmOn);
        }
    }
}
