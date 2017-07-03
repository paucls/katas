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
            createQualityStrategy(item.name).updateQuality(item);
        }
    }

    private ItemQualityStrategy createQualityStrategy(String itemName) {
        ItemQualityStrategy qualityStrategy;
        switch (itemName) {
            case AGED_BRIE:
                qualityStrategy = new AgedBrieQualityStrategy();
                break;

            case BACKSTAGE_PASSES:
                qualityStrategy = new BackstagePassesQualityStrategy();
                break;

            case SULFURAS:
                qualityStrategy = new SulfurasQualityStrategy();
                break;

            default:
                qualityStrategy = new ItemQualityStrategy();
        }
        return qualityStrategy;
    }
}