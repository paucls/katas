package org.codecop.dependencies.b;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCampaign {

    public boolean isActive() {
        return milliSeconds() % 2 == 0;
    }

    protected long milliSeconds() {
        return System.currentTimeMillis();
    }

    public boolean isCrazySalesDay() {
        return dayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }

    protected DayOfWeek dayOfWeek() {
        return LocalDateTime.now().getDayOfWeek();
    }
}
