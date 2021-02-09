package study.guam.refactoring;

import study.guam.refactoring.domain.Item;

public class NormalUpdator implements UpdateIF{

    @Override
    public void updateQuality(Item item) {
        int defaultValue = 1;
        item.minusQuality(판매기간에_따라_변화하는_Quality값(item, defaultValue));

        item.minusSellIn();
    }

    private int 판매기간에_따라_변화하는_Quality값(Item item, int qualityValue){
        if(item.getSellIn() <= 0){
            return qualityValue * 2;
        }
        return qualityValue;
    }
}
