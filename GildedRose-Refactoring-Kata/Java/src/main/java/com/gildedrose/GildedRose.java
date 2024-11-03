package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    public void updateItem(Item item) {
        item.decrementSellIn();

        if (isNormalItem(item)) {
            updateNormalItem(item);
        } else if (isAgedBrie(item)) {
            updateAgedBrie(item);
        } else if (isBackstagePass(item)) {
            updateBackstagePass(item);
        }

        handleExpiredItem(item);
    }

    private boolean isNormalItem(Item item) {
        return !item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality--;
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void updateBackstagePass(Item item) {
        incrementQuality(item);
        if (item.sellIn < 11) {
            incrementQuality(item);
        }
        if (item.sellIn < 6) {
            incrementQuality(item);
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if (isAgedBrie(item)) {
                incrementQuality(item);
            } else if (isBackstagePass(item)) {
                item.quality = 0;
            } else {
                if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality--;
                }
            }
        }
    }
}
