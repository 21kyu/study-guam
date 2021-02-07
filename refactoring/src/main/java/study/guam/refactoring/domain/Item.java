package study.guam.refactoring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public abstract class Item {
    @Id
    private Long id;

    private String name;

    @Setter
    private int sellIn;

    @Setter
    private int quality;

    private ItemImpl itemImpl;


    public Item(String name, int sellIn, int quality, ItemImpl itemImpl) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.itemImpl = itemImpl;
    }

    public void update() {
        itemImpl.update(this);
    }

    public void decreaseSellin(int decreaseSellinValue) {
        this.sellIn -= decreaseSellinValue;
    }

    public void increaseQuality(int increaseQualityValue) {
        this.quality += increaseQualityValue;
        if (this.quality > 50) {
            this.quality = 50;
        }
    }

    public void decreaseQuality(int decreaseQualityValue) {
        this.quality -= decreaseQualityValue;
        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
