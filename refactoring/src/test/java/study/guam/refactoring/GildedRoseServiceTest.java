package study.guam.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import study.guam.refactoring.domain.Item;
import study.guam.refactoring.domain.ItemRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GildedRoseServiceTest {

    @InjectMocks
    GildedRoseService gildedRoseService;

    @Mock
    ItemRepository itemRepository;

    @Test
    void end_of_sales_period() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("foo")
                .sellIn(0)
                .quality(10)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(8, items.get(0).getQuality());
    }

    @Test
    void quality_is_0() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("foo")
                .sellIn(0)
                .quality(0)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(0, items.get(0).getQuality());
    }

    @Test
    void quality_exceeds_50() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Aged Brie")
                .sellIn(12)
                .quality(50)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(50, items.get(0).getQuality());
    }

    @Test
    void quality_increase_about_aged_brie() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Aged Brie")
                .sellIn(12)
                .quality(22)
                .build();
        Item foo2 = Item.builder()
                .name("Aged Brie")
                .sellIn(0)
                .quality(22)
                .build();
        items.add(foo);
        items.add(foo2);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(23, items.get(0).getQuality());
        assertEquals(24, items.get(1).getQuality());
    }

    @Test
    void legendary_product_quality_change() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(12)
                .quality(80)
                .build();
        Item foo2 = Item.builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(0)
                .quality(80)
                .build();
        items.add(foo);
        items.add(foo2);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(80, items.get(0).getQuality());
        assertEquals(80, items.get(1).getQuality());
    }

    @Test
    void sellIn_is_less_than_10_about_backstage_passes() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(10)
                .quality(20)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(22, items.get(0).getQuality());
    }

    @Test
    void sellIn_is_less_than_5_about_backstage_passes() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(5)
                .quality(20)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(23, items.get(0).getQuality());
    }

    @Test
    void end_of_sales_period_about_backstage_passes() {
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(0)
                .quality(20)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(0, items.get(0).getQuality());
    }
}
