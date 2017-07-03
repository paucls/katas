package gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals("Aged Brie")) {
                increaseQuality(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                decreaseQuality(item);
            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                decreaseSellIn(item);
            }

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    increaseQuality(item);
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    dropQuality(item);
                } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

                } else {
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
}