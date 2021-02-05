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
    void 판매기간이_지나면_Quality가_2배_빠르게_저하(){
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("foo")
                .sellIn(0)
                .quality(5)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(3, items.get(0).getQuality());
    }

    @Test
    void 모든_상품의_Quality는_0이하로_내려가지않는다(){
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
    void 모든_상품의_Quality는_50을_넘지않음(){
        List<Item> items = new ArrayList<>();
        Item foo = Item.builder()
                .name("Aged Brie")
                .sellIn(0)
                .quality(50)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(50, items.get(0).getQuality());
    }

    @Test
    void AgeBrie_상품은_날이_지날수록_Quality증가(){
        List<Item> items = new ArrayList<>();
        Item agedBrie = Item.builder()
                .name("Aged Brie")
                .sellIn(1)
                .quality(45)
                .build();
        Item agedBrie2 = Item.builder()
                .name("Aged Brie")
                .sellIn(0)
                .quality(45)
                .build();
        items.add(agedBrie);
        items.add(agedBrie2);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(46, items.get(0).getQuality());
        assertEquals(47, items.get(1).getQuality());
    }
    @Test
    void Sulfuras상품은_Quality가_80으로_고정(){
        List<Item> items = new ArrayList<>();
        Item sulfuras = Item.builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(0)
                .quality(80)
                .build();
        items.add(sulfuras);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(80, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_테스트_날마다_Quality증가(){
        List<Item> items = new ArrayList<>();
        Item backstage = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(15)
                .quality(10)
                .build();
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(11, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_SellIn값_10이하일_때_Quality_2씩증가(){
        List<Item> items = new ArrayList<>();
        Item backstage = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(10)
                .quality(10)
                .build();
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(12, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_SellIn값_5이하일_때_Quality_3씩증가(){
        List<Item> items = new ArrayList<>();
        Item backstage = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(5)
                .quality(10)
                .build();
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(13, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_판매기간_지나면_Quality이_0(){
        List<Item> items = new ArrayList<>();
        Item backstage = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(0)
                .quality(0)
                .build();
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(0, items.get(0).getQuality());
    }

}
