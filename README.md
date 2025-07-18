# SpringBoot + MyBatis + JWT 회원 시스템

## 🔧 기술 스택
- Java 17
- Spring Boot 3.x
- MyBatis
- MySQL
- JWT (로그인 인증)
- HTML + JavaScript (SPA 방식)

## 📦 프로젝트 기능
- 회원가입 / 로그인 / 로그아웃
- 로그인 사용자만 게시글 작성 가능
- 게시글 목록, 수정, 삭제 (본인만)
- 사용자 정보 조회 및 수정

## 💻 실행 방법
1. MySQL에 `database.sql` 실행 (테이블 및 초기 데이터 생성)
2. `application.properties` 파일 직접 생성 (Git에 포함 안 됨)
3. `./gradlew bootRun` 명령어로 실행
4. 브라우저에서 `http://localhost:8080` 접속

## 🔐 application.properties 예시 (Git에 포함 금지)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

mybatis.mapper-locations=classpath:mapper/**/*.xml
jwt.secret=yourSecretKey