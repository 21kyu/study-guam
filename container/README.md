## 두번째 스터디

### #1
Spring boot 애플리케이션을 컨테이너화해서 실행해보려고 합니다.

컨테이너화된 서비스는 마이크로서비스를 보다 쉽게 가능케하며 클라우드 네이티브 애플리케이션의 기반을 이룬다고 합니다.

_클라우드 네이티브 애플리케이션 개발이란 도대 무엇인지, Redhat에서 짤막하게 소개해준 영상이 있어 공유합니다._
[![클라우드 네이티브 애플리케이션 개발은 무엇일까요?](https://i.ytimg.com/vi/ieIgUDlNF3g/hqdefault.jpg?sqp=-oaymwEjCNACELwBSFryq4qpAxUIARUAAAAAGAElAADIQj0AgKJDeAE=&rs=AOn4CLCdI6fcAiCIyVKIw8Yl1g1rVSEX6w)](https://youtu.be/ieIgUDlNF3g)

컨테이너, 도커, 이미지 등에 대한 정의를 헷갈려하시는 분들이 꽤 많더라구요.
컨테이너가 대세인 시점에 이 것들에 대해 확실히 짚고 넘어가면 좋을 것 같아서 공부하는 시간을 가져보고자 합니다.

먼저 컨테이너에 대해 알아보고 넘어가고자 합니다.
지난번에 구두로 말씀드린대로 각자 리눅스의 컨테이너에 대해 개인적으로 공부를 하고 서로 공유를 하려 합니다.
키워드를 드린다고 했는데 저도 애매하게 아는 부분들이 많아서.. 제대로된 키워드가 될지 모르겠습니다. 

* Linux Container
  * vs Virtual Machine
  * namespace
  * cgroup
* Container Image
* Container Runtime
  * Docker, containerd
  * CRI
* Container(Docker) Network
  * docker0
  * bridge mode
  * link
* etc..

참고할 만한 서적이나 웹사이트 공유해드려요. 혹시 추천하고 싶은 자료들이 있으면 말씀해주세요! 계속 업데이트하겠습니다.
* [가장 빨리 만나는 Docker](http://pyrasis.com/docker.html)
* [컨테이너의 개념과 이점 | Google Cloud](https://cloud.google.com/containers?hl=ko)
* [리눅스 컨테이너(Linux Container): 개념, 종류, 장점, 설치](https://www.redhat.com/ko/topics/containers/whats-a-linux-container)
* [What is a Container? | App Containerization | Docke](https://www.docker.com/resources/what-container)
* [docker docs](https://docs.docker.com/get-started/overview/)