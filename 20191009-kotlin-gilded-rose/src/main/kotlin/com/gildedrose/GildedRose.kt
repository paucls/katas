package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { updateItemQuality(it) }
    }

    private fun updateItemQuality(item: Item) {
        when {
            item.name == "Aged Brie" -> QualityUpdater.AgedBrieQualityUpdater().updateQuality(item)
            item.name == "Backstage passes to a TAFKAL80ETC concert" -> QualityUpdater.BackstagePassQualityUpdater().updateQuality(item)
            item.name == "Sulfuras, Hand of Ragnaros" -> QualityUpdater.SulfurasQualityUpdater().updateQuality(item)
            else -> QualityUpdater().updateQuality(item)
        }
    }
}

