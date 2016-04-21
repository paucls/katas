package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    if (!item.name.equals(CONJURED)) {
                        // Basic item decreases quality by 1
                        decreaseQuality(item, 1);
                    } else {
                        decreaseQuality(item, 2);
                    }
                }
            }
        } else {
            if (item.quality < 50) {
                // agedBriedIncreasesQualityTheOlderItGets
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }

        applyExpiredRules(item);
    }

    private void decreaseQuality(Item item, int value) {
        item.quality = item.quality - value;
    }

    private void applyExpiredRules(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            //caso normal cuando llega a 0
                            if (!item.name.equals(CONJURED)) {
                                // Basic item decreases quality by 1
                                decreaseQuality(item, 1);
                            } else {
                                decreaseQuality(item, 2);
                            }
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

}
