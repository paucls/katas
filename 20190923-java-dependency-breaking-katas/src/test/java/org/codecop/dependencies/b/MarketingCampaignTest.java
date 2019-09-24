package org.codecop.dependencies.b;

import org.junit.Test;

import java.time.DayOfWeek;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MarketingCampaignTest {

    @Test
    public void should_be_crazy_sales_day_on_tuesdays() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.TUESDAY;
            }
        };

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertTrue(isCrazySalesDay);
    }

    @Test
    public void should_no_be_crazy_sales_day_when_not_a_tuesday() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.WEDNESDAY;
            }
        };

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }
}
