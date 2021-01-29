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
    void foo() {
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
}
