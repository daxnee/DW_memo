## IT용어
    프로그래밍 종류 : JAVA, C, C++, Python, Ruby, ★JavaScript

    사람 :  코드를 작성 -> 컴퓨터는 010101 밖에 모름
    우리가 작성한 코드를 컴퓨터가 알아듣게 번역


## 컴파일과 인터프리터의 차이점 ★신입기술면접에 나옴★
    컴파일 (C, C++, JAVA...)
    1-1. 전체 소스코드를 싹다 보고 실행
    1-2. 인터프리터와 비교했을 때 실행속도가 빠름
    1-3. 코드를 수정하고 실행하려면 처음부터 다시 

    인터프리터 (Python, JavaScript...)
    2-1. 한줄씩 실행
    2-2. 컴파일과 비교했을 때 실행속도 느림
    2-3. 코드를 수정하면 즉시 실행됨

## 오픈소스란? 
    소스코드를 공개해 누구나 특별한 제한 없이 사용하는 소프트웨어
    ex) MYSQL, JAVA, http, 이클립스



## IDE? 통합개발 환경
    이클립스, 인텔리 제이(유료), 파이참, egov...
    사수가 전에 IDE 뭐썼냐고 물으면 사용했던 IDE 종류로 대답
    ex ) 이클립스로 자바 개발했습니다~~

-------------------------------------------------------



## java로 개발할 프로그램 설치
    이클립스 검색 -> 왼쪽 Get Eclipse IDE 2021‑12 설치 
    eclipse ide for enterprise java and web developers어쩌고 클릭 (두번째 메뉴)

    install -> 이클립스 실행 (***launch누르지말고!!) -> 내 pc -> 새폴더(workspaces)만들고 -> 주소 복사 -> 프로그램 켜서 파일 복붙 -> 체크박스 설정 (캡처 사진 참고)


    install -> 이클립스 실행 (***launch누르지말고!!) -> 내 pc -> 
    새폴더(workspaces)만들고 -> 주소 복사 -> 프로그램 켜서 파일 복붙 
    -> 체크박스 설정 (캡처 사진 참고)


    DB 
    데이터베이스 -> 테이블 -> 데이터
    java
    프로젝트 -> 패키지 -> 클래스(코드 파일)

## JAVA의 암묵적인 룰
    => 프로젝트명 : 소문자 or 대문자 (Case by case)
   · 패키지 : 소문자
   · 클래스 : 첫글자는 대문자를 쓰자 (클래스 이름 : Emp)
   · 프로젝트, 패키지, 클래스 명은 명사로 설정 해야한다.

    
## JAVA파일 만들기	

    파일 - new - 프로젝트 - 자바프로젝트 - dw 이름 설정 - finish - don't creat - open 어쩌고
    - 박스모양 :  패키지 - 오른쪽 마우스  - new - 패키지 - study으로  name 설정 - 
    finish - study에서 오른쪽 마우스 - new - class - (첫글자는 대문자로) FirstJava 로 설정 - Public static void main 체크 박스 클릭

    파일 - new - 프로젝트 - 자바프로젝트 - dw 이름 설정 
    1.finish - don't creat - open 어쩌고
    2. 박스모양 :  패키지 - 오른쪽 마우스  - new - 패키지 - study으로  name 설정 
    3. finish - study에서 오른쪽 마우스 - new - class - (첫글자는 대문자로) 
    4. FirstJava 로 설정 - Public static void main 체크 박스 클릭


## 자바 폰트 설정 : 윈도우 - preference - general - appearance
    colors and fonts - basic - 맨 아래 텍스트 폰트 - edit

        
## 데이터타입
    :해당 데이터의 타입을 지정해줌
    데이터가 문자형인지, 실수형, 논리형, 정수형인지 정해주는 것

    ★ =의 뜻 ★
    대입한다. 대입연산자

    Java는 데이터 타입이 '9개'다
    1byte = 8bit 이것만 알아두기

    4가지 데이터 타입 기억!
    정수는 int를 많이 씀
    실수 앞에는 double
    논리 얖에는 boolean
    long도 씀

    *메모리가 클수록 한번에 여러개의 프로그램을 실행시킬 수 있음

    변수를 사용하는 이유  : 재활용하기 위해

## JAVA 용어
    int : 데이터타입
    x : 변수
    = : 대입하다
    식 : 데이터

    많은 연산자 중에 비트연산자 << >> >>> 빼고 다 알아야한다.

    첫글자가 대문자라면 class! 
    ex) String name : "양다은"

## 변수 이름 설정하기
    1. 명사로 써야함
    2. 길이 제한 없음
    3. 복합명사일때는 
    ex) 사용자 정보 => userInfo(카멜 표기법) or user_info
    4. 소문자 사용
    단, 대문자 사용할 때 
    '상수값'을 표기할 떄는 대문자 사용
     ex) 파이 double PI = 3.14 / int LEVEL = 6
     즉, 대문자라면 값이 정해져 있다고 생각하면 됨. 수정하면 절대 안됨
    5.변수이름은 중복 불가능


## JAVA 문법 순서
    int x = 10;
    int y = 5;
    int result = x + y ;
    └2번          └1번 으로 실행 (대입연산자를 기준으로 읽는 순서가 ㄷ름)
    => 변수를 이용해서 결과 값을 받음

    y = x+y;  => 이렇게 되면 5+10 => y는 15가 되는 것임
    =>이미 선언된 변수를 재활용

    <나누기>
    int z = 10 / 5; -> 나누기 몫값 구하기 
    int temp = 10 %  -> 나누기 나머지 구하기 

    <곱하기>
    int a = 10 * 2;



## 변수 재활용 예시
    int 콩나물국밥 = 5000;
    int 돼지국밥 = 7000;
    돼지국밥은 얼마일까요? 
    =>7,000
    돼지국밥 += 돼지국밥;
    // 14000
    돼지국밥 = 돼지국밥 *3
    -> 돼지국밥은 21000
    돼지국밥 = 돼지국밥 + (콩나물국밥 *3)
    -> 돼지국밥은 21000원



## 삼항 연산자(실무에서 많이 쓰임)
    public static void main(String[] args) {
    int 변수 = 0;
    int 손흥민 = (10 > 4) ? 10 : 30;
    System.out.println(손흥민);
    }
    }
    ? 기준으로 왼쪽 조건이 맞으면 10 거짓이면 30이 나옴
    변수 = (회원이 로그인했는데 연산자) ? home : login
    로그인했으면 home 로그인 안됐으면 login




    <문제1>	
    public static void main(String[] args) {
    int 국어 = 100;
    int 수학 = 50;
    int 영어 = 88;
    int 과학 = 38;
    final int 과목수 = 4; // final = 상수(변하지 않는 값)
    int sum = 0; // 총합
    double avg = 0; // 평균
    //-------------1.여기까지 변수를 줬으면 

    sum = 국어 + 수학 + 영어 + 과학;
    avg = sum / 과목수;
    }
    //----------- 2. 변수를 이용해서 계산을 해주고 

    System.out.println("총합 : " + sum + "입니다");
    System.out.println("평균 : " + avg + "입니다");
    //------------3. 실행하기 위해서 명령어를 (Sysout~) 적어주면 결과값이 출력된다.


    
## 실무시 이클립스 기본 설정 (필수 설정)
    1. 본인 만의 workspaces 생성
    2. 이클립스 인코딩 설정
        window -> preferences -> general -> workspace -> texxt file encoding (UTF-8 수정)
    3. 북마크 설정
        window -> show view -> other -> general -> Bookmarks 더블 클릭
    4. 폰트 크기(옵션)

