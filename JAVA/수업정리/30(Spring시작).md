### 220502
## Spring 
#### 언어마다 다른 프레임워크(툴)
```
javaScript -> node.js
python -> flask, 장고
c -> asp
java -> spring
```

### Spring을 배우는 이유?
- Spring은 검증된 툴이다.
    * 검증 ? 많은 오류를 거쳐도 끄떡없는 프로그램 
- 검증 되었으니 회사에서도 Spring을 사용하는 개발자를 원함. 
- 교육기관에서도 Spring을 베이스로 교육한다.

결론 : 수요가 많다.

### Spring이란?
- Java로 다양한 어플리케이션 (웹 or 앱)을 만들기 위한 프레임워크
쉽게 생각해서 플랫폼 == 프레임워크
    - 이 프레임워크가 Spring을 말한다.

### Spring 종류 

1. Spring 레거시 (일반 Spring)
2. Spring boot (경량 Spring)
3. Spring 전자정부프레임워크 (egov)

    * 1,3은 거의 비슷함

### Spring하고 같이 사용하는 친구들 ***  *기술면접

- Spring만으로 어플리케이션을 개발하는데는 한계가 있다.
    (why? 데이터베이스, 고객에게 보여줄 화면 등등이 필요하다)

1. 데이터베이스 연결과 데이터 생성, 호출, 삭제, 수정을 도와주는 '*ORM*' 
- ORM? Object-relational mapping (객체 관계 매핑)

    - MyBatis(우리가 배울 것), JPA

2. 필요한 기능을 쉽게 다운로드 받을 수 있고, 서버에 업로드(배포)를 도와주는 *'빌드관리도구'*(Build Tool)
    - Gradle(우리가 배울 것), Maven
    
3. 화면을 도와주는 *'템플릿 엔진'*
    - JSP, Thymeleaf(우리가 배울 것)

    API식으로 데이터를 전달하는 방법도 있음 

4. 속성(데이터베이스 주소, 아이디, 비번) 정의를 담당하는 *'속성 파일'*!
    - yaml(야믈)(우리가 배울 것), properties 

5. 서버를 담당하는 Tomcat (서버에 올리고 다운되지 않게 관리해주는 프로그램)
    - Tomcat 하나 밖에 없다.

6. 그 외 Docker(도커), GraphQL(그래프큐엘) * optional


### Spring툴 sts 설치(IDE)
```
sts(start.spring.io) - Tools Spring-  Spring Tools 4 for Eclipse 64로 설치 - 압축 풀기 -  contents.zip 압축 풀기 - SpringToolsuite4.exe 열기 

내pc - workspace - spring-workspace로 경로설정(폴더 새로 만들었음)
```
### 회사 실무시 설정해야 하는 사항
이클립스 or sts 사용한다면 

1. 한글 설정
    ide 상단바에 window -> prefenrences -> encoding 검색 -> workspace 선택 ->  text file encoding - > other  선택 -> UTF-8 선택 -> Apply and Close

2. 폰트 설정
    window - preferences - general - Apperance - color and fonts - basic - text Font - edit - 폰트와 크기 설정

3. 빌드관리도구 설치
    그래들 - 자바 - 2.6.7 - Artifact(이름 설정) : 프로젝트 이름이 됨(first-spring으로 이름 설정함) - 
    현재 쓰고 있는 자바보다 높은 버전은 사용이 불가능. 학원에서는 12를 쓰고 있으니까 그 아래로 설정하기 - add Dependencies 클릭 - spring wep 클릭 - Generate - 다운로드 받은 알집 파일 spring workspace에 파일 두고  '여기에 압축 풀기' 실행 (*파일 추가로 생성되지 않게 주의해서 압축풀기!)

    다시 스프링 툴로 돌아가서 
    import 프로젝트 - 그래들 클릭 - 안에 있는 exsting 어쩌고 코끼리 클릭 -  넥스트 -  아까 압출 풀었던 first-spring 파일로 경로 설정 

---

### 이클립스로 시작하기
이클립스  on - file - switch workspace - other - 경로설정
- 1번 한글설정 하기 - import projects- 그래들 - 코끼리 선택 - next
- 경로 설정 (c드라이브- workspace - first_spring)


### Spring 패키지 만들기 
- dw.daeun.study 
    - dw 안에 daeun 안에 study 패키지가 3개 있는 구조
    - ex) www.naver.com 과 같은 구조라고 보면 됨. spring의 암묵적인 약속이다.

### Spring 패키지 암묵적인 약속
- 패키지는 3개 부터 시작한다(default)

com.naver.www 

반대로 패키지를 생성하되 가운데는 회사 이름이 들어가야 한다.
첫번째 패키지 : com. io. kr 등등
두번째 패키지 : 회사이름
세번째 패키지 : www가 아닌 프로젝트명을 기재해준다. (www 안씀)

### controller
- controller 패키지 생성

controller : url 요청을 받는 곳. 스프링이 클래스는 url을 요청받는 곳이야~ 라고 인식해줌 

- controller 설정해주기

: @Controller + import (ctrl + shift + o) 해주면 됨 
getMapping으로 url을 설정해주고 
주소창에 
해당 로컬주소 + 설정한 url 검색하면 내가 설정한 메소드 실행결과가 나온다.


### localhost
내꺼를 보고 싶다면 이렇게 검색해도 된다.
localhost:8080/index

### 두번 실행할 시 오류 나는 이유
포트 번호(8080)는 고유한 번호임
두번 실행되니까 오류가 남 (already ~ in use)
콘솔창 우측 상단 컴퓨터 아이콘 
눌러서 원래 실행된 거 중지 (빨간색 네모)


### 자동으로 restart 되는 기능
1. devtools gradle 검색

2. compileOnly("org.springframework.boot:spring-boot-devtools") 복사 
 
3. 이클립스 좌측에 build.gradle 클릭  -> dependencies 아래줄에 복붙 , 저장 -> build.gradle 오른쪽 클릭 - > gradle -> refresh gradle projects (바꾼 내용을 저장하겠다는 의미)

이렇게 설정하면 컴파일 (ctrl + f11) 하지 않아도 
자동으로 변경 사항을 인식한다 (저장만 해주기)

### 스프링은 new로 클래스를 호출하지 않아도 알아서 호출해준다.


### getter setter 설정해주는 기능
1. spring lombok gradle 검색 - 첫번째 사이트 - 

2.  compileOnly 'org.projectlombok:lombok:1.18.24'
	annotationProcessor 'org.projectlombok:lombok:1.18.24'
	
	testCompileOnly 'org.projectlombok:lombok:1.18.24'
	testAnnotationProcessor 'org.projectlombok:lombok:1.18.24'

3. 복붙하고 dependencies에 붙여넣기 +

4. refresh 해주고 import해주면 됨 

* 또 다른 방법 @Getter , @Setter 대신 @Data 써줘도 된다.


### lombok 오류 해결 
 help -> install new software -> add -> name : lombok - location : https://projectlombok.org/p2 -> lombok 체크 박스 체크 -> next -> accept -> finish -> 이클립스 재실행


만약 안된다면 

### lombok 또 다른 오류 해결 방법

구글에 '이클립스 lombok 인식' 검색하고 
관련 글의 블로그에 올려둔 파일 설치하면 된다.


오류 났을땐  
lomboc.jar 파일 있는 폴더 바탕에 git bash창 켜기
java jar- 하고 tap키 누르면 자동으로 뜸 , 엔터
체크 박스 선택하고 설치 -> quit install하고 이클립스 재실행   


### @AllArgsConstructor

@AllArgsConstructor : 자동으로 생성자를 만들어줌

###
com.example.first_spring 안에 com.example.first_spring.controller 패키지 만들고 
안에 com.example.first_spring.vo 패키지 만들기


