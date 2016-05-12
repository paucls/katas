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
    private static final int BACKSTAGE_SELL_BY_10 = 10;
    private static final int BACKSTAGE_SELL_BY_5 = 5;
    public static final int QUALITY_UNIT = 1;
    public static final int SELL_IN_UNIT = 1;

    protected Item item;

    public ItemType(Item item) {
        this.item = item;
    }

    public static ItemType create(Item item) {
        boolean isSulfuras = item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
        boolean isAgedBrie = item.name.equals(AGED_BRIE);

        if (isSulfuras) {
            return new ItemSulfuras(item);
        }
        if (isAgedBrie) {
            return new ItemAgedBrie(item);
        }

        return new ItemType(item);
    }

    public void updateQuality() {
        applyIncreaseQualityPolicies();
        applyDecreaseQualityPolicies();
        applySellInPolicies();
    }

    private void applyIncreaseQualityPolicies() {
        final boolean maxQualityNotReached = item.quality < MAX_QUALITY;

        if (maxQualityNotReached) {
            if (isBackstage()) {
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

    private void applyDecreaseQualityPolicies() {
        final boolean minQualityNotReached = item.quality > MIN_QUALITY;

        if (minQualityNotReached) {
            if (isBackstage()) {
                if (item.sellIn <= SELL_BY_DATE_LIMIT) {
                    item.quality = 0;
                }
                return;
            }

            if (item.sellIn <= SELL_BY_DATE_LIMIT) {
                decreaseQuality();
            }

            decreaseQuality();
        }

    }

    private void applySellInPolicies() {
        item.sellIn = item.sellIn - SELL_IN_UNIT;
    }

    private boolean isBackstage() {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    protected void increaseQuality() {
        item.quality = item.quality + QUALITY_UNIT;
    }

    private void decreaseQuality() {
        item.quality = item.quality - QUALITY_UNIT;
    }
}
