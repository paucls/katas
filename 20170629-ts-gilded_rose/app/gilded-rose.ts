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
                this.decreaseQuality(item);
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
            if (item.name == 'Aged Brie') {
                this.increaseQuality(item);
            } else {
                if (item.name == 'Backstage passes to a TAFKAL80ETC concert') {
                    this.dropQuality(item);
                } else {
                    if (item.name != 'Sulfuras, Hand of Ragnaros') {
                        this.decreaseQuality(item);
                    }
                }
            }
        }
        return item;
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
