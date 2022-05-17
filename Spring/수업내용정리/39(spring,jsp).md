### 220517

## `스프링 설치`

### 1. `https://start/spring.io/ 접속 ` -> `프로그램 다운로드`
![java설치](https://user-images.githubusercontent.com/96815399/168750046-8eff0485-4c70-4e32-b857-6d074d5ca18e.PNG)
* Gradle추가시 내가 사용했던 기능 이름만 잘 알아두기!

2. `workspace에 zip 파일 이동`

3. `여기에 압축 풀기`

4. `이클립스 상단 좌측 file -> import (Gradle)`
- 만약, 회사에서 Maven 쓰면 Maven폴더로 Import하면 된다. (Maven : Existing Maven Project)

    <import 후 파일명>

    ![import후_파일명](https://user-images.githubusercontent.com/96815399/168753178-2cc81af1-e9d5-47ac-952e-e1f4520001a7.PNG)


5. `yaml 수정`
 - MyBatist 에서  
        type-aliases-package: `com.dw.board.vo` 으로 수정 => 내 프로그램의 패키지명을 작성하면 됨

    ![yaml설정](https://user-images.githubusercontent.com/96815399/168753552-c7d13263-b3e4-4af7-ad4c-3d7bbf62fea8.PNG)


6. `sqlmap 패키지 생성` & `sqlmapper.xml 생성`

7. `banner, logback(내 쿼리 결과 보여주는) 기능 추가 ` (optional)

8. `MVC 패키지 생성`  & `MVC에 맞는 class 파일 생성`
* 패키지 생성시 : 기존에 생성돼 있는 com.dw.board에 new로 패키지 생성 하면 된다

    ![8 패키지만들기](https://user-images.githubusercontent.com/96815399/168753333-2ebcec38-5987-44b8-bb32-74050466619d.PNG)

9. `run 실행` 


--- 
## `jsp 설정`
### `1. jsp(템플릿 엔진) 폴더 만들기`
```
* 주의 사항: jsp만들때 board 안에 있어야 한다.
    jsp? html 안에서 java코딩이 가능한 파일


1. board(프로젝트명)에 - new - Source Folder - src/main/webapp 이름으로 설정

2. src/main/webapp 패키지 - General - folder - folder name : WEB-INF - WEB-INF 안에 views 라는 file 생성 
    *간혹 refresh하면 webapp 폴더가 없어지는 경우가 있음. 그럴땐 아래 src 폴더에 있으니 찾으면 됨

3. views -> NEW ->  Other -> Web -> JSPfile -> index.jsp(이름 설정) -> finish
```

### `2. jsp 경로설정`
```
jsp? html 안에서 java 코딩이 가능한 파일
jsp로 작업을 한다? => controller에서 url주소를 요청해서 확인을 해야한다는 뜻.

1. jsp로 쓸거라는 설정이 필요함
```
<경로설정>
![jsp경로설정](https://user-images.githubusercontent.com/96815399/168758120-5474bf85-e778-47d4-b980-d9a353ffa368.PNG)
```
2. Gradle - dependencies - jsp다운로드 - Gradle - refresh
    
    <JSP다운로드>
    implementation "org.apache.tomcat.embed:tomcat-embed-jasper"
	implementation 'javax.servlet:jstl'


* 이 안에서 html 파일을 관리한다 (작업시 확장자 jsp로 변경 필수!)
why? java 안에서는 html이 실행되지 않는다. 그래서 확장명을 jsp로 바꿔야만 
만든 웹페이지를 확인할 수 있다.
```

### `실무 협업시 tip!`
```
- 퍼블리셔가 html 작업을 끝내고 파일을 보내주면 백엔드 개발자는 모든 파일의 확장자를 jsp로 바꾸면 된다.

 * css, js은 그대로 static에 넣어주고 html 파일만 확장자 변경해서 views 파일 안에 넣어주면 된다
 (모든 퍼블리셔가 이렇지는 않음 케바케임을 알아두자)

    * 타임리프는 이런 불편함(확장자변경)이 없긴 하다ㅠ_ㅠ
```
---

### spring ~ jsp 세팅완료

---

### `js 설정하기`
```java
static에 css, js, images 폴더 만들기 : 여기 안에 3 종류의 파일들을 넣어서 관리하면 된다.

index.jsp 파일로 들어가서
body 안에 
<h1>Hello World!</h1> 
입력 후 

boardcontroller에 

```java
@Controller
public class BoardController {
	@GetMapping("/home")
	public String callHomepage() {
		return "index";
	}
}

// 이렇게 설정해주면 웹페이지 관리자 페이지에서 확인이 가능하다
```
<js폴더관리>

![js폴더관리](https://user-images.githubusercontent.com/96815399/168762273-4319b7f0-5ce1-4e4e-9acf-99e6c9be2ab2.PNG)



--- 
### `게시판 만들기 : 학원을 주제로 만들기`
```
<학생>
: 번호(pk), 이름 , 패스워드


<게시판>
: 번호(fk) , 제목,  내용, 수정날짜, 최초게시글 날짜

=> 1:N 관계임
```


### `이클립스에서 DB 데이터 설계하기 `
```
src/main/resources 우클 -> new - > other.. -> 제너럴 -> File - init.sql 파일 만들기 : 여기서 데이터 모델링 하면 됨
```

```sql
-- 학생 테이블
CREATE TABLE IF NOT EXISTS students( -- 만약 students가 존재하지 않는다면
    students_id INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '학생 아이디',
    students_name VARCHAR(20) COMMENT '학생 이름',
    students_password VARCHAR(200) COMMENT '학생 비밀번호', 
    --비번,폰번호, 주소는 암호화해야 하기 때문에 데이터 수를 일부러 크게 설정한다. (개발자도 모르게)
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '가입 날짜' 
    -- DEFAULT CURRENT_TIMESTAMP 디폴트 뒤에 디폴트 값 입력 해줘야한다  (ex.현재시간)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 게시판 테이블
CREATE TABLE IF NOT EXISTS board
(
    board_id INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '게시판 아이디', --AUTO_INCREMENT: pk가 추가로 인서트 될때마다 1씩 자동 증가되는
    students_id INTEGER(4) COMMENT '학생 아이디',
    title VARCHAR(50) COMMENT '제목',
    content VARCHAR(100) COMMENT '글 내용',
    update_at DATETIME COMMENT '수정 날짜',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '작성 날짜',
    CONSTRAINT board_students_id_fk FOREIGN KEY (students_id) REFERENCES students(students_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

```

### `만약 디비버에 dw 라는 데이터베이스가 없다면?`
```sql
CREATE database IF NOT EXISTS dw DEFAULT CHARACTER SET
utf8 COLLATE utf8_general_ci;

-- DB추가가 가능!
```

### `DB 업데이트 전 설정사항`
```sql
initialization-mode: always 
* 실행 안 시킬거면 : never
schema : classpath:init.sql
```
![sql_db실행](https://user-images.githubusercontent.com/96815399/168762982-a6e6580f-f396-48ab-a630-3acfb6bdf4db.PNG)


### `컴파일` 실행하면 db에 데이터 추가 완료~!

--- 

### AWS 회원가입 
```
AWS : 아마존 클라우드 
계정 : das03041@gmail.com 
계정생성 -> 콘솔 -> 나라 선택(서울) 
좌측 상단 검색창에 ec2 ->

```