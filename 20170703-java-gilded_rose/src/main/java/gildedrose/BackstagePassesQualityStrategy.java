package gildedrose;

class BackstagePassesQualityStrategy extends ItemQualityStrategy {

    @Override
    public void updateQuality(Item item) {
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
    }

    void dropQuality(Item item) {
        item.quality = 0;
    }

}
