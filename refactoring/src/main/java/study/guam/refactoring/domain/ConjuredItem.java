package study.guam.refactoring.domain;

import study.guam.refactoring.UpdateIF;

public class ConjuredItem extends Item{
    public ConjuredItem(String name, int sellIn, int quality, UpdateIF updateIF){
        super(name, sellIn, quality, updateIF);
    }

    @Override
    public void updateQuality() {
        super.updateQuality();
    }
}
