package study.guam.refactoring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.guam.refactoring.UpdateIF;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
public abstract class Item {
    private String name;

    @Setter
    private int sellIn;

    @Setter
    private int quality;

    @Setter
    private UpdateIF updateIF;

    public Item(String name, int sellIn, int quality,UpdateIF updateIF) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.updateIF = updateIF;
    }

    public void updateQuality() {
        updateIF.updateQuality(this);
    }

    public void minusQuality(int num){
        if(this.quality > 0){
            this.quality -= num;
        }
    }

    public void plusQuality(int num){
        if(this.quality < 50){
            this.quality += num;
        }
    }

    public void minusSellIn(){
        this.sellIn -= 1;
    }
}
