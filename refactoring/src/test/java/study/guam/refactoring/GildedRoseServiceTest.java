package study.guam.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GildedRoseServiceTest {

    @InjectMocks
    GildedRoseService gildedRoseService;

    @Test
    void foo() {
        List<Item> items = new ArrayList<>();
        Item foo = new Item("foo", 0, 0);
        items.add(foo);

        gildedRoseService.updateQuality(items);
        assertEquals(0, items.get(0).quality);
    }
}
