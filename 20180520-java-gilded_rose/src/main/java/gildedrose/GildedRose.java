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
            if (items[i].name.equals(AGED_BRIE)
                    || items[i].name.equals(BACKSTAGE_PASSES)
                    || items[i].name.equals(SULFURAS)) {
                increaseQuality(i);

                if (items[i].name.equals(BACKSTAGE_PASSES)) {
                    if (items[i].sellIn < 11) {
                        increaseQuality(i);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(i);
                    }
                }
            } else {
                decreaseQuality(i);
            }

            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals(AGED_BRIE)) {
                    increaseQuality(i);
                } else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                    dropQuality(i);
                } else if (items[i].name.equals(SULFURAS)) {
                    continue;
                } else {
                    decreaseQuality(i);
                }
            }
        }
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