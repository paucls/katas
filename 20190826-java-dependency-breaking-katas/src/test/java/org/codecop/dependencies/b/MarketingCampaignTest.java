package org.codecop.dependencies.b;

import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MarketingCampaignTest {

    @Test
    public void is_not_crazy_sale_day_when_not_a_friday() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.THURSDAY;
            }
        };

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }

    @Test
    public void is_crazy_sale_day_on_fridays() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected DayOfWeek dayOfWeek() {
                return DayOfWeek.FRIDAY;
            }
        };

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertTrue(isCrazySalesDay);
    }

    @Test
    public void is_active_when_current_time_in_seconds_is_even() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected long milliSeconds() {
                return 0;
            }
        };

        assertTrue(campaign.isActive());
    }

    @Test
    public void is_not_active_when_current_time_in_seconds_is_odd() {
        MarketingCampaign campaign = new MarketingCampaign() {
            @Override
            protected long milliSeconds() {
                return 1;
            }
        };

        assertFalse(campaign.isActive());
    }
}
