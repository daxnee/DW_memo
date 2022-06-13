### 220609

---
### jsp 프로젝트 properties 설정
---
```
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
server.servlet.session.timeout=30
```


---
### JSP pom/xml 설정(build tools)
---
```
	<dependencies>
	<!--JSP-->
		<dependency>
		    <groupId>org.apache.tomcat.embed</groupId>
		    <artifactId>tomcat-embed-jasper</artifactId>
		    
		</dependency>
		<dependency> 
			  <groupId>javax.servlet</groupId> 
			  <artifactId>jstl</artifactId> 
			  <version>1.2</version> 
		</dependency>
		
		<!--session-->
		<dependency>
		    <groupId>org.springframework.session</groupId>
		    <artifactId>spring-session-core</artifactId>
		    <version>2.7.0</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```
![pom_xml](https://user-images.githubusercontent.com/96815399/172775271-bde5acb2-4045-42b3-ac04-a86cdf4fce30.PNG)




---
### Session
--- 
```
세션 :  서버가 다운되거나 혹은 만료시간이 지나기 전까지 데이터를 보관하는 기술
데이터베이스에 저장하지 않고 Server(웹서버)에 임시적으로 보관한다.

대표적인 세션 : 회원 정보(PK, 이름)
세션에 저장하지 않으면 회원정보를 select해야함(DB에 요청을 계속해야됨)
```

### @ResponseBody
```
@ResponseBody : return을 json으로 @Controller를 하면 return은 페이지 이름으로 해야함 
페이지 이름이 아니라 json으로 return 하고 싶을 땐 @ResponseBody  사용
단, 컨트롤러가 @Restcontroller가 아닐때 사용 가능!

@ResponseBody  : 나는 기존 controller처럼 페이지 리턴으로 하는게  아니라 json으로 리턴할거야
```
```java
@PostMapping("/login")
		public @ResponseBody boolean callLogin(@RequestBody Map<String, Object> data, HttpSession httpSession) {
			 
			String userId = (String) data.get("userId"); // HttpSession이 클래스니까 String으로 형변환 해주기
			String userPassword = (String) data.get("userPassword");
			
			System.out.println("userId ==> "+userId);
			System.out.println("userPassword ==> "+userPassword);
			
			//세션에 데이터 SET
			httpSession.setAttribute("userId", userId);
			httpSession.setAttribute("userPassword", userPassword);
			// userId,userPassword를 DB에 저장이 아닌 세션(자바웹서버)에 임시로 보관
			// 서버>세션 
			
			return true;
		}
```
---


### Board 웹 url 주소
```
http://localhost:8080/board?pageNum=1&pageSize=10 
```
---

### @CrossOrigin
```
java 프로젝트 안에 html 프론트 프로젝트를 넣어서 
Spring이 자기 프로그램이라고 인식하는 것임 
그래서 @CrossOrigin 필요 없음
```
---
### JSP 로딩 순서
```
1. 클라이언트가 어떤 동작을 함으로써 hello.jsp 를 요청하였다.
2. JSP 컨테이너가 JSP 파일을 읽는다.
3. JSP 컨테이너가 Generete (변환) 작업을 통해 Servlet ( .java )  파일을 생성한다.
4. .java 파일은 다시 .class 파일로 컴파일된다.
5. Execute (실행) 을통해 HTML 파일을 생성하여 JSP 컨테이너 에게 전달한다.
6. JSP 는 HTTP 프로토콜을 통해 HTML 페이지를 클라이언트 에게 전달한다.
출처: https://javacpro.tistory.com/43 [버물리의 IT공부:티스토리]
```