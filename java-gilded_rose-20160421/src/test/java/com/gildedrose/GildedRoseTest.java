package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void updateQuality_appIsInitializedWithItems() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void updateQuality_decreasesSellin() {
        Item[] items = new Item[]{new Item("foo", 2, 2)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_decreasesQuality() {
        Item[] items = new Item[]{new Item("foo", 2, 2)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }


    @Test
    public void updateQuality_degradesTwiceFasterWhenSellInIsZero() {
        Item[] items = new Item[]{new Item("foo", 1, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].quality);

        app.updateQuality();

        assertEquals(17, app.items[0].quality);
    }

    @Test
    public void updateQuality_qualityNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBriedIncreasesQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void updateQuality_qualityNeverHigherThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasNeverChange() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstageIncreasesQualityBy2WhenSellInIs10orLess() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    public void updateQuality_backstageIncreasesQualityBy3WhenSellInIs5orLess() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
        assertEquals(13, app.items[1].quality);
    }

    @Test
    public void updateQuality_backstageDropsToZeroWhenSellInIsZero() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredDegradesTwiceAsNormal() {
        Item[] items = new Item[]{
                new Item("Conjured", 10, 10),
                new Item("Conjured", 0, 10)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
    }

}
