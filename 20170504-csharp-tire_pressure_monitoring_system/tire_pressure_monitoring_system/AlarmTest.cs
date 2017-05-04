using NUnit.Framework;
using System;
namespace tire_pressure_monitoring_system
{
    [TestFixture]
    public class AlarmTest
    {
        [Test]
        public void Foo()
        {
            Alarm alarm = new Alarm();
            Assert.AreEqual(false, alarm.AlarmOn);
        }
    }
}
