package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality +=1;
                    }
                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality +=1;
                    }
                    item.sellIn -= 1;
                    if (item.sellIn < 0) {
                        item.quality -= item.quality;
                    }
                    break;
                case "Aged Brie":
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                    item.sellIn -= 1;
                    if (item.sellIn < 0 && item.quality < 50) {
                        item.quality += 1;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    if (item.quality > 0) {
                        item.quality -= 1;
                    }
                    if (item.sellIn < 0 && item.quality > 0) {
                        item.quality -= 1;
                    }
                    item.sellIn -= 1;
            }
        }
    }
}
