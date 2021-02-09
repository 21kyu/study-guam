package study.guam.refactoring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.guam.refactoring.domain.Item;
import study.guam.refactoring.domain.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GildedRoseService {

    private final ItemRepository itemRepository;

    public void updateQuality() {
        List<Item> items = itemRepository.findAll();

        for (Item item : items) {
            item.updateQuality();
        }
    }
}
