package study.guam.refactoring;

import study.guam.refactoring.domain.AgedBrieItem;
import study.guam.refactoring.domain.AgedBrieItemImpl;
import study.guam.refactoring.domain.Item;

public class Testaaa {
    public static void main(String[] args) {
        Item ageBrie = new AgedBrieItem("agebrie", 0, 1, new AgedBrieItemImpl());

        System.out.println("before quality : " + ageBrie.getQuality());
        System.out.println("before sellin : " + ageBrie.getSellIn());

        ageBrie.update();

        System.out.println("after quality : " + ageBrie.getQuality());
        System.out.println("after sellin : " + ageBrie.getSellIn());
    }
}
