package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { updateItemQuality(it) }
    }

    private fun updateItemQuality(item: Item) {
        when {
            item.name == "Aged Brie" -> AgedBrieQualityUpdater().updateQuality(item)
            item.name == "Backstage passes to a TAFKAL80ETC concert" -> BackstagePassQualityUpdater().updateQuality(item)
            item.name == "Sulfuras, Hand of Ragnaros" -> SulfurasQualityUpdater().updateQuality(item)
            else -> QualityUpdater().updateQuality(item)
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

    open class QualityUpdater {
        open fun updateQuality(item: Item) {
            decreaseQuality(item)

            decreaseSellIn(item)

            if (item.sellIn < 0) {
                decreaseQuality(item)
            }
        }
    }

    class AgedBrieQualityUpdater : QualityUpdater() {
        override fun updateQuality(item: Item) {
            increaseQuality(item)

            decreaseSellIn(item)

            if (item.sellIn < 0) {
                increaseQuality(item)
            }
        }

    }

    class BackstagePassQualityUpdater : QualityUpdater() {

        override fun updateQuality(item: Item) {
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
        }
    }

    class SulfurasQualityUpdater : QualityUpdater() {
        override fun updateQuality(item: Item) {
        }
    }
}

