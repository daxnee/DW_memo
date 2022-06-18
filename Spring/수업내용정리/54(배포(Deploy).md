### 220617

### Public IP에 배포하면 어느 공간에서든 사용할 수 있음
- 언어마다 배포하는 방법이 다름
Java 배포 툴 : Gradle, Maven (Spring, Android)
    - zip 파일처럼 압축파일로 만들어서 배포해야 한다.
---
### `jar / war`
```
업로드 x , 배포 (Deploy)

.jar(자르) : 바로 실행 가능한 어플리케이션(프로그램) 
.war(와르) : 바로 실행 가능이 불가한 어플리케이션(프로그램) *egov(전자정부프레임워크), spring은 얘만 가능
```
### egov/ spring / boot/
```
- Spring boot - 내장톰캣이라는 기능이 있음. => .jar 가능
- Spring,Spring egov - 내장톰캣이라는 기능이 없음 => .jar 불가능  

Spring egov, Spring은 톰캣을 설치 해야함. (war 배포만 가능하니깐) -> war를 위한 톰캣을 설치한다라고 생각하면 쉽다

만약 Spring boot으로도 war로 배포(업로드)하고 싶다? =>  톰캣을 설치 해야함.
```
---
---
### 배포 설정
- 빌드(컴파일준비) -> 컴파일 -> 실행 순서
    * 빌드? gradle에 설치한 것들을 한 번에 모아줌
---

0. bulid.gradle 에서 설정추가(refresh)
```java
plugins {
	id 'org.springframework.boot' version '2.6.7'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
	id 'war'
}
bootWar{
	archiveBaseName = 'board'
	archiveFileName = 'board.war'
	archiveVersion = '0.0.1'
}
```

1. gradle 추가
```java
//deploy
providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
```

2. BoardApplication에 추가
```java
@SpringBootApplication
public class BoardApplication extends SpringBootServletInitializer{ //
내장 톰캣 떼려면 상속 받아야 한다

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
```

3. war 파일 생성
```
-> Gradle Tasks 탭 클릭(빌드라는 것을 통해 컴퓨터가 알아들을 수 있게 해야한다)
-> bulid 폴더 열기
-> Gradle Tasks 클릭
-> clean 클릭
-> bootWar 클릭
-> war 파일 생성확인(war 파일 수정 시간 확인) 
->이름 수정 : ROOT.war
```

<war 파일 경로 확인>

![war경로](https://user-images.githubusercontent.com/96815399/174435228-1a136aae-66eb-49ca-935b-84f76b1c34e1.png)

### 배포하기 
---
1. XShell 열기 (clear) 
```
-> pwd (현재 위치 ROOT 확인)
-> 상단의 `새 파일 전송` (초록색 버튼) 클릭(파일전송) 
     * ftp? : 원격에서 파일을 보내는 파일전송 프로토콜
-> Xshell창에 ROOT.war  끌어서 업로드 (ls해서 현재 경로의 파일 확인)
```

![파일업로드](https://user-images.githubusercontent.com/96815399/174217027-e8b5e64d-4383-450c-a0ec-ed2090eadebe.png)
 * 주의점 : tomcat 권한은 ROOT만 갖고 있기 때문에 ROOT 계정으로 접속해줘야 한다 (- su)    
```  
-> su - 입력 : root로 로그인
-> pwd (root인지 확인)
-> cd /home/ubuntu(우분투에 파일이 있으니까 루트에 들어가야 된다)

-> 다시 cd .. (home으로 돌아가기)
-> cd tomcat (톰캣으로 이동) , ls로 현재 파일 확인 
-> cd webapps
-> 파일 삭제 : rm -rf * (파일 강제 삭제)   
-> cd /home, ls로 삭제 파일 잔여 여부 확인
-> cd home/ubuntu (우분투로 이동)
-> 
```

2. 루트파일을 톰캣에 옮기기
```
- mv ROOT.war /home/tomcat/webapps 엔터 => 배포 끝
    *배포할 파일 이름 까먹었다? tomcat까지만 입력하고 tab키 누르면 파일 이름 확인할 수 있음

 배포 잘됐나 확인하기(빨간색 -> 파란색이 압축 풀어진 것임) 
cd/ home/tomcat/webapps

    
tail -f catalina out: 실시간으로 로그를 확인할 수 있음
=> 배포하기 전에 창을 켜놓고 테스트 해보면서 프로그램 작동을 확인할 수 있음 (ctrl+c :실시간 로그창 종료)
```
<사진참고>
![xshell](https://user-images.githubusercontent.com/96815399/174246557-7eb18219-495f-414e-a69e-fd7036e30849.PNG)

- 만약에 배포 완료했는데 켜지지 않을때? 서버를 확인해보자
=> netstat -tnlp : 8080포트번호가 있는지 확인 

---
---
## 람다 / 빈즈톡
### EC2(운영체재, 리눅스..)로 배포가 어렵다면? => 과정을 대신 해주는 상품이 있다.
```
AWS 빈즈톡 : 배포(.war파일 or .jar파일)를 쉽게 해주는 상품. (부분 유료)
AWS 람다 : 배포없이 코드에 집중할 수 있게 도와주는 상품. (유료) 
```

- ### 람다(Lambda)
```
-> 함수 생성
-> 런타임(언어선택)
-> 이름 설정 , 함수생성 클릭
-> 테스트창에서 코드 작성 
-> Deploy 클릭
-> test 클릭
```

- ### 빈즈톡(Elastic Beanstalk) (필요하면 좀 더 구글링해보기)
```
-> create
-> 플랫폼에서 Tomcat 선택
-> war 파일 갖다 넣으면 배포가 됨
-> 생성하고 url 주소를 카카오 developer에서 ip 추가해줘야 지도가 뜸
```
![빈즈톡](https://user-images.githubusercontent.com/96815399/174214283-3f10687e-7c53-4e65-852e-b6737c91882a.png)

#### 만약 빈즈톡 or 람다로 이용할거면 기존에 실행되고 있던 EC2 종료하고 사용하기(서버 동시에 두 대가 실행되는거니까 돈이 두배~! )
---