using Xunit;

namespace Dependencies.B
{
    public class MarketingCampaignTest
    {
        [Fact]
        public void Test2()
        {
            var campaign = new MarketingCampaign();

            var isCrazySalesDay = campaign.IsCrazySalesDay();

            Assert.False(isCrazySalesDay);
        }
    }
}
