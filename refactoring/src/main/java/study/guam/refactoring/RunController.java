package study.guam.refactoring;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RunController {
    private final GildedRoseService gildedRoseService;

    @GetMapping("/run")
    public void run() {
        gildedRoseService.updateQuality();
    }
}
