package gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private AgedBrieQualityStrategy agedBrieQualityStrategy = new AgedBrieQualityStrategy();
    private BackstagePassesQualityStrategy backstagePassesQualityStrategy = new BackstagePassesQualityStrategy();
    private ItemQualityStrategy itemQualityStrategy = new ItemQualityStrategy();
    private SulfurasQualityStrategy sulfurasQualityStrategy = new SulfurasQualityStrategy();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case AGED_BRIE:
                    agedBrieQualityStrategy.updateQuality(item);
                    break;

                case BACKSTAGE_PASSES:
                    backstagePassesQualityStrategy.updateQuality(item);
                    break;

                case SULFURAS:
                    sulfurasQualityStrategy.updateQuality(item);
                    break;

                default:
                    itemQualityStrategy.updateQuality(item);
            }

        }
    }
}