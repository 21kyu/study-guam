package study.guam.refactoring;

import lombok.Builder;
import lombok.Getter;

public class Item {
    public String name;

    public int sellIn;

    @Getter
    public int quality;

    @Builder
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}
