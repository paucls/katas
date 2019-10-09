package com.gildedrose

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GildedRoseTest {

    @Test
    fun `quality and sellIn decreases by 1`() {
        val items = arrayOf(Item("An Item", 1, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].sellIn).isEqualTo(0)
        assertThat(items[0].quality).isEqualTo(9)
    }

    @Test
    fun `once the sell by date has passed quality decreases twice as fast`() {
        val items = arrayOf(Item("An Item", 0, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(8)
    }

    @Test
    fun `the quality of an item is never negative`() {
        val items = arrayOf(Item("An Item", 0, 0))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(0)
    }

    @Test
    fun `aged brie increases in quality the older it gets`() {
        val items = arrayOf(Item("Aged Brie", 1, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(11)
    }

    @Test
    fun `aged brie when sellIn expires`() {
        val items = arrayOf(Item("Aged Brie", 0, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].sellIn).isEqualTo(-1)
        assertThat(items[0].quality).isEqualTo(12)
    }

    @Test
    fun `the quality of an item is never more than 50`() {
        val items = arrayOf(Item("Aged Brie", 1, 50))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(50)
    }

    @Test
    fun `sulfuras never has to be sold or decreases in quality`() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 1, 80))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(80)
    }

    @Test
    fun `backstage passes increases in quality by 2 when there are 10 days or less`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(12)
    }

    @Test
    fun `backstage passes increases in quality by 3 when there are 5 days or less`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(13)
    }

    @Test
    fun `backstage passes drops quality to 0 after concert`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val gilgedRose = GildedRose(items)

        gilgedRose.updateQuality()

        assertThat(items[0].quality).isEqualTo(0)
    }
}
