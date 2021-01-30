## 첫번째 스터디 주제입니다.

꽤 널리 알려진 리팩토링 과제인 [Gilded Rose](https://github.com/emilybache/GildedRose-Refactoring-Kata)를 Spring boot에 맞게 조금 수정해서 리팩토링을 해보는 걸 하려고 합니다.
저도 이렇게는 해보지 않아서 잘 될지 걱정이긴 하네요.


이 주제는 맛보기이며, 참여는 자율이에요. 우선 스터디를 시작하기 전에 한번쯤 해보면 도움이 될 것 같아서 추천드릴 겸 해보려고 해요.

테스트 코드는 프로젝트 전체의 부수 효과 발생 확률을 줄여주며, 개발자 뿐만 아니라 devops 측면에서도 테스트 단계는 빠질 수 없으니 꼭 필요한 부분이라고 생각해요.

### 개발 환경
* java 11 (필요하다면 8버전으로 build.gradle 변경해서 사용해주세요)
* gradle
* lombok 사용을 위한 설정 (intelliJ라면 Setting에서 Enable annotation processing 활성)

### 진행은 아래와 같이 해주시면 될 것 같습니다.

1. 해당 레포의 우상단 Fork 버튼을 통해 자신의 저장소로 Fork
2. dev 브랜치를 만들어서 아래 요구사항에 맞게 리팩토링을 진행해주세요. (git checkout -b dev)
3. 수정 사항을 저기 3개의 commit 순서에 맞게 나누어 push 해주세요.
4. main 브랜치로 PR 생성해주시면 됩니다.

[다른 분들의 저장소](https://github.com/21kyu/study-guam/network/members)로 가서 참고하셔도 좋구요, 타인의 PR을 서로 리뷰하면 더 좋을 것 같긴해요.
저도 처음이라 뭐가 좋을지는 잘 모르겠지만, Spring boot나 git 사용법이 익숙하지 않으실 수도 있고, 단위 테스트가 처음이신 분도 계실 것 같아요.
**궁금한 사항이 있으시면 언제든 말씀해주세요!**

---

Gilded Rose 요구사항 정의

안녕하세요, Gilded Rose 팀에 오신 것을 환영합니다.
우리는 최고의 위치를 가진 작은 여관이며 최고급 상품만을 사고 판매합니다.
하지만 우리의 제품은 판매해야하는 날짜가 가까워지는 상품은 지속적으로 품질이 저하되고 있습니다.
우리는 이러한 상품들을 관리하고 있으며 아래와 같은 로직으로 돌아가는 시스템을 갖추고 있습니다.

- 모든 아이템은 아이템을 판매해야하는 날짜를 나타내는 "SellIn" 값을 가집니다.
- 모든 상품에는 상품의 가치는 나타내는 "Quality" 값이 있습니다.
- 하루가 지날 때마다 시스템은 모든 상품의 두 값을 모두 낮춥니다.

현재까지 구현된 시스템의 흥미로운 부분은 아래와 같습니다.

- 판매 기한이 지나면 "Quality"가 2배 빠르게 저하됩니다.
- 모든 상품의 "Quality"는 0 이하로 내려가지 않습니다.
- 모든 상품의 "Quality"는 50을 넘지 않습니다.
- "Aged Brie" 상품은 날이 지날수록 "Quality"가 증가됩니다.
- 전설적인 상품인 "Sulfuras"는 판매할 필요도 없고, 품질이 저하될 필요도 없습니다. 또한 전설적인 상품이므로 "Quality" 값은 80으로 설정됩니다.
- "Backstage passes" 상품은 "Aged Brie"처럼 날이 지날수록 "Quality"가 증가됩니다.
  "SellIn" 값에 따라, 10일 이하일 때는 2, 5일 이하일 때는 3씩 증가하지만, 판매 기한이 지나면 "Quality"는 0이 됩니다.
  
최근에 창조된 아이템 공급 업체와 계약했기 때문에, 시스템의 변경이 필요합니다.

- "Conjured" 상품은 일반적인 상품보다 "Quality"가 2배 빠르게 저하됩니다.

updateQuality 함수를 자유롭게 변경하고 필요하다면 새로운 코드를 추가하세요.

아래와 같은 순서로 commit을 생성해주면 좋을 것 같습니다.
1. 시스템이 동작하는 모든 로직을 테스트할 수 있는 단위 테스트를 작성하세요.
2. updateQuality 함수를 자유롭게 리팩토링합니다. 단, updateQuality 함수 자체는 아래와 같은 형태로 존재해야 합니다. 다형성 등의 도움을 받아 진행해주세요.
```java
public void updateQuality() {
    List<Item> items = itemRepository.findAll();

    for (Item item : items) {
        item.updateQuality()
    }
}
```
3. "Conjured" 상품을 추가해주세요.