# spring-security-with-oauth2.0
이동욱 님의 [스프링 부트와 AWS로 혼자 구현하는 웹 서비스](https://jojoldu.tistory.com/463)의 예제를 보고 만든 프로젝트입니다.
<br>
**Spring Securit**y와 **OAuth2.0**으로 Google의 소셜 로그인 기능을 구현합니다.

<br><br>

# 필요한 의존성
- 소셜 로그인 기능 구현
`implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'`

- mustache 템플릿 엔진 사용
`compileOnly 'org.springframework.boot:spring-boot-starter-mustache'`

<br><br>

# 파일 설명
## 사용자 관련
- `User` : 로그인 한 사용자 정보

- `TimeEntity` : 사용자 생성 및 수정 시점

- `Role` : 사용자 권한 관리를 위한 Enum 클래스

<br>

## 보안 관련
- `SecurityConfig` : 보안 설정

- `CustomOAuth2UserService` : 소셜 로그인 성공 후 가져온 사용자 정보들을 기반으로 User 생성 및 수정, Session에 저장

- `OAuthAttributes` : OAuthUser의 속성들을 담는 곳<br>
→ `CustomOAuth2UserService` 에서 User 생성 및 수정 시 OAuthUser의 속성을 `OAuthAttributes`에 담아 사용

- `SessionUser` : `CustomOAuth2UserService` 에서 User 생성 후 Session에 사용자 정보를 담음<br>
→ 웹 접속 후 세션에서 사용자 정보를 불러올 때 사용

<br>

### `SessionUser` 를 따로 생성하는 이유
- Session에 저장하기 위해선 **직렬화**를 해야 한다.
- User 클래스는 다른 Entity들과 관계가 형성될 수 있는 Entity이기 때문에 User 클래스를 직렬화하면 **성능 이슈와 부수 효과**가 발생할 수 있다.
- 직렬화 기능을 가진 Session DTO를 추가로 생성해 사용하는 것이 **운영 및 유지 보수**에 편리함

<br><br>

# 디렉토리 구조
```bash
┌── config
│      └── SecurityConfig
├── controller
│      └── IndexController
├── domain
│      └── dao
│           └── UserRepository
│      └── dto
│           ├── OAuthAttributes
│           └── SessionUser
│      └── model
│           ├── Role
│           ├── TimeEntity
│           └── User
└── service
       └── CustomOAuth2UserService
``` 
