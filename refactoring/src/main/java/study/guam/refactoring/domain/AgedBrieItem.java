package study.guam.refactoring.domain;

public class AgedBrieItem extends Item {

    public AgedBrieItem(String name, int sellIn, int quality, ItemImpl itemImpl) {
        super(name, sellIn, quality, itemImpl);
    }

    public void update() {
        System.out.println("AgedBrieItem Updating Start ... ");
        super.update();
        System.out.println("AgedBrieItem Updated ... ");
    }

}
