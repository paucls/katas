package com.gildedrose;

public class BackstagePassesItem extends Item {
    protected BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }

        decreaseSellInForTheDay();

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
