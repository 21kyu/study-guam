package study.guam.refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GildedRoseServiceTest {

    @InjectMocks
    GildedRoseService gildedRoseService;

//    @Test
//    void foo() {
//        List<Item> items = new ArrayList<>();
//        Item foo = new Item("foo", 0, 0);
//        items.add(foo);
//
//        gildedRoseService.updateQuality(items);
//        assertEquals(0, items.get(0).quality);
//    }

    @Test
    void 하루마다_퀄리티_감소() {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.ETC).
                sellIn(10).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(9, item.getQuality());
    }

    @Test
    void 판매기한초과_퀄리티_2배_감소() {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.ETC).
                sellIn(0).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(8, item.getQuality());
    }

    @Test
    void 퀄리티_0_고정() {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.ETC).
                sellIn(0).
                quality(0).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(0, item.getQuality());
    }

    @ParameterizedTest
    @ValueSource(strings = {Constants.AGED_BRIE, Constants.BACKSTAGE_PASSES})
    void 퀄리티_50_초과(String name) {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(name).
                sellIn(3).
                quality(50).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(50, item.getQuality());
    }


    @ParameterizedTest
    @CsvSource({"-1, 12", "0, 12", "1, 11", "2, 11"})
    void AGED_BRIE_판매기한_상관없이_퀄리티_증가(int sellIn, int dayQuality) {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.AGED_BRIE).
                sellIn(sellIn).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(dayQuality, item.getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 10})
    void 전설상품_80고정(int sellIn) {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.SULFURAS).
                sellIn(sellIn).
                quality(80).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(80, item.getQuality());
    }

    @Test
    void BACKSTAGE_PASSES_판매시간초과_퀄리티_0_고정() {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.BACKSTAGE_PASSES).
                sellIn(0).
                quality(40).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(0, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3, 13", "6, 12", "11, 11"})
    void BACKSTAGE_PASSES_판매일별_퀄리티_증가(int sellIn, int dayQuality) {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.BACKSTAGE_PASSES).
                sellIn(sellIn).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(dayQuality, item.getQuality());
    }
}
