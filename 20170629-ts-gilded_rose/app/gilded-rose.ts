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
        if (item.name != 'Aged Brie' && item.name != 'Backstage passes to a TAFKAL80ETC concert') {
            if (item.name != 'Sulfuras, Hand of Ragnaros') {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            this.increaseQuality(item);
            if (item.name == 'Backstage passes to a TAFKAL80ETC concert') {
                if (item.sellIn < 11) {
                    this.increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    this.increaseQuality(item);
                }
            }
        }
        if (item.name != 'Sulfuras, Hand of Ragnaros') {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < 0) {
            if (item.name != 'Aged Brie') {
                if (item.name != 'Backstage passes to a TAFKAL80ETC concert') {
                    if (item.name != 'Sulfuras, Hand of Ragnaros') {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                this.increaseQuality(item);
            }
        }
        return item;
    }

    private increaseQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
