### 220425

### Static (스태틱)
static 목적 : 공유 (share)
** static으로 선언된 메소드와 변수는 인스턴스화(new)를 하지 않아도 호출이 가능하다.

###
```java
public class MainStatic {
public static void main(String[] args) {
StaticStudy s = new StaticStudy();
		s.count++;
		System.out.println(s.count); // int는 초기값이 0
		
		StaticStudy s2 = new StaticStudy();
		System.out.println(s.count);
		// 결과는 0이 아닌 그대로 1이 나옴
		// 언제 사용하는? 내가 변경해도 값이 안바뀌는 애들을 스태틱으로 선언한다. ex) 진단코드, 질병코드
        // public static final String HEADACHE  = "AA123"
        ** final : 상수
        // 스태틱이 있는 클래스를 따로 만들어줌 
        // 값이 변하면 사용하고 있는 다른 클래스에서도 값이 바뀌게 됨(공유니까) 

        // -------  그러나 위처럼 인스턴스화 하지 않아도 사용이 가능!
        System.out.println(StaticStudy.HEADACHE);
		//스태틱으로 선언된 변수, 메소드는 new (인스턴스화를 안하고) 사용할 수 있다.

}
}
```

### 상수인 값 변수 설정시
* 변하지 않는 값들은 대문자로 설정하기 

인스턴스화를 하는 이유는 메소드를 정의하려는 목적이지만
스태틱은 변하지 않는 값들을 공유하는 것이 목적임


### 변수 종류는 크게 두가지로 나눈다
 static / non-static


### 싱글톤 패턴(코딩 디자인 패턴 중 한 종류) * 구글링
- 코딩에도 디자인 패턴이 있다.
- 싱글톤은 스태틱 개념을 응용함.


### 

주로 공통된 객체(클래스)를 여러개 생성해서 사용하는 상황에서 많이 사용.

싱글톤은 여러차례 호출되더라도 실제로 생성되는 객체(클래스)는 하나다.



### 스태틱 왜 쓰는가? 
여러 클래스에서 사용하면 heap 영역에 new로 생성한 코드들이 넘쳐난다
용량 과부하 그래서 스태틱으로 변수와 메소드를 지정해줘서 호출해서 사용한다.


```java

public class Chef {
	private static Chef chef = null; // static으로 선언된 클래스 변수
	
	private static Chef getInstance() { // 스태틱으로 선언된 메소드
    //메소드 이름이 getInstance()라면 단번에 알아봐야함 => 아하,  해당 메소드에서 객체를 생성 해주는구나 라고 생각!
	// class 초기값이 null이니까 리턴타입이 클래스가 가능한것임
		if(chef == null) {
			chef = new Chef();
		}
		return chef;
	}
}


// Chef() 클래스를 만드는 
---

public static void main(String[] args) {

public class MainStatic {
 Chef c =  Chef.getInstance(); // 인스턴스화가 된 메소드를 스태틱으로 공유함

}
}
```

### sattic 을 저장하는 영역이 따로 있다.
영역이 꽉 차기 때문에 적절하게 사용해야 한다.


### static을 사용하는 경우 

1. *** 코드를 정의할 때
    단, 해당 클래스에는 변수만 존재!

2. 객체(클래스)를 여러개 생성해서 사용하는 상황일 때
    ex) 데이터베이스 연동할 때

=> 싱글톤 패턴이 무엇인지만 알고 있으면 된다. 사람들이 이미 만들어 놨기 때문에 만들지 않아도 된다.