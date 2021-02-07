package study.guam.refactoring.domain;

public class AgedBrieItemImpl implements ItemImpl {

    @Override
    public void update(Item item) {
        int decreasQualityValue = 1;


        decreasQualityValue = getDecreaseQualityValue(item, decreasQualityValue);

        item.decreaseSellin(1);
        item.increaseQuality(decreasQualityValue);
    }

    private int getDecreaseQualityValue(Item item, int decreasQualityValue) {
        if (item.getSellIn() < 1) {
            decreasQualityValue *= 2;
        }
        return decreasQualityValue;
    }
}
