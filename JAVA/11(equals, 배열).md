	★JAVA = 객체지향언어임

	앞 글자가 대문자면 Class!!!

## 문자형 데이터 비교
	String id = "JAVA";
	String id_2 = "JAVA";
	if(id.equals("JAVA")) { // boolean이 t/f 구분해줌
	System.out.println("아이디가 맞습니다.");
	}else {
	System.out.println("아이디가 다릅니다.");
	}
			
	if(id == id_2) {
	System.out.println("아이디가 맞습니다.");
	}else {
	System.out.println("아이디가 다릅니다.");
	}

	=> 결과
	아이디가 맞습니다.
	아이디가 맞습니다.




## ==  (Call by Reference)
	:비교하고자 하는 두개의 대상의 주소값을 비교함
	ex) 철수와 길동이 같은 빌라에 세들어 사는데 둘을 비교하면 주소(위치)를 비교하기 때문에 호수는 달라도 결과값은 같다고 나옴.

## equals (Call by Value)
	: 비교하고자 하는 두개의 대상의 값 자체를 비교. (그래서 JAVA 문자 비교는 이걸로 해야됨)


```java
		String id = "JAVA";
		String password = "123";
		if(id.equals("JAVA")) {        // boolean이 t/f 구분해줌
		System.out.println("안녕하세요" + id + "님");
		}else {
		System.out.println("아이디가 다릅니다.");
		}
			
		if(password.equals(password)) {
				System.out.println("패스워드가 맞습니다.");
		}else {
				System.out.println("패스워드가 다릅니다.");
		}
			
	=> 결과
	안녕하세요JAVA님
	패스워드가 맞습니다.

```
## 배열

	배열은 서랍이라고 생각하자.
	배열은 0부터 시작함. 순번을 0부터 세야함
```java
		int array[] = {2,4,6,9};
		System.out.println(array[1]); // =>첫번째 배열(인덱스) 호출
		//4는 첫번째에 있음
		System.out.println(array.length);  //배열 길이 호출  
			
```
	=> 결과
	4 (인덱스 호출)
	4 (길이) 데이터의 개수라고 생각하면 됨

```java
	ex)
	int array[] = {2,4,6,9};
	System.out.println(array[1]); // => 배열에 1번째를 호출
	System.out.println(array.length);  // =>  길이를 호출 데이터 개수 : 4개
	for(int i=0; i<array.length; ++i) {  // => 1<4 니까 아래 실행문 실행
	System.out.println("인덱스 값은 :" + array[i]); => i는 현재 0이니까 0번째 배열을 호출함 
	=> '인덱스 값은 2' 출력 -> for문이니까 조건문 충족할 때 까지 계속 반복
	}

	=> 결과
	4
	4
	인덱스 값은 :2
	인덱스 값은 :4
	인덱스 값은 :6
	있는 인덱스 값은 :9

```
## 배열길이 만큼 홀수 판단 문제 
```java
	int array[] = {2,4,6,9};
	for(int i=0; i<array.length; ++i) {  
	if ((array[i]%2) != 0);
	System.out.println(array[i]);
		
	결과 : 9

```java
	int array[] = {2,6,4,9};
	array[0] = 10;
	배열의 0번째를 10으로 수정

```
## 홀수 구하기
```java
		int array[] = {2,4,6,9};
	//	for(int index=0; index<array.length; index++){
	//	if((array[index]%2) != 0) {
	//	System.out.println(index[]);
	//	}
	//	}	

```
## 배열 다시 설명
```java
		int num = 10;
		int 배열[] = {10,3,5};
		System.out.println(배열[2]); => 5
		배열[0] = 5; => {5,3,5}
	//	배열[1] = 배열[1] * 3;  => {5,9,5}
		배열[1] = 배열[0]+배열[2]; => {5,10,5}
		배열[1] = num; => {10,10,5}
		

	4. 아래 배열을 선언하고, 배열 인덱스 중 가장 큰 수를 찾아내시오. *다시 풀어보기
	int array[] = {5,11,2,0,7}; 
	ex) 결과값 : 11

	선생님 답:
	int array[] = {5,11,2,0,7};
	int size = array.length;
	int max = 0;
	for(int i=0; i<size; i++) { 
	if(max < array[i]) {
	max = array[i];
	}
	}
	System.out.println("MAX ==> "+max);


```
##	<버블 정렬> 고난이도 - (구글링해보기)
```java

		int array[] = {14,11}; 
		int size = array.length;
		int temp = 0;
		for(int i=1; i<size; i++) {
			for(int j=0; j<size-1; j++) {
				if(array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

	=> Arrays.sort(array); => 사실 이 한줄로 위 코드 해결 가능


```
## for문 종류

	1. for each문 
		for(int i : array){ => array 값을 i에 대입한다
		System.out.println(i+" ");
		
		
	2. for(int i=0; i<array.length; i++) {
				int x= array[i];
				System.out.println(x);




## 배열은 두가지 종류> -알아만두기
	int 배열[] = {100,100,100}; // 선언식 -> 지금까지 했던거
	int 홍길동[] =  new int[100];
			
		
	int x= 100; // 변수를 100번 만들어라
	int x1[] = {100,100,100}; // 선언식
	int 배열[] =  new int[100];
	int size = 배열.length; //결과는 4
	int y = 배열[0]; // 0번째 인덱스에 있는 데이터 y에 대입!
	int z = 배열[1];       


	****배열 참고!!
	int array[]= {1,20};
	int []array = {1,20};
	위 아래 둘 다 사용 가능하다 (대괄호의 위치) 
	회사가서 어떻게 쓰는지 파악후 사용하기