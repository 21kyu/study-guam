package study.guam.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    List<Item> items;

    @BeforeEach
    void init() {
        items = new ArrayList<>();
    }

    @DisplayName("Aged Brie - 퀄리티 상승 #판매기한이 끝나지 않은 경우")
    @Test
    void quliatyTest0001() {

        Item foo = Item.builder()
                .name("Aged Brie")
                .sellIn(1)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();

        assertEquals(41, items.get(0).getQuality());
    }

    @DisplayName("Aged Brie - 퀄리티 상승 #판매기한이 끝난 경우")
    @Test
    void quliatyTest0002() {

        Item foo = Item.builder()
                .name("Aged Brie")
                .sellIn(0)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();

        assertEquals(42, items.get(0).getQuality());
    }

    @DisplayName("Aged Brie - 퀄리티 최대증가폭 테스트")
    @Test
    void quliatyTest0003() {

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

    //Sulfuras, Hand of Ragnaros
    @DisplayName("Sulfura - 퀄리티 고정 테스트")
    @Test
    void quliatyTest0004() {

        Item foo = Item.builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(1)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(40, items.get(0).getQuality());
    }

    //Backstage passes
    @DisplayName("Backstage passes - 퀄리티 테스트 # 판매기한이 지났을 경우")
    @Test
    void quliatyTest0005() {

        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(0)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(0, items.get(0).getQuality());
    }

    @DisplayName("Backstage passes - 퀄리티 테스트 # 판매기한이 5일 이하인 경우")
    @Test
    void quliatyTest0006() {

        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(5)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(43, items.get(0).getQuality());
    }

    @DisplayName("Backstage passes - 퀄리티 테스트 # 판매기한이 10일 이하인 경우")
    @Test
    void quliatyTest0007() {

        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(10)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(42, items.get(0).getQuality());
    }

    @DisplayName("Backstage passes - 퀄리티 테스트 # 판매기한이 10일 초과인 경우")
    @Test
    void quliatyTest0008() {

        Item foo = Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(190)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(41, items.get(0).getQuality());
    }

    @DisplayName("일반 상품 - 퀄리티 테스트 # 판매기한이 지나지 않은 경우")
    @Test
    void quliatyTest0009() {

        Item foo = Item.builder()
                .name("foo")
                .sellIn(10)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(39, items.get(0).getQuality());
    }

    @DisplayName("일반 상품 - 퀄리티 테스트 # 판매기한이 지난 경우")
    @Test
    void quliatyTest00091() {

        Item foo = Item.builder()
                .name("foo")
                .sellIn(0)
                .quality(40)
                .build();
        items.add(foo);

        when(itemRepository.findAll()).thenReturn(items);
        gildedRoseService.updateQuality();
        assertEquals(38, items.get(0).getQuality());
    }






}
