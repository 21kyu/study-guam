# study-guam

![guam](https://cdn.pixabay.com/photo/2015/08/14/04/01/sea-887899_1280.jpg)
> Image by <a href="https://pixabay.com/users/chkh270-1299543/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=887899">chkh270</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=887899">Pixabay</a>

## 목표
Cloud Native한 Life cycle을 가지는 Application을 개발하는 다양한 방법들을 알아보고 Best pratices를 적용해보고 공유하고자 하는 스터디.
Spring boot를 기본으로 하여 스터디 구성원들의 의견을 조합해 방향을 잡아가고자 함. **Infrastructure as Code**를 지향하며 모든 수정 사항에 대해 스터디 구성원 간의 Code review는 필쑤. 소규모로 진행할 예정.
_비즈니스 로직의 고민보다 애플리케이션을 **구성하고 배포**하는 것에 포커스_


## 요구사항

### 대상
Back-end 개발 혹은 공부하고 있는 중이며 Container 환경에서의 Application 개발과 구성에 대한 관심이 지대하신 분.
느린 속도로 진행될 스터디의 호흡에 맞출 수 있는 분. Devops에 흥미있으신 분

### 지식/스킬
같이 성장해 나아가고자 하는 마음으로 하는 스터디이지만, 아래와 같은 몇가지 사항들이 요구됨
* 적당한 [Spring](https://spring.io/) 활용 기간
* 적당한 [Git](https://git-scm.com/), [GitHub](https://github.com/) 사용 능력
* 적당한 열정

### 개발 환경
GKE로 k8s cluster를 구축해두고 스터디 결과물을 배포.
대부분의 resource들은 GCP의 것을 사용할 예정

## 예상되는 진행 과정

1. 레거시 프로젝트를 리팩토링. [Gilded Rose](https://github.com/emilybache/GildedRose-Refactoring-Kata) 자료를 참고해 진행할 예정
```
TDD, Unit test, OOP, Refactoring
```
2. CI 구성과 도커라이징
```
Github Action, Container, Container repository, Docker, Jib, Build pipeline, Scanning & Hardening & Testing
```
3. Cloud 환경에 맞게 체계화. [Twelve-Factor](https://12factor.net/) 방법론 적용
```
Codebase, SaaS, Config, Environment, Secrets Encryption
```
4. Application의 Lifecycle 관리
```
Graceful shutdown, Probes, Lifecycle hook
```
5. To Be Continued..

## 함께 해요!
큰 부담없도록 긴 주기로 단계별 진행할 예정입니다. 구성원들 간의 지식이 다를 수 있으므로 단계가 넘어가기 전에 핵심 키워드들에 대해서 충분히 공부할 시간을 가질 것 입니다. 원하면 공유도 하구요. 소규모로 진행할거라서 타인이 올린 PR을 모두가 배운다는 마음으로 검토해주면 좋겠습니다. 개발적인 부분이 집중되지 않는 스터디이기도 하고 해서, 충분히 예상되지만.. 일정 수 이상 같이하실 분이 없다면 해당 Repo는 소리소문없이 삭제할 예정입니다.
[스터디 함께 하실 분 코멘트 남겨주세요!](https://github.com/21kyu/study-guam/issues/1)
