package study.guam.refactoring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Item {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    public static final int MAX_QUALITY = 50;
    public static final int FAR_FROM_EXPIRY = 11;
    public static final int CLOSE_TO_EXPIRY = 6;

    @Id
    private Long id;
    private String name;
    private int sellIn;
    private int quality;

    @Builder
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update() {
        this.updateQuality();
        this.updateSellIn();
    }

    public void updateQuality() {
        if (!this.name.equals(AGED_BRIE) && !this.name.equals(BACKSTAGE_PASSES)) {
            this.decreaseQualityIfItemHasQuality();
        } else {
            this.increaseQualityIncludingBackstagePasses();
        }
    }

    public void decreaseQualityIfItemHasQuality() {
        if (this.quality > 0) {
            this.decreaseQuality();
            this.decreaseQualityOfConjured();
        }
    }

    public void decreaseQuality() {
        if (!this.name.equals(SULFURAS)) {
            this.quality--;
        }
    }

    public void decreaseQualityOfConjured() {
        if (this.name.equals(CONJURED)) {
            this.decreaseQuality();
        }
    }

    public void increaseQualityIncludingBackstagePasses() {
        if (this.quality < MAX_QUALITY) {
            this.increaseQuality();
            this.increaseQualityOfBackstagePasses();
        }
    }

    public void increaseQuality() {
        this.quality++;
    }

    public void increaseQualityOfBackstagePasses() {
        if (this.name.equals(BACKSTAGE_PASSES)) {
            this.increaseQualityIfFarFromExpiring();
            this.increaseQualityIfCloseToExpiring();
        }
    }

    public void increaseQualityIfFarFromExpiring() {
        if (this.sellIn < FAR_FROM_EXPIRY) {
            this.increaseQualityIfNotMax();
        }
    }

    public void increaseQualityIfCloseToExpiring() {
        if (this.sellIn < CLOSE_TO_EXPIRY) {
            this.increaseQualityIfNotMax();
        }
    }

    public void increaseQualityIfNotMax() {
        if (this.quality < MAX_QUALITY) {
            this.increaseQuality();
        }
    }

    public void updateSellIn() {
        if (!this.name.equals(SULFURAS)) {
            this.sellIn--;
        }
        handleIfExpired();
    }

    public void handleIfExpired() {
        if (this.sellIn < 0) {
            handleExpired();
        }
    }

    public void handleExpired() {
        if (!this.name.equals(AGED_BRIE)) {
            this.handleExpiredItemNotAgedBrie();
        } else {
            this.increaseQualityIfNotMax();
        }
    }

    public void handleExpiredItemNotAgedBrie() {
        if (!this.name.equals(BACKSTAGE_PASSES)) {
            this.decreaseQualityIfItemHasQuality();
        } else {
            this.quality = 0;
        }
    }
}
