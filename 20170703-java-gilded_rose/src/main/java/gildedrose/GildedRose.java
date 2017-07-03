package gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case AGED_BRIE:
                    increaseQuality(item);

                    decreaseSellIn(item);

                    if (passedSellInDate(item)) {
                        increaseQuality(item);
                    }
                    break;

                case BACKSTAGE_PASSES:
                    increaseQuality(item);

                    if (item.sellIn <= 10) {
                        increaseQuality(item);
                    }

                    if (item.sellIn <= 5) {
                        increaseQuality(item);
                    }

                    decreaseSellIn(item);

                    if (passedSellInDate(item)) {
                        dropQuality(item);
                    }
                    break;

                case SULFURAS:
                    break;

                default:
                    decreaseQuality(item);

                    decreaseSellIn(item);

                    if (passedSellInDate(item)) {
                        decreaseQuality(item);
                    }
            }

        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void dropQuality(Item item) {
        item.quality = 0;
    }

    private boolean passedSellInDate(Item item) {
        return item.sellIn < 0;
    }
}