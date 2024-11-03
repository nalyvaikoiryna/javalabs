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
        updateQuality(item);
        handleExpiredItem(item);
    }

    private void updateQuality(Item item) {
        if (item.isAgedBrie()) {
            item.incrementQuality();
            return;
        }

        if (item.isBackstagePass()) {
            updateBackstagePass(item);
            return;
        }

        updateNormalItem(item);
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
        if (item.sellIn < 0) {
            handleExpiredQuality(item);
        }
    }

    private void handleExpiredQuality(Item item) {
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
