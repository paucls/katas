package gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(AGED_BRIE)) {
                increaseQuality(i);
            } else if (items[i].name.equals(SULFURAS)) {
                increaseQuality(i);
            } else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                increaseQuality(i);

                if (items[i].sellIn < 11) {
                    increaseQuality(i);
                }

                if (items[i].sellIn < 6) {
                    increaseQuality(i);
                }

            } else {
                decreaseQuality(i);
            }

            if (items[i].name.equals(AGED_BRIE)) {
                decreaseSellIn(i);

                if (items[i].sellIn < 0) {
                    increaseQuality(i);
                }
            } else if (items[i].name.equals(SULFURAS)) {
                // not affected
            } else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                decreaseSellIn(i);

                if (items[i].sellIn < 0) {
                    dropQuality(i);
                }
            } else {
                decreaseSellIn(i);

                if (items[i].sellIn < 0) {
                    decreaseQuality(i);
                }
            }
        }
    }

    private void decreaseSellIn(int i) {
        items[i].sellIn = items[i].sellIn - 1;
    }

    private void increaseQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    private void decreaseQuality(int i) {
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private void dropQuality(int i) {
        items[i].quality = 0;
    }
}