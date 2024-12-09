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
}
