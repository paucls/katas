package gildedrose;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (final Item item : items) {
            QualityStrategyFactory
                    .strategyFor(item.name)
                    .updateQuality(item);
        }
    }
}

class QualityStrategyFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    static QualityStrategy strategyFor(String itemName) {
        switch (itemName) {
            case AGED_BRIE:
                return new AgedBrieQualityStrategy();
            case SULFURAS:
                return new SulfurasQualityStrategy();
            case BACKSTAGE_PASSES:
                return new BackstageQualityStrategy();
            default:
                return new DefaultQualityStrategy();
        }
    }
}

abstract class QualityStrategy {

    abstract void updateQuality(Item item);

    void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}

class DefaultQualityStrategy extends QualityStrategy {
    @Override
    void updateQuality(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}

class AgedBrieQualityStrategy extends QualityStrategy {
    @Override
    void updateQuality(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}

class SulfurasQualityStrategy extends QualityStrategy {
    @Override
    void updateQuality(Item item) {
        increaseQuality(item);
    }
}

class BackstageQualityStrategy extends QualityStrategy {
    @Override
    void updateQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            dropQuality(item);
        }
    }

    private void dropQuality(Item item) {
        item.quality = 0;
    }
}