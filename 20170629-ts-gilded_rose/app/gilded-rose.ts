import { Item } from './item';

export class GildedRose {
    items: Array<Item>;

    constructor(items = []) {
        this.items = items;
    }

    updateQuality() {
        return this.items.map(item => this.updateQualityOf(item));
    }

    private updateQualityOf(item: Item): Item {
        if (item.name == 'Sulfuras, Hand of Ragnaros') {
            return item;
        }

        if (item.name == 'Aged Brie') {
            this.increaseQuality(item);

            this.decreaseSellIn(item);

            if (item.sellIn < 0) {
                this.increaseQuality(item);
            }
        } else if (item.name == 'Backstage passes to a TAFKAL80ETC concert') {

            this.increaseQuality(item);
            if (item.sellIn <= 10) {
                this.increaseQuality(item);
            }
            if (item.sellIn <= 5) {
                this.increaseQuality(item);
            }

            this.decreaseSellIn(item);

            if (item.sellIn < 0) {
                this.dropQuality(item);
            }
        } else {
            this.decreaseQuality(item);

            this.decreaseSellIn(item);

            if (item.sellIn < 0) {
                this.decreaseQuality(item);
            }
        }

        return item;
    }

    private decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1;
    }

    private dropQuality(item: Item) {
        item.quality = item.quality - item.quality;
    }

    private decreaseQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private increaseQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
