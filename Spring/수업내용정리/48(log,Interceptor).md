### 220603 

### 로그 기록 조회
1. TABLE CREATE하기
```sql
-- 접속이력 테이블
CREATE TABLE IF NOT EXISTS board_logs
(
	log_id BIGINT(20) AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '로그 아이디',
	ip VARCHAR(50) COMMENT '아이피',
	latitude VARCHAR(20) COMMENT '위도',
	longitude VARCHAR(20) COMMENT '경도',
	url VARCHAR(100) COMMENT '요청 url',
	http_method VARCHAR(10) COMMENT 'http method',
	create_at DATETIME COMMENT '접속 시간'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```


### 시간 데이터 처리 
```
- 시간이 중요한 프로그램은 서버에서 시간을 설정하고 DB에 Insert하도록 설정한다.

- 기록에 대한 데이터는 insert, select만 구현한다.  update/delete x 
    ex) 통장 거래 내역 
```

### interceptor
```java
registry.addInterceptor(interceptor).excludePathPatterns("/api/v1/logs"); // console에서 ip,url,안나옴 
		// 이 url은 가로채지 말라는 뜻임 (url 요청을 해도 웹에서 안 나온다.)

```

### Interceptor 예시

```java 

@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//우리가 만든 interceptor를 스프링에 등록
		registry
		.addInterceptor(interceptor)
		.excludePathPatterns("/api/v1/logs","/login", "/join","/api/v1/login", "/resources/static/css/*"); // "/resources/static/css/* : 설정된 경로를 인터셉트"
		// 이 url은 가로채지 말라는 뜻임 (요청을 해도 안 나옴) excludePathPatterns 안에 적은 url은 console에 찍어도 ip,url,Method가 안나옴

// => login.jsp의 href 경로를 모두 포함시켜 인터셉트 하겠다
	
	}
```


### 서버 오류 참고 사이트
https://luckyyowu.tistory.com/377
