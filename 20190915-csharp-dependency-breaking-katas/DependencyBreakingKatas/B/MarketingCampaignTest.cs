using System;
using Xunit;

namespace Dependencies.B
{
    public class MarketingCampaignTest
    {
        [Fact]
        public void should_not_be_crazy_sale_when_not_on_friday()
        {
            var campaign = new TestableMarketingCampaign {TestDayOfWeek = DayOfWeek.Saturday};

            var isCrazySalesDay = campaign.IsCrazySalesDay();

            Assert.False(isCrazySalesDay);
        }

        [Fact]
        public void should_be_crazy_sale_on_a_friday()
        {
            var campaign = new TestableMarketingCampaign {TestDayOfWeek = DayOfWeek.Friday};

            var isCrazySalesDay = campaign.IsCrazySalesDay();

            Assert.True(isCrazySalesDay);
        }

        [Fact]
        public void should_be_active_on_odd_milliseconds()
        {
            var campaign = new TestableMarketingCampaign {TestMilliSeconds = 0};

            var isActive = campaign.IsActive();

            Assert.True(isActive);
        }

        [Fact]
        public void should_not_be_active_on_even_milliseconds()
        {
            var campaign = new TestableMarketingCampaign {TestMilliSeconds = 1};

            var isActive = campaign.IsActive();

            Assert.False(isActive);
        }
    }

    class TestableMarketingCampaign : MarketingCampaign
    {
        public DayOfWeek TestDayOfWeek;
        public long TestMilliSeconds;

        protected override long MilliSeconds()
        {
            return TestMilliSeconds;
        }

        protected override DayOfWeek DayOfTheWeek()
        {
            return TestDayOfWeek;
        }
    }
}