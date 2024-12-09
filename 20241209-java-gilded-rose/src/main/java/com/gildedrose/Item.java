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

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new AgedBrieItem(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesItem(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasItem(name, sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        if (name.equals("Aged Brie")) {
            if (quality < 50) {
                quality = quality + 1;
            }

            decreaseSellInForTheDay();

            if (sellIn < 0 && quality < 50) {
                quality = quality + 1;
            }
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
        } else {
            if (quality > 0) {
                quality = quality - 1;
            }

            decreaseSellInForTheDay();

            if (sellIn < 0 && quality > 0) {
                quality = quality - 1;
            }
        }
    }

    private void decreaseSellInForTheDay() {
        sellIn = sellIn - 1;
    }
}
