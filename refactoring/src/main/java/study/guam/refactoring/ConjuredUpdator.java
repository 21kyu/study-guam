package study.guam.refactoring;

import study.guam.refactoring.domain.Item;

public class ConjuredUpdator implements UpdateIF{
    @Override
    public void updateQuality(Item item) {
        int defaultQualityValue = 2;
        item.minusQuality(판매기간에_따라_변화하는_Quality값(item,defaultQualityValue));
        item.minusSellIn();
    }

    private int 판매기간에_따라_변화하는_Quality값(Item item, int qualityValue){
        if(item.getSellIn() <= 0){
            return qualityValue * 2;
        }
        return qualityValue;
    }
}
