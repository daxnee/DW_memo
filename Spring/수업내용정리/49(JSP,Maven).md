### 220608
---
## JSON
---
### JSON key로 value값 출력하기
```
1. json에서 key 입력하면 value 값 나오는 개념 잊지 않기 

json == 데이터 형식
ex)  사내 이메일 작성형식
보안, 백엔드, 네트워크(클라우드 포함), IoT, 채팅프로그램
```

### JSON 예시
``` 
ex1)
var list = {
name : "daeun",
hobby : ["영화", "운동"], //  영화 출력 => list.hobby[0] 
family : {
	name : "아빠",
	age : 60
  }
}

list.hobby[0] => 영화
list.family.name => 아빠


ex2)
var data = {
name : 홍길동,
list : [1,2,3]
}

data.name => 홍길동
data.list[0] => 1
```

---

### SPRING framework => SPRING BOOT 차이점1
```
1) Embed Tomcat을 사용(Spring Boot 내부에 Tomcat이 내장돼있음)  별도로 Tomcat 설치, 버전관리 불필요

2) starter을 통한 dependency 자동화 : dependency들의 호환되는 버전을 일일이 맞추지 않아도 된다. 
 (starter가 대부분의 dependency를 관리해줌)

3) XML설정을 하지 않아도 된다.

4) jar file을 이용해 자바 옵션만으로 손쉽게 배포가 가능.
(Spring Actuaor를 이용한 애플리케이션의 모니터링과 관리를 제공)

 web.xml( spring은 main 함수가 없어서 여기서 실행함)

출처 : https://velog.io/@courage331/Spring-%EA%B3%BC-Spring-Boot-%EC%B0%A8%EC%9D%B4
```
### SPRING framework / SPRING BOOT 차이점2
```
SPRING framework : main함수 없음 web.xml에서 실행

SPRING BOOT : main함수 있음
```
---
## 톰캣(Tomcat) / 서블릿컨테이너 
---
### 1. 서블릿 / 서블릿컨테이너 

`서블릿 / jsp?` 
```
서블릿 : java소스코드가 속에 html소스코드가 들어가는 구조를 갖는 웹 어플리케이션 프로그래밍 기술

jsp : html소스코드 속에 java소스코드가 들어가는 구조를 갖는 웹 어플리케이션 프로그래밍 기술
```

`서블릿 컨테이너`
```
서블릿컨테이너 : 서블릿들의 생성, 실행, 파괴를 담당. 서블릿을 담는 상자이다. *컨테이너(담다, 품다) 
- Clinet의 Request를 받아주고 Response할 수 있게, 웹 서버와 소켓을 만들어 통신한다.
- 우리가 만든 mvc(service, controller)를 서블릿컨테이너에 담아야 실행이 가능함.

대표적 서블릿 컨테이터로 'Tomcat'이 있다. 
```

`톰캣`
```
톰캣 : 대표적 서블릿컨테이너 서비스 종류 중 하나

- 웹서버와 소캣을 만들어 통신하며 JSP와 Servlet이 작동할 수 있는 환경을 제공해준다
- 톰캣을 설치해야 포트가 열린다
포트가 열린다?(포트번호 8080) => 서버가 열렸다


출처 : https://velog.io/@han_been/%EC%84%9C%EB%B8%94%EB%A6%BF-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88Servlet-Container-%EB%9E%80

```



###  2. 톰캣(Tomcat)
```

```
---
## JSP 프로젝트 
---
### 1. MAVEN 설정 방법

1) 파일 다운로드
```
jsp이름으로 파일 다운로드(https://start.spring.io/) 압축 풀기 - import(워크스페이스에 압축 풀기 - 이클립스 임포트 - jsp 파일 선택 - import) 
```

2) 롬복 설정
```
메이븐은 pom.xml에서 롬복 설정을 해줘야 한다.
* refresh 안해도 자동으로 설정된다.
```

![jsp_xml](https://user-images.githubusercontent.com/96815399/172520911-0511d05d-3e86-4535-98cc-0cdc7ec8646e.PNG)
	* version 지우기 => 지우면 최신버전으로 다운받는다는 의미임(저장하면 자동 refresh)

---

### 2. jsp 패키지 만들기(이클립스)
```
src/main/java 우클 -> new -> 소스 폴더
src/main/wepapp 생성 
src/main/wepapp 우클 new -> 제너럴 -> folder
'web-inf' folder 생성
'web-inf' 하위에 'views' folder 생성
기존에 있던 index.jsp 복사
'views'에 붙여넣기
```

### 3. index 내용 설정 
```
이미지 추가 예정

```


### maven DB ** (내용 보충하기)
```
maven repository 검색
https://mvnrepository.com/ 
추가할 프로그램 검색 ex) oracle (버전은 회사마다 다르니 물어보고 다운로드 받기)

```
---
## JSP 특징
---
### HTML / JSP 차이점
```
HTML = html + js + css
JSP (Java Server Page) = html + js + css + java  =>  확장자가 '.jsp' 이다. (java가 하나 더 추가된 형태)
```

### JSP 리턴타입은 `파일이름` 으로 설정한다 ex) index.jsp
```
html은 리턴 타입이 json
jsp프로젝트 안에 있는 jsp파일(index.jsp)
그래서 jsp 프로젝트가 내부에 있는 jsp 파일만을 내꺼라고 인식함
(기존의 html을 url로 호출해서 json으로 데이터를 주고 받고 했는데 jsp는 그게 안됨) 


내부 : jsp (Java Server Page라서 java 프로젝트 안에 있어야만 호출이 가능하다. restcontroller로 호출 불가능, controller로 호출함)

외부 : html (@CrossOrigin 에러가 발생된 이유) : 모르는 외부 데이터를 호출하니까 **?


jsp에서 ajax도 가능하다! 왜? 기존 html에 jsp가 추가된거니까 
(ajax를 사용하려면 중간에 처리해주는 시스템이 필요함. 그건 다음 시간에...)

```
### jstl (내용 보충)
```
https://velog.io/@ye050425/JSP-JSTL-%EC%A0%95%EB%A6%AC

```


###

영아이티
핸디소프트 
솔탑
대연아이앤티
메이아이