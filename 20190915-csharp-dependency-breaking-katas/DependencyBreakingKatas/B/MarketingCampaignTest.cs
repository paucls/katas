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
    }

    class TestableMarketingCampaign : MarketingCampaign
    {
        public DayOfWeek TestDayOfWeek;

        protected override DayOfWeek DayOfTheWeek()
        {
            return TestDayOfWeek;
        }
    }
}