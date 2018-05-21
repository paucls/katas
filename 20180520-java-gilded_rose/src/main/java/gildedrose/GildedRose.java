package gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final Item item = items[i];
            switch (item.name) {
                case AGED_BRIE:
                    increaseQuality(item);
                    decreaseSellIn(i);

                    if (item.sellIn < 0) {
                        increaseQuality(item);
                    }
                    break;
                case SULFURAS:
                    increaseQuality(item);
                    break;
                case BACKSTAGE_PASSES:
                    increaseQuality(item);

                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }

                    decreaseSellIn(i);

                    if (item.sellIn < 0) {
                        dropQuality(i);
                    }
                    break;
                default:
                    decreaseQuality(i);
                    decreaseSellIn(i);

                    if (item.sellIn < 0) {
                        decreaseQuality(i);
                    }
                    break;
            }
        }
    }

    private void decreaseSellIn(int i) {
        items[i].sellIn = items[i].sellIn - 1;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
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