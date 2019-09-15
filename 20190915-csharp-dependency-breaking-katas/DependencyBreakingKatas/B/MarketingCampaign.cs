using System;

namespace Dependencies.B
{
    public class MarketingCampaign
    {
        public bool IsActive()
        {
            return MilliSeconds() % 2 == 0;
        }

        protected virtual long MilliSeconds()
        {
            return (long) DateTime.Now.TimeOfDay.TotalMilliseconds;
        }

        public bool IsCrazySalesDay()
        {
            return DayOfTheWeek().Equals(DayOfWeek.Friday);
        }

        protected virtual DayOfWeek DayOfTheWeek()
        {
            return DateTime.Now.DayOfWeek;
        }
    }
}