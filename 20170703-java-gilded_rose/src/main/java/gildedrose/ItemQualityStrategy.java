package gildedrose;

class ItemQualityStrategy {

    public void updateQuality(Item item) {
        decreaseQuality(item);

        decreaseSellIn(item);

        if (passedSellInDate(item)) {
            decreaseQuality(item);
        }
    }

    void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void dropQuality(Item item) {
        item.quality = 0;
    }

    boolean passedSellInDate(Item item) {
        return item.sellIn < 0;
    }

}
