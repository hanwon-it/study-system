# REST API 프로젝트

이 프로젝트는 Spring Boot 3, MyBatis, MySQL, Spring Security를 사용하여  
회원가입과 로그인 기능을 구현한 REST API 서버입니다.

## 주요 기술 스택

- Spring Boot 3
- MyBatis (ORM)
- MySQL (데이터베이스)
- Spring Security (인증 및 권한 관리)
- BCrypt (비밀번호 암호화)
- JWT (JSON Web Token) 인증 예정

## 실행 방법

1. MySQL 데이터베이스 설정
2. `application.properties` 에 DB 연결 정보 수정
3. Gradle 빌드 및 실행

```bash
./gradlew bootRun
