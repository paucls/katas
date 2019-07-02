package gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private void updateQualityOf(Item item) {
        switch (item.name) {
            case "Aged Brie":
                updateQualityAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateQualityBackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                updateQualitySulfuras(item);
                break;
            default:
                updateQualityRegularItem(item);
                break;
        }
    }

    private void updateQualityAgedBrie(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                increaseQuality(item);
            }
        }
    }

    private void updateQualityBackstagePasses(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            dropQuality(item);
        }
    }

    private void updateQualitySulfuras(Item item) {
    }

    private void updateQualityRegularItem(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void dropQuality(Item item) {
        item.quality = 0;
    }
}