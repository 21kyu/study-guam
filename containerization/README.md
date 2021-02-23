# Containerization

Dockerfile과 docker-compose.yml을 만들어서 컨테이너화된 애플리케이션을 실행해보고자 합니다.

* 간단한 react container 사용 방법, 추가로 수정하셔서 사용하셔도 됩니다.
```shell
cd containerization/react-redux-realworld-example-app
npm install
docker build -t react:dev .
docker run -it --rm -v ${PWD}:/app -v /app/node_modules -p 3000:4001 react:dev
# 브라우저에서 localhost:3000 url 확인
# API 서버로 localhost:8080을 바라보고 있어서 Spring 서버가 실행되고 있지 않다면 Error 화면이 뜸
```

### A) Spring 서버용 Dockerfile 만들기
1. `spring-boot-realworld-example-app`을 위한 Dockerfile을 작성
2. docker build: 이미지 생성
3. docker run: 컨테이너 실행, 동작 확인
```
/containerization/spring-boot-realworld-example-app/Dockerfile
```
---
### B) docker-compose 만들기
1. `react-reduc-realworld-example-app`와 `spring-boot-realworld-example-app`을 같이 실행하는 docker-compose 작성 (`react-reduc-realworld-example-app`는 컨테이너 내부에서 4100 포트로 열리게 됨. 호스트의 3000 포트와 연결)
2. docker-compose build & up: 두 컨테이너 실행, 동작 확인
```
/containerization/docker-compose.yml
```
---
### C) docker-compose prod 만들기
1. MySQL 컨테이너를 같이 실행해 사용하도록 하는 docker-compose prod 만들기
2. docker-compose build & up: 세 컨테이너 실행, 동작 확인
```
/containerization/docker-compose.prod.yml
```