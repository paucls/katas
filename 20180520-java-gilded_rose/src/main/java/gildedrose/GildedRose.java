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
            switch (items[i].name) {
                case AGED_BRIE:
                    increaseQuality(i);
                    decreaseSellIn(i);

                    if (items[i].sellIn < 0) {
                        increaseQuality(i);
                    }
                    break;
                case SULFURAS:
                    increaseQuality(i);
                    break;
                case BACKSTAGE_PASSES:
                    increaseQuality(i);

                    if (items[i].sellIn < 11) {
                        increaseQuality(i);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(i);
                    }

                    decreaseSellIn(i);

                    if (items[i].sellIn < 0) {
                        dropQuality(i);
                    }
                    break;
                default:
                    decreaseQuality(i);
                    decreaseSellIn(i);

                    if (items[i].sellIn < 0) {
                        decreaseQuality(i);
                    }
                    break;
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