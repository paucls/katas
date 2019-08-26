package org.codecop.dependencies.b;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MarketingCampaignTest {

    @Test
    public void is_not_crazy_sale_day_when_not_a_friday() {
        MarketingCampaign campaign = new MarketingCampaign();

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }
}
