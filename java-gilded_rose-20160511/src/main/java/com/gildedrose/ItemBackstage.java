package com.gildedrose;

/**
 * Created by paulo on 12/05/2016.
 */
public class ItemBackstage extends ItemType {

    private static final int BACKSTAGE_SELL_BY_10 = 10;
    private static final int BACKSTAGE_SELL_BY_5 = 5;

    public ItemBackstage(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        final boolean minQualityNotReached = item.quality > MIN_QUALITY;

        applyIncreaseQualityPolicies();

        if (minQualityNotReached) {
            if (item.sellIn <= SELL_BY_DATE_LIMIT) {
                item.quality = 0;
            }
        }

        applySellInPolicies();
    }

    private void applyIncreaseQualityPolicies() {
        final boolean maxQualityNotReached = item.quality < MAX_QUALITY;

        if (maxQualityNotReached) {
            increaseQuality();
            if (item.sellIn <= BACKSTAGE_SELL_BY_5) {
                increaseQuality();
                increaseQuality();
            } else if (item.sellIn <= BACKSTAGE_SELL_BY_10) {
                increaseQuality();
            }
        }

    }

}
