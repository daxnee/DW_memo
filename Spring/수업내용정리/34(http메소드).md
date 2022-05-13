### 220509

- CREATE, DROP, ALTER(DDL) -> auto commit
- SELECT, INSERT, DELETE, UPDATE(DML) 

### 1. `DDL과 DML * 핵심 차이점?`
```
=> `AUTO COMMIT 여부`
```
### 2. MyBatis INSERT, DELETE, UPDATE
```
=> `자동으로 COMMIT!` (그래서 로직 짤 때 잘해야만 실수가 발생하지 않는다.)
```

### 3. MyBatis INSERT, DELETE, UPDATE에서의 return은 결과 수를 리턴한다.(int)
```
insert된 (처리된) 행의 수
ex) 만약 delete가 5행 됐다면 => return은 5 

```
### 4. MyBatis INSERT, DELETE, UPDATE(사실 delete -> insert) : `트랜잭션`


### `웹에선 url 주소가 같으면 안된다. But 가능한 경우가 있음!`
```
ex) GetMapping("/naver/news")
    GetMapping("/naver/news") => 두 개가 같아서 오류남


    Get, Post, Delete (html 메소드(기능))


    GetMapping("/naver/news") : 조회
    PostMapping("/naver/news") : 수정 => 두개의 html메소드를 달리해주면 오류가 안남
```

### `get과 post의 차이점` 
```
get : 데이터를 header(주소)에 심어서 보내줌 (public)
post : 데이터를 body에 심어서 보내줌 (private) ex) 회원가입 정보

- 중요한 정보를 보내거나, 데이터를 많이 보낼 때 post를 사용한다.
    * 데이터 공간 get < post

```

### `postman에서 post 해보기`

1. eclipse
```java
@PostMapping("/emp")
	public int callEmpSet(@RequestBody EmpVO empVO) { // 데이터를 EmpVO에 맞춰서 보내겠다
		 System.out.println("사원이름은 : "+ empVO.getEname());
		 System.out.println("사원번호는 : "+ empVO.getEmpno());
		 
		return 0;
	}	
```
2. postman 
``` 
post -> body -> raw -> json 설정 후 

{
    "ename": "양다은",
    "empno" : 1
}

입력 후 send 하면 이클립스 console창에 결과가 뜬다.

```
### `사수가 쿼리 작업을 시켰다? => 디비버에서 해당 데이터의 명세서(properties)를 봐야한다
```
not null이 어떤 컬럼인지 꼭 확인해야 한다.
확인해서  insert시 데이터 설정해서 넣어줘야 한다.

```

### Insert 와 Update는 파라미터로 객체를 넘겨준다
### `insert`
```
post -> Body(insert할 데이터 입력) -> raw -> Json

*Body에 insert할 데이터 입력하는 방법
1. xml에 있는 #{}는 컬럼명 확인
2. 해당되는 컬럼은 postman body에 json 형식으로 입력해줘야 한다.
ex) 

{
    "ename": "고양이",
    "empno" : 1004,
    "deptno" : 30
}


```

### delete
Delete -> url에 파라미터로 받은 값을 적어줌 
ex)
http://localhost:8080/emp/empno/9010 


### update
patch -> body(update할 데이터 입력) -> raw -> JSON

ex) 
{
    "comm"  : 3000,
    "empno" : 9000
} // empno가 9000인 사람의 comm을 3000 update
//해당 update 쿼리문은 xml 파일 안 쿼리문 참고  


### update시 오류 해결방법 (update insert delete에 필수!) - `트랜잭션`

```
만약 서비스 로직이 오류났을 경우, 웹은 오류가 나지만 
웹에서는 에러인데 sql에서 데이터는 업로드 되었다?! 

500 : java에서 에러

- 비즈니스로직(Service)때문에 에러가 난거니까 어노테이션으로 해결하면 된다.

```
```java
@Transactional(rollbackFor = {Exception.class}) // 메소드 위에 적어주면 된다
public int getEmpUpdateCount(EmpVO vo) {
		int rows = empMapper.updateEmp(vo);
		return rows;
	}

// : 이 메소드에서 에러가 나면 이전 시점 커밋으로 돌려줘
```

### 문제 풀기

job이 manager이고 sal이 2500 이상 받는 
사원을 comm 500으로 업데이트후
사원 이름ename, 직업job , 커미션 comm 조회

로직구현은 서비스에서 하기



