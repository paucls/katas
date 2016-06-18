package com.gildedrose;

/**
 * Created by paulo on 05/05/2016.
 */
public class ItemType {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int SELL_BY_DATE_LIMIT = 0;
    public static final int QUALITY_UNIT = 1;
    public static final int SELL_IN_UNIT = 1;

    protected Item item;

    public ItemType(Item item) {
        this.item = item;
    }

    public static ItemType create(Item item) {
        switch (item.name) {
            case SULFURAS_HAND_OF_RAGNAROS:
                return new ItemSulfuras(item);
            case AGED_BRIE:
                return new ItemAgedBrie(item);
            case BACKSTAGE_PASSES:
                return new ItemBackstage(item);
            default:
                return new ItemType(item);
        }
    }

    public void updateQuality() {
        applyDecreaseQualityPolicies();
        applySellInPolicies();
    }

    private void applyDecreaseQualityPolicies() {
        final boolean minQualityNotReached = item.quality > MIN_QUALITY;

        if (minQualityNotReached) {
            if (item.sellIn <= SELL_BY_DATE_LIMIT) {
                decreaseQuality();
            }

            decreaseQuality();
        }

    }

    protected void applySellInPolicies() {
        item.sellIn = item.sellIn - SELL_IN_UNIT;
    }

    protected void increaseQuality() {
        item.quality = item.quality + QUALITY_UNIT;
    }

    private void decreaseQuality() {
        item.quality = item.quality - QUALITY_UNIT;
    }
}
