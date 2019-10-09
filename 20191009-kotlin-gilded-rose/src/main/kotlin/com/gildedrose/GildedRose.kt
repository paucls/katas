package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { updateItemQuality(it) }
    }

    private fun updateItemQuality(item: Item) {
        if (item.name == "Aged Brie") {
            AgedBrieQualityUpdater().updateQuality(item)
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            if (item.quality < 50) {
                increaseQuality(item)

                if (item.sellIn <= 10) {
                    increaseQuality(item)
                }

                if (item.sellIn <= 5) {
                    increaseQuality(item)
                }
            }

            decreaseSellIn(item)

            if (item.sellIn < 0) {
                dropQuality(item)
            }
        } else if (item.name == "Sulfuras, Hand of Ragnaros") {
        } else {
            decreaseQuality(item)

            decreaseSellIn(item)

            if (item.sellIn < 0) {
                decreaseQuality(item)
            }
        }
    }

    companion object {
        fun increaseQuality(item: Item) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }

        fun decreaseQuality(item: Item) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        }

        fun decreaseSellIn(item: Item) {
            item.sellIn = item.sellIn - 1
        }

        fun dropQuality(item: Item) {
            item.quality = 0
        }
    }

    class AgedBrieQualityUpdater {
        fun updateQuality(item: Item) {
            increaseQuality(item)

            decreaseSellIn(item)

            if (item.sellIn < 0) {
                increaseQuality(item)
            }
        }
    }
}

