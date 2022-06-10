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
### JSP pom/xml 설정
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


/ == ROOT 경로 

C:/ ROOT 
 
프로그래밍에서 루트는 최상위 권한을 의미함
루트 권한, 루트 경로 


ex) 자바에선 object , 디비버에선 root 계정 


--- 
세션 :  서버가 다운되거나 혹은 만료시간이 지나기 전까지 데이터를 보관하는 기술
데이터베이스 x
서버(웹서버)에 임시적으로 보관

대표적인 세션 : 회원 정보(PK, 이름)
세션에 저장하지 않으면 회원정보를 select해야함(DB에 요청을 계속해야됨)



// @ResponseBody : return을 json으로 @Controller를 하면  return은 페이지 이름으로 해야함 
페이지 이름이 아니라 json으로 return 하고 싶을 때 @ResponseBody  사용
단,  컨트롤러가 @Restcontroller가 아니라면 

@ResponseBody  : 나는 기존 controller처럼 페이지 리턴으로 하는게  아니라 json으로 리턴할거야



### 220610

http://localhost:8080/board?pageNum=1&pageSize=10 임시 보관