package study.guam.refactoring;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RunController {
    private final GildedRoseService gildedRoseService;

    @GetMapping("/run")
    public void run(@RequestBody List<Item> items) {
        gildedRoseService.updateQuality(items);
    }
}
