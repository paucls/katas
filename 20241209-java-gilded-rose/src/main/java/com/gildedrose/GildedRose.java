package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private static void updateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

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
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            // does not decrease quality
        } else {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            // do nothing
        } else {
            item.sellIn = item.sellIn - 1;
        }

        if (item.name.equals("Aged Brie")) {
            if (item.sellIn < 0 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 0) {
                item.quality = 0;
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            // do nothing
        } else {
            if (item.sellIn < 0 && item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
