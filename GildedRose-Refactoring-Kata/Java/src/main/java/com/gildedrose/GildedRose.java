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

        if (item.isAgedBrie()) {
            updateAgedBrie(item);
            handleExpiredItem(item);
            return;
        }

        if (item.isBackstagePass()) {
            updateBackstagePass(item);
            handleExpiredItem(item);
            return;
        }

        updateNormalItem(item);
        handleExpiredItem(item);
    }

    private void updateNormalItem(Item item) {
        if (item.getQuality() > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.decrementQuality();
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
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
        if (item.sellIn < 0) {
            if (item.isAgedBrie()) {
                item.incrementQuality();
                return;
            }
            if (item.isBackstagePass()) {
                item.setQuality(0);
                return;
            }
            if (item.getQuality() > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.decrementQuality();
            }
        }
    }
}
