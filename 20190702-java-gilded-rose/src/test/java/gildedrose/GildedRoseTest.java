package gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

@UseReporter(MeldReporter.class)
public class GildedRoseTest {

    @Test
    public void should_update_item_quality() {
        CombinationApprovals.verifyAllCombinations(
                this::calculateQuality,
                new String[]{"foo",
                        "Aged Brie",
                        "Backstage passes to a TAFKAL80ETC concert",
                        "Sulfuras, Hand of Ragnaros"
                },
                new Integer[]{-1, 0, 6, 11},
                new Integer[]{0, 1, 49, 50}
        );
    }

    private String calculateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item(name, sellIn, quality)
        };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        return gildedRose.items[0].toString();
    }

}
