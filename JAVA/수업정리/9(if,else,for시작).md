## JAVA
	1. 프로그램을 만들기 위해서 코딩을 함
	2. 프로그램 데이터가 있으니까 (헬스장 회원관리, 쇼핑몰 회원관리 등)
	   변수라는 개념을 이용해서 데이터를 대입해야 함
	3. int (데이터 타입) x (변수 이름)
	    = (대입) 정수형 데이터 ;

	자바도 메모리를 정리해줘야 한다. 안 그러면 꽉참 ex) 테트리스
	=> 그래서 변수들을 '재활용'해주는 것임 


## 대입연산자
	1.더하기
	레벨 += 레벨;
	=>  레벨 = 레벨 + 레벨; (헷갈리면 대입연산자 안쓰고 그대로 작성도 가능)

	2.곱하기
	레벨 += 레벨;
	=> 레벨 *= 레벨 * 레벨;    (얘는 곱하기)



    ex)
	String 캐릭터 = "아무무";
	int 레벨 = 1;
	//레벨 = 레벨 + 라벨;	
	레벨 += 레벨;
	
	System.out.println("내가 선택한 챔프는 " + 레벨);
	++레벨; //3렙 => 증감연산자라고 함 =>1씩 더한다
	++레벨; //4렙
	
	System.out.println("내가 선택한 챔프는 " + 레벨);


	if, else문 ex)
	int x=0; int y=0;
	if (x == y) {  // => x와 y가 참이라면/같다면(==)
	System.out.println("x랑 y는 같아요!"); //=> if의 조건문을 출력
	} else { if문이 거짓이라면 else의 조건문을 출력됨
 	System.out.println("x랑 y는 달라요!");
	}

	결과:
	x랑 y는 같아요! 

	* but, else 사용은 지양함(읽기 복잡해짐)



## 중괄호 위치 참고

	public static void main(String[] args) {
	int myscore = 90;
	{
	System.out.println("A학점입니다.");
	}
	if (myscore < 90 && myscore >= 80) {
	System.out.println("B학점입니다.");
	}
	if (myscore <= 75 && myscore >= 70) {
	System.out.println("C학점입니다.");
	}
	}


	public static void main(String[] args) {
	int x = 10;
	int y = 10;
	int num = 0;
	if (x == y) {
	num = x * y; // num 100
	if (x != y) { // => if조건 안 맞음(넘어감)
	num = 0;
	} else {
	num += num;
	}
	num = num + 100; // 300
	System.out.println(num);
	}
	}


## 스캐너 입력 방법
	클래스 만들고 - 입력창에 Scanner scan = new Scanner(system.in); 
    입력 후 - ctrl + shift + o




## 다시 풀어보기	
	//1. 1~100사이 숫자를 입력
	//2. 100이 넘어가면 100이 넘었습니다 출력
	//3. 1~100안에 있는 숫자면 / 2의 배수인지 3의배수인지 출력
	//4. if/else를 사용할 것, 사칙연산을 사용할 것, 변수는 value만
	//Scanner scan = new Scanner(System.in);
	//System.out.println("숫자를 입력하세요 ==>")
	Scanner scan = new Scanner(System.in);
	System.out.println("숫자를 입력하세요");
		
	int value = scan.nextInt();
	if (value >= 100) {			
	System.out.println("100이 넘었습니다");
	}if (value % 3 == 0) {
	System.out.println("3의 배수입니다");
	}

		
	## else if로 학점 문제 풀어보기
	int num = 88;
		
	if(num > 90){
	System.out.println("A학점입니다.");
	}else if(num >= 90 && num > 80) {
	System.out.println("B학점입니다.");
	}else if(num >= 80 && num >= 70) { 
	System.out.println("C학점입니다.");
	}else {
	System.out.println("F학점입니다.");
	}
	

   	## Scanner scan = new Scanner(System.in);
		
	System.out.println("이름을 입력하세요 ==>");
	String name = scan.next(); //문자를 입력할 때
	System.out.println("좋아하는 숫자를 입력하세요 ==>");
	int num = scan.nextInt(); //숫자를 입력할 
		
	System.out.println("안녕하세요 제이름은 "+name+"입니다.");
	System.out.println("제가 좋아하는 숫자는" +num+" 입니다.");
	


## 반복문 사용
    코드의 중복을 제거하고자 반복문 등장!

  	i를 1씩 증가시켜 10 미만까지 반복하겠다.
  	=> for (int i=0; i < 10; i++ ) 



## for문 사용해보기
	
	문제1.
```java
	for(int i=0; i<=10; i++ ) {
	if(i % 2 == 0){
	System.out.println("짝수는 ==> " + i );
	}	
	}

	결과:
	짝수는 ==> 0
	짝수는 ==> 2
	짝수는 ==> 4
	짝수는 ==> 6
	짝수는 ==> 8
	짝수는 ==> 10



	문제2.
```java
	for (int i = 1; i <= 10; i++) 
	if (i % 2 == 0) {
	System.out.println("짝수는 => " + i);
	}else if (i % 2 == 1) {
	System.out.println("홀수는 => " + i);
	}

	결과 : 
    홀수는 => 1
	짝수는 => 2
	홀수는 => 3
	짝수는 => 4
	홀수는 => 5
	짝수는 => 6
	홀수는 => 7
	짝수는 => 8
	홀수는 => 9
	짝수는 => 10


## 자주 사용하는 이클립스 단축키 모음 

	0. ctrl + space : 자동 완성
	1. ctrl + s : 해당 파일 저장
	2. ctrl + w : 해당 파일 닫기
	3. ctrl + d : 한 줄 지우기
	4. 커서로 블록 설정 후 alt + 방향키 위, 아래 : 여러 줄 코드 이동
	5. ctrl + shift + f : 소스코드 자동 정리
	6. ctrl + shift + l : 단축키 보기 Hint
	7. ctrl + h : find 및 replace
	8. ctrl + shift + y : 대문자 -> 소문자 변환

	9. ctrl + shift + x : 소문자 -> 대문자 변환


