package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { updateItemQuality(it) }
    }

    private fun updateItemQuality(item: Item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                increaseQuality(item)

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            increaseQuality(item)
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            increaseQuality(item)
                        }
                    }
                }
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {
                increaseQuality(item)

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            increaseQuality(item)
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            increaseQuality(item)
                        }
                    }
                }
            }
        } else {
            if (item.quality > 0) {
                if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                } else {
                    decreaseQuality(item)
                }
            }
        }

        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
            decreaseSellIn(item)
        }

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    increaseQuality(item)
                }
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    dropQuality(item)
                } else {
                    if (item.quality > 0) {
                        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        } else {
                            decreaseQuality(item)
                        }
                    }
                }
            }
        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun increaseQuality(item: Item) {
        item.quality = item.quality + 1
    }

    private fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

    private fun dropQuality(item: Item) {
        item.quality = 0
    }

}
