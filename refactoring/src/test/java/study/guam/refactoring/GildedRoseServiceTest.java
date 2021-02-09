package study.guam.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import study.guam.refactoring.domain.*;

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
    void 판매기간이_지나면_Quality가_2배_빠르게_저하_또는_증가(){
        List<Item> items = new ArrayList<>();
        Item normal = new NormalItem("foo",0,20,new NormalUpdator());
        Item agedBrie = new AgedBrieItem("Aged Brie",0,20,new AgedBrieUpdator());
        Item sulfuras = new SulfurasItem("Sulfuras, Hand of Ragnaros",0,20,new SulfurasUpdator());
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",0,20,new BackstageUpdator());
        Item conjured = new ConjuredItem("Conjured",0,20,new ConjuredUpdator());

        items.add(normal);
        items.add(agedBrie);
        items.add(sulfuras);
        items.add(backstage);
        items.add(conjured);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(18, items.get(0).getQuality());
        assertEquals(22, items.get(1).getQuality());
        assertEquals(80, items.get(2).getQuality());
        assertEquals(0, items.get(3).getQuality());
        assertEquals(16, items.get(4).getQuality());
    }

    @Test
    void 모든_상품의_Quality는_0이하로_내려가지않는다(){
        List<Item> items = new ArrayList<>();

        Item normal = new NormalItem("foo",0,0,new NormalUpdator());
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",0,0,new BackstageUpdator());
        Item conjured = new ConjuredItem("Conjured",0,0,new ConjuredUpdator());

        items.add(normal);
        items.add(backstage);
        items.add(conjured);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(0, items.get(0).getQuality());
        assertEquals(0, items.get(1).getQuality());
        assertEquals(0, items.get(2).getQuality());
    }
    @Test
    void 모든_상품의_Quality는_50을_넘지않음(){
        List<Item> items = new ArrayList<>();

        Item normal = new NormalItem("foo",1,50,new NormalUpdator());
        Item agedBrie = new AgedBrieItem("Aged Brie",1,50,new AgedBrieUpdator());
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",1,50,new BackstageUpdator());
        Item conjured = new ConjuredItem("Conjured",1,50,new ConjuredUpdator());

        items.add(normal);
        items.add(agedBrie);
        items.add(backstage);
        items.add(conjured);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(49, items.get(0).getQuality());
        assertEquals(50, items.get(1).getQuality());
        assertEquals(50, items.get(2).getQuality());
        assertEquals(48, items.get(3).getQuality());
    }

    @Test
    void AgeBrie_상품은_날이_지날수록_Quality증가(){
        List<Item> items = new ArrayList<>();
        Item agedBrie = new AgedBrieItem("Aged Brie",1,45,new AgedBrieUpdator());
        Item agedBrie2 = new AgedBrieItem("Aged Brie",0,45,new AgedBrieUpdator());
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
        Item sulfuras = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80, new SulfurasUpdator());
        items.add(sulfuras);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(80, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_테스트_날마다_Quality증가(){
        List<Item> items = new ArrayList<>();
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",15,10,new BackstageUpdator());
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(11, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_SellIn값_10이하일_때_Quality_2씩증가(){
        List<Item> items = new ArrayList<>();
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",10,10,new BackstageUpdator());
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(12, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_SellIn값_5이하일_때_Quality_3씩증가(){
        List<Item> items = new ArrayList<>();
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",5,10,new BackstageUpdator());
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(13, items.get(0).getQuality());
    }

    @Test
    void Backstage_passes상품_판매기간_지나면_Quality이_0(){
        List<Item> items = new ArrayList<>();
        Item backstage = new BackStageItem("Backstage passes to a TAFKAL80ETC concert",11,30,new BackstageUpdator());
        items.add(backstage);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(31, items.get(0).getQuality());
    }

}
