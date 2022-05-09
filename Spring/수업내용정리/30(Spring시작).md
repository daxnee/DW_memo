### 220502
## `Spring` 
#### 언어마다 다른 `프레임워크(툴)`이 있다. 여기서 spring을 배울 것임
```
javaScript -> node.js
python -> flask, 장고
c -> asp
java -> spring
```
### `Spring을 배우는 이유?`
```
- Spring은 검증된 툴이다.
    * 검증 ? 많은 오류를 거쳐도 끄떡없는 프로그램 
- 검증 되었으니 회사에서도 Spring을 사용하는 개발자를 원함. 
- 교육기관에서도 Spring을 베이스로 교육한다.

=> 결론 : 수요가 많다.
```

### `Spring을 배우기 앞서...`
- 원리를 이해하기 보단 일단 작동 방법을 익히는 게 중요! ex) 운전 방법을 익히는  

---
### `Spring이란?`
- `Java`로 다양한 어플리케이션 (웹 or 앱)을 만들기 위한 `프레임워크`
    - 쉽게 생각해서 `플랫폼` == `프레임워크`

### `Spring 종류`
```
1. Spring 레거시 (일반 Spring)
2. Spring boot (경량 Spring)
3. Spring 전자정부프레임워크 (egov)

    * 1,3은 거의 비슷함
```

### `Spring하고 같이 사용하는 친구들 ***`  *기술면접*
-`Spring만으로 어플리케이션을 개발하는데는 한계가 있다.`
 why? 데이터베이스, 고객에게 보여줄 화면 등등이 필요하다)

1. 데이터베이스 연결과 데이터 생성, 호출, 삭제, 수정을 도와주는 `ORM` 
- ORM? Object-relational mapping (객체 관계 매핑), spring과 DB를 연결해주는 역할

    - MyBatis(우리가 배울 것) 
    - JPA

2. 필요한 기능을 쉽게 다운로드 받을 수 있고, 서버에 업로드(배포)를 도와주는 *'빌드관리도구'*(Build Tool)
    - Gradle(우리가 배울 것) : **Gradle은 프로그래밍 언어다
    - Maven
    
3. 화면을 도와주는 *'템플릿 엔진'*
    - JSP 
    - Thymeleaf(우리가 배울 것)
    - React, View 등등 

    API식으로 데이터를 전달하는 방법도 있음 

4. 속성(데이터베이스 주소, 아이디, 비번) 정의를 담당하는 *'속성 파일'*!
    - yaml(야믈)(우리가 배울 것)
    - properties 
        - resourse 안에 application.properties 가 있고 
        스프링 부트 안에 디폴트로 properties가 들어있다.
        * 여기에 자바와 관련 없는 것들(html, css, js, img 등등)을 넣어줄 것임

        help - Eclipse Marketplace - find에서 검색 - yaml -  yaml Editor 1.9.0 설치 - 재시작 

        sql 접속 정보 설정 
        resourse 에 패키지 생성 sqlmap -> xml - mxlflie - 파일 이름 : sqlmapper_emp.xml (_ 다음엔 내가 설계할 테이블 이름이 온다.) - finish
         - 생성된 파일에 sql쿼리를 작성하면 됨(Source)

        - 아까 만들어놓은 야믈 파일에 sql위치를 작성해준다

5. 서버를 담당하는 Tomcat (서버에 올리고 다운되지 않게 관리해주는 프로그램)
    - Tomcat 하나 밖에 없다.

6. 그 외 Docker(도커), GraphQL(그래프큐엘) * optional



### `Spring툴 sts 설치(IDE)`
```
내pc -> c드라이브 -> spring-workspace 폴더 만들기
sts tools -> Tools Spring ->  Spring Tools 4 for Eclipse 64로 설치 -> 압축 풀기 ->  contents.zip 압축 풀기 -> SpringToolsuite4.exe 열기 -> 아까 만들었던 spring-workspace 폴더로 경로설정
```
### `회사 실무시 설정해야 하는 사항`
이클립스 or sts를 사용한다면 

1. `한글 설정` (설정해야만 다운로드 받을 때 한글이 깨지지 않는다)
```
ide 상단바에 window -> prefenrences -> encoding 검색 -> workspace 선택 ->  text file encoding - > other  선택 -> UTF-8 선택 -> Apply and Close
```

2. `폰트 설정`
```
window - preferences - general - Apperance - color and fonts - basic - text Font - edit - 폰트와 크기 설정
```

3. `빌드관리도구` `Gradle` 설치 (빌드 tool)
```
1) start.spring.io 접속 -> Gradle - Java -  Spring Boot2.6.7 - Artifact(이름 설정) : 프로젝트 이름이 됨(first-spring으로 이름 설정함) - java 버전 11로 선택(현재 쓰고 있는 자바보다 높은 버전은 사용이 불가능. 학원에서는 12를 쓰고 있으니까 그 아래로 설정하기) - add Dependencies 클릭 - spring wep 클릭 - Generate - 다운로드 받은 알집 파일 spring workspace에 파일 두고  '여기에 압축 풀기' 실행 (*파일 추가로 생성되지 않게 주의해서 압축풀기!)

2) 다시 스프링 툴로 돌아가서 
import 프로젝트 - 그래들 클릭 - 안에 있는 exsting 어쩌고 코끼리 클릭 -  넥스트 -  아까 압출 풀었던 first-spring 파일로 경로 설정 
```
---

### `이클립스로 시작하기`
```
이클립스  on - file - switch workspace - other - 경로설정
- 1번 한글설정 하기 - import projects- 그래들 - 코끼리 선택 - next
- 경로 설정 (c드라이브- workspace - first_spring)
```
### `Spring 패키지 만들기`
- dw.daeun.study 
    - dw 안에 daeun 안에 study 패키지가 3개 있는 구조
    - ex) www.naver.com 과 같은 구조라고 보면 됨. spring의 암묵적인 약속이다.

### `Spring 패키지 암묵적인 약속`
- 패키지는 3개 부터 시작한다(default)
ex) com.naver.www

- `3개 쓰는 이유?` :  패키지명으로 어떤 파일인지 확인이 가능하게 하려고.

- 반대로 패키지를 생성하되 가운데는 회사 이름이 들어가야 한다.

```
첫번째 패키지 : com. io. kr 등등
두번째 패키지 : 회사이름(조직이름) ex) naver
세번째 패키지 : www가 아닌 프로젝트명을 기재해준다. (www 안씀)
```
### `controller` 패키지(로직 구현 x)
- controller : `url 요청을 받는 곳`. 스프링이 클래스는 url을 요청받는 곳이야~ 라고 인식해줌, 이름이 controller로 끝나는 파일만 모여 있음.


###  `controller 설정해주기`
```
: @Controller + import (ctrl + shift + o) 해주면 됨 
- getMapping으로 url을 설정해주고 , 주소창에 해당 로컬주소 + 설정한 url 검색하면 내가 설정한 메소드 실행결과가 나온다.
    * getMapping : http 메소드 중 get으로 요청한 것임!
    * http : spring 결과를 하이퍼텍스트로 전송해주겠다
```
---
### `Service` 패키지(로직 구현)
서비스와 관련된 패키지만 올 수 있음
: @Service : 로직 구현이 실행될거야 라고 스프링한테 알려주는 것

### `localhost`
내 ip의 결과창을 보고 싶다면 이렇게 검색해도 된다. `localhost:8080/설정한 url`
 
### `두번 실행(컴파일)할 시 오류 나는 이유`
- `포트 번호(8080)`는 고유한 번호임 두번 실행(컴파일)되니까 오류가 남 (already ~ in use 오류메시지)
    - console 창 우측 상단 `컴퓨터 아이콘 옆 화살표` 누르면 실행된 기록이 나옴 첫번째 실행기록 눌러서 `중지`시키면 됨. (빨간색 네모)

이러한 번거로운 과정을 생략할 수 있는 해결 가능한 기능이 있다. ↓
### `자동으로 restart 되는 기능`
```
1. devtools gradle 검색

2. compileOnly("org.springframework.boot:spring-boot-devtools") 복사 
 
3. 이클립스 좌측에 build.gradle 클릭  -> dependencies 아래줄에 복붙 , 저장 -> build.gradle 오른쪽 클릭 - > gradle -> refresh gradle projects (바꾼 내용을 저장하겠다는 의미) (우측 하단에 다운로드바 확인)

이렇게 설정하면 컴파일 (ctrl + f11) 하지 않아도 
자동으로 변경 사항을 인식한다 (코드 변경시 저장만 해주기)

```
### `getter, setter 설정해주는 기능`

`방법1`
```
@Getter , @Setter 를 상단에 적어주면 끝
```

`방법2`
```
1. spring lombok gradle 검색 - 첫번째 사이트 접속

2.  compileOnly 'org.projectlombok:lombok:1.18.24'
	annotationProcessor 'org.projectlombok:lombok:1.18.24'
	
	testCompileOnly 'org.projectlombok:lombok:1.18.24'
	testAnnotationProcessor 'org.projectlombok:lombok:1.18.24'

3. 2번 내용 복붙하고 dependencies에 붙여넣기 (어떤 기능인지 주석처리 해주면 좋다)

4. refresh 해주고 import

5. VO 클래스의 메소드 상단에 @Data 써주면 된다.

```
### => 이 기능들을 start.spring.io 사이트에서 설치시 ADD DEPENDENCIES을 통해 일괄로 설치할 수 있다. 

---
### `lombok 오류 해결 방법 1`
```
 help -> install new software -> add -> name : lombok -> location : https://projectlombok.org/p2 -> add -> lombok 체크 박스 체크 -> next -> accept -> finish -> 이클립스 재실행
```

### * 만약 안된다면? ↓

### `lombok 또 다른 오류 해결 방법 2`
```
1. 구글에 '이클립스 lombok 인식' 검색하고 관련 글의 블로그에 올려둔 파일(lomboc.jar) 설치하면 된다.

2. lomboc.jar 파일 있는 폴더 바탕에 git bash창 켜기 
3. java jar- 입력 후, tap키 누르면 자동으로 뜸 + enter
4. 체크 박스 선택하고 설치
5. quit install하고 이클립스 재실행   
```
### `@AllArgsConstructor`

@AllArgsConstructor : 자동으로 생성자를 만들어줌

### `패키지 만들기`
```
com.example.first_spring 안에 com.example. first_spring.controller 패키지 만들고 
안에 com.example.first_spring.vo 패키지 만들기
```

### `VO / DTO 클래스`
getter, setter만 있는 클래스를 말한다. ex) UserVO




### 클래스 만드는 순서
1. 매퍼 
2. vo 만들고 
3. 마이바티스
4. 서비스
5. 컨트롤러

 



### `이클립스 -> github push 방법`
```
이클립스 우측 상단 Git 아이콘 클릭 -> git repositories 우클 -> commit -> 커밋할 내용들 확인 -> ++ 버튼(내용 전부 다 클릭) -> commit -> git repositories 우클 -> push to origin -> close

*만약 Git Repositories 안 보이면 상단 window -> Show view -> 메뉴 선택 
```

### `github -> 이클립스 pull 방법`
파일 clone 받고 - 노트북 이클립스에 import 

