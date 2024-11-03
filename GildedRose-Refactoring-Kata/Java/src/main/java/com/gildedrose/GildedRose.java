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
        if (item.sellIn < 0) {
            handleExpiredItem(item);
        } else {
            handleNormalItem(item);
        }
    }

    private void handleNormalItem(Item item) {
        if (isAgedBrie(item)) {
            item.incrementQuality();
        } else if (isBackstagePass(item)) {
            updateBackstagePass(item);
        } else {
            updateNormalItem(item);
        }
    }

    private void updateNormalItem(Item item) {
        if (item.getQuality() > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.decrementQuality();
        }
    }

    private void updateBackstagePass(Item item) {
        item.incrementQuality();
        if (item.sellIn < 11) {
            item.incrementQuality();
        }
        if (item.sellIn < 6) {
            item.incrementQuality();
        }
    }

    private void handleExpiredItem(Item item) {
        if (isAgedBrie(item)) {
            item.incrementQuality();
        } else if (isBackstagePass(item)) {
            item.setQuality(0);
        } else {
            if (item.getQuality() > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.decrementQuality();
            }
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}
