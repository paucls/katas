package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int SELL_BY_DATE_LIMIT = 0;
    public static final int BACKTAGE_SELL_BY_10 = 10;
    public static final int BACKTAGE_SELL_BY_5 = 5;
    public static final int QUALITY_UNIT = 1;
    public static final int SELL_IN_UNIT = 1;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final boolean minQualityNotReached = items[i].quality > MIN_QUALITY;
            final boolean maxQualityNotReached = items[i].quality < MAX_QUALITY;

            if (!isBrie(items[i])
                    && !isBackstage(items[i])) {
                if (minQualityNotReached) {
                    if (!isSulfuras(items[i])) {
                        decreaseQuality(items[i]);
                    }
                }
            } else {

                if (maxQualityNotReached) {
                    increaseQuality(items[i]);

                    if (isBackstage(items[i])) {
                        if (items[i].sellIn <= BACKTAGE_SELL_BY_10) {
                            if (maxQualityNotReached) {
                                increaseQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn <= BACKTAGE_SELL_BY_5) {
                            if (maxQualityNotReached) {
                                increaseQuality(items[i]);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(items[i])) {
                items[i].sellIn = items[i].sellIn - SELL_IN_UNIT;
            }

            if (items[i].sellIn < SELL_BY_DATE_LIMIT) {
                if (!isBrie(items[i])) {
                    if (!isBackstage(items[i])) {
                        if (minQualityNotReached) {
                            if (!isSulfuras(items[i])) {
                                decreaseQuality(items[i]);
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                }
            }
        }
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