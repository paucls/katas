package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int SELL_BY_DATE_LIMIT = 0;
    public static final int BACKSTAGE_SELL_BY_10 = 10;
    public static final int BACKSTAGE_SELL_BY_5 = 5;
    public static final int QUALITY_UNIT = 1;
    public static final int SELL_IN_UNIT = 1;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            applyQualityPolicies(item);
            applySellInPolicies(item);
        }
    }

    private void applyQualityPolicies(Item item) {
        final boolean minQualityNotReached = item.quality > MIN_QUALITY;
        final boolean maxQualityNotReached = item.quality < MAX_QUALITY;

        if (maxQualityNotReached) {
            if (isBrie(item)) {
                increaseQuality(item);
            }
            if (isBackstage(item)) {
                increaseQuality(item);
                if (item.sellIn <= BACKSTAGE_SELL_BY_5) {
                    increaseQuality(item);
                    increaseQuality(item);
                } else if (item.sellIn <= BACKSTAGE_SELL_BY_10) {
                    increaseQuality(item);
                }
            }
        }

        if (minQualityNotReached && !isBrie(item) && !isBackstage(item) && !isSulfuras(item)) {
            decreaseQuality(item);
        }

        if (!isBrie(item) && (item.sellIn <= SELL_BY_DATE_LIMIT)) {
            if (minQualityNotReached && !isBackstage(item) && !isSulfuras(item)) {
                decreaseQuality(item);
            } else {
                item.quality = 0;
            }
        }

    }

    private void applySellInPolicies(Item item) {
        if (isSulfuras(item)) {
            return;
        }

        item.sellIn = item.sellIn - SELL_IN_UNIT;
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean isBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isBackstage(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + QUALITY_UNIT;
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - QUALITY_UNIT;
    }
}