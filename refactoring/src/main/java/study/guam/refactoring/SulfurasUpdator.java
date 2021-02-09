package study.guam.refactoring;

import study.guam.refactoring.domain.Item;

public class SulfurasUpdator implements UpdateIF{

    @Override
    public void updateQuality(Item item) {
        item.setQuality(80);
    }
}
