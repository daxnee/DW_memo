### 220614


### app은 직접 DB 연동 불가능함

(사진첨부)

```
html과 같다.
안드로이드도 백엔드 서버가 필요
바로 db를 갖고오지 못함 
```
----
## `Redirect / Forward`
---
### Redirect
```
1. 고객이 고객센터로 전화(042-1234)를 함
2. 고객이 주문 환불하고 싶다고 요청함
3. 상담원은 고객에게 다음과 같이 이야기함
"고객님 해당 문의사항은 "042-1234가 아니라 042-123으로 문의해주시겠어요?"
```
### Forward
```
1. 고객이 고객센터로 전화(042-1234)를 함
2. 고객이 주문 환불하고 싶다고 요청함
3. 상담원이 해결 방법을 알아낸 후 문의사항을 직접 처리함
```
---

### `클라우드 장점`
```
1. 상황에 맞는 컴퓨터 구입 (컴퓨터 조립, 설치가 필요 없이 버튼만으로 사용 가능) => 돈 절약
2. 시간 절약 (민첩성)
3. 서버 사용자 수가 늘어나면 클라우드가 자동으로 늘어남(시간도 조절이 가능)  *Auto Scale(자동 확장)
```

### EC2
```
EC : Elastic Compute
    * Elastic : 탄력있는 컴퓨터 => 성능을 내맘대로 골라서 사용할 수 있다는 의미
```
---
## `aws 클라우드 서버 구축(EC2)`
---
### 1. ec2에서 인스턴스(객체)서버 생성
```
-> 인스턴스
-> 우측 상단 '인스턴스 시작'
-> <이름 설정> ex) 다은 서버
-> <애플리케이션> '우분투' 선택
-> <인스턴스> 유형 t2.micro 선택
-> <키페어> 이름 설정 후 '키페어 생성' 클릭 (** 잃어버리면 안됨, 집 열쇠같은 개념 : 복구 불가) ex)daeun
-> <네트워크 설정> '기존 보안 그룹' 선택 , default 선택 
-> 스토리지 기본은 8GB (용량이 더 필요하면 유동적으로 조절이 가능함)
-> '인스턴스 시작' 클릭
-> '모든 인스턴스 보기' 클릭
-> 만든 서버 확인 => 인스턴스 상태 : '실행중'  확인하기
-> 퍼블릭 IPv4 확인(퍼블릭 ip이기 때문에 어디서나 접속 가능)
```

### 2. xmanager 알집 프로그램 설치 후 
![Xmanager설치](https://user-images.githubusercontent.com/96815399/173505096-4bf23d4c-3bb8-4a89-8bbc-c5f223ec94de.PNG)

### 1) Xme4.exe 설치(클라우드 컴퓨터와 연결할 수 있는 프로그램을 설치하는 것)
```
-> username,  company name 내맘대로 설정
-> keygen.exe 클릭 
-> Xmanagerd Enterprise 선택 
-> Serial 번호 복사 
-> product key에 붙여넣기
-> 변경사항 없이 Next, install 
```
### 2) 설치된 Xmanager Enterprise4 프로그램 선택 
```
-> Xshell 클릭
-> 새로만들기 
-> 이름 : 다은AWS서버
-> 호스트 : AWS 서버 생성시 인스턴스 정보에 기재된 퍼블릭 IPv4 주소 입력
-> <터미널> 인코딩 : 유니코드(utf-8)

-----------------------
(optional)
-> 모양
-> 글꼴 크기 : 12
-> 글꼴 이름 : Consolas
------------------------

-> 사용자인증
-> 방법 : public key 
-> 사용자 키 : `찾아보기`로 생성해놓은 키페어(pem키) 설정 ex)daeun.pem
-> 사용자 이름 : ubuntu
-> 확인 , 연결
```
![aws호스트번호](https://user-images.githubusercontent.com/96815399/173717469-ba5fa7b8-d4a4-4b86-8d3e-a91e9b5b8fc5.PNG)



### 퍼블릭 IP / 탄력적 IP 
```
둘다 퍼블릭 IP임

탄력적 IP(DHCP) 가 없으면 컴퓨터 온오프 할때 마다 ip주소가 바뀜
 => ip 순환이 되어야 함 
```

---
## `클라우드에 DB 설치하기`
---
#### 1. java jkd 설치(명령어로 프로그램 설치)
---
```
ubuntu는 apt라는 명령어를 이용해서 DB프로그램을 다운받는다
1. sudo apt update (업데이트)
2. sudo apt install openjdk-11-jdk => y 입력 (Java 프로그램 설치)
3. javac -version (자바 버전 확인)
```

#### 2. Ubuntu ROOT 계정 만들기
---
```
1. sudo passwd root (root 비번 초기 설정)
2. su - (root 로그인)
3. password : [비번 입력]
4. root 비번 입력 후 엔터(1793)
5.  cd /home => 바탕화면의 home에 접속한것임
```

#### 3. 톰캣 설치 
---
```
wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.tar.gz 
tar xf ap 탭키 누르면 자동완성
mv apache ~ 
cd bin
cd tomcat/
sh startup.sh
포트 확인 방법 : netstat tnlp 입력 후 8080이 있는지 확인. listen 상태면 명령어를 들을 준비가 되어 있다는 의미

<보안 그룹> 
인바운드 규칙 , 아웃바운드 규칙 추가해주기  
-> 편집, 규칙 추가
-> 포트 범위 : 8080 ,0.0.0.0/0, 설명 : tomcat 
-> 주소창에 url 입력 
http://54.180.116.1:8080/ 
    * 8080 :서비스 식별 번호

```