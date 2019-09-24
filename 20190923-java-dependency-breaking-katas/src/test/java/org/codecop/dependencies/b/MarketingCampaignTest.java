package org.codecop.dependencies.b;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MarketingCampaignTest {

    @Test
    public void should_be_crazy_sales_day_on_tuesdays() {
        MarketingCampaign campaign = new MarketingCampaign();

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertTrue(isCrazySalesDay);
    }
}
