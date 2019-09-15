using Xunit;

namespace Dependencies.B
{
    public class MarketingCampaignTest
    {
        [Fact]
        public void should_not_be_crazy_sale_when_not_on_friday()
        {
            var campaign = new MarketingCampaign();

            var isCrazySalesDay = campaign.IsCrazySalesDay();

            Assert.False(isCrazySalesDay);
        }
    }
}
