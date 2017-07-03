package gildedrose;

class AgedBrieQualityStrategy extends ItemQualityStrategy {

    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);

        decreaseSellIn(item);

        if (passedSellInDate(item)) {
            increaseQuality(item);
        }
    }

}
