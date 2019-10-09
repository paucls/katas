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
}

