package com.gildedrose;

public class AgedBrieItem extends Item {
    protected AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }

        decreaseSellInForTheDay();

        if (sellIn < 0 && quality < 50) {
            quality = quality + 1;
        }
    }
}
