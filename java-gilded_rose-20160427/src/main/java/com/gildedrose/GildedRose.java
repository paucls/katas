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

            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES)) {
                if (minQualityNotReached) {
                    if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality = items[i].quality - QUALITY_UNIT;
                    }
                }
            } else {

                if (maxQualityNotReached) {
                    items[i].quality = items[i].quality + QUALITY_UNIT;

                    if (items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].sellIn <= BACKTAGE_SELL_BY_10) {
                            if (maxQualityNotReached) {
                                items[i].quality = items[i].quality + QUALITY_UNIT;
                            }
                        }

                        if (items[i].sellIn <= BACKTAGE_SELL_BY_5) {
                            if (maxQualityNotReached) {
                                items[i].quality = items[i].quality + QUALITY_UNIT;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn = items[i].sellIn - SELL_IN_UNIT;
            }

            if (items[i].sellIn < SELL_BY_DATE_LIMIT) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (minQualityNotReached) {
                            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = items[i].quality - QUALITY_UNIT;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                }
            }
        }
    }
}