package com.gildedrose;

/**
 * Created by paulo on 12/05/2016.
 */
public class ItemAgedBrie extends ItemType {

    public ItemAgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        final boolean maxQualityNotReached = item.quality < MAX_QUALITY;

        if (maxQualityNotReached) {
            increaseQuality();
        }
    }

}
