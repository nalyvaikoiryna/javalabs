package com.gildedrose;

public class Item {
    public final String name;
    public int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        setQuality(quality);
    }

    public void decrementSellIn() {
        sellIn--;
    }

    public void incrementQuality() {
        setQuality(quality + 1);
    }

    public void decrementQuality() {
        setQuality(quality - 1);
    }

    public void setQuality(int quality) {
        this.quality = Math.max(0, Math.min(quality, 50));
    }

    public int getQuality() {
        return quality;
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    public boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
