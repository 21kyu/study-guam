# Containerization

### Dockerfile 만들기
1. `spring-boot-realworld-example-app`을 위한 Dockerfile을 작성
2. docker build: 이미지 생성
3. docker run: 컨테이너 실행, 동작 확인
```
/containerization/spring-boot-realworld-example-app/Dockerfile
```

### docker-compose 만들기
1. `react-reduc-realworld-example-app`와 `spring-boot-realworld-example-app`을 같이 실행하는 docker-compose 작성 (`react-reduc-realworld-example-app`는 컨테이너 내부에서 4100 포트로 열리게 됨. 호스트의 3000 포트와 연결)
2. docker-compose build & up: 두 컨테이너 실행, 동작 확인
```
/containerization/docker-compose.yml
```

### docker-compose prod 만들기
1. MySQL 컨테이너를 같이 실행해 사용하도록 하는 docker-compose prod 만들기
2. docker-compose build & up: 세 컨테이너 실행, 동작 확인
```
/containerization/docker-compose.prod.yml
```