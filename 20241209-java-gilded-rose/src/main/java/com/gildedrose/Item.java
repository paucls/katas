package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }

        decreaseSellInForTheDay();

        if (sellIn < 0 && quality > 0) {
            quality = quality - 1;
        }
    }

    void decreaseSellInForTheDay() {
        sellIn = sellIn - 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
