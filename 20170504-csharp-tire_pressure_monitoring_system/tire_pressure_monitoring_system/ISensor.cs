using System;
namespace tire_pressure_monitoring_system
{
    public interface ISensor
    {
        double PopNextPressurePsiValue();
    }
}
