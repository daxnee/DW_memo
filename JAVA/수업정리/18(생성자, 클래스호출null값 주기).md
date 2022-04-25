## 생성자 복습
    1. 생성자는 함수다(특수 함수)
    2. 리턴이 없음(void도 없음)
    3. 함수이름은 클래스이름과 동일
    4. 기본 생성자(디폴트 생성자) 존재
        (기본 생성자를 사용하고 싶으면 디폴트값을 입력하고 
        그 후에 파라미터 값을 입력해야함)
    5. 생성자를 사용하는 이유?
        => 필드 변수에 값을 대입하기 위해서
    
    ex)
    new Pizza();
    새로운 클래스 파일(Pizza)을 불러옴. 단 파라미터 값이 없는!!

## 필드변수는 클래스안에 있는 모든 메소드에서 사용 가능하다.(★★★★★)
    
## 변수 옆에 this가 붙어있다? 무조건 '전역변수(필드변수)' 
    ex) this.name = "Hello";

    1. 생성자도 함수라 위 같은 코드가 가능
    2. name은 전역변수이기 때문에 생성자에서도 사용 가능

    예시)
    Pizza p = new Pizza();
    
    메소드 호출할때 만약 '파라미터 값이 없다면' 메소드 이름 옆에 () 붙여줌
    ex ) Pizza();
    - 생성자도 메소드와 같은 '함수'니까 호출할때 위와 같은 형식으로 호출해줌

    1. Pizza클래스를 외부에서 호출하려면 강제로 생성자를 사용해야 함.
    2. 강제? -> 필드변수 값을 대입 해줌(목적)
        불러옴과 동시에 값이 설정됨

    **But, 실무에선 사용빈도수 낮음

    3. 그래서 get, set 함수 만들어서 대입.
 
#### step1

```java
    public class Pizza(
        public String 피자종류;
        public int 피자조각;

        public void 피자를먹다(string[] arg)
    )
```

#### step2

```java
    public static void main(String[] args)
    Pizza p = new Pizza(); // 뜻 : "Pizza 클래스를 호출할게"
    }

    //클래스 파일을 호출하면 클래스 파일 안에 있는 필드변수와 메소드들이 내가 지정한 변수 p로 옮겨짐
    // 따라서 그 안에 있는 것들을(필드변수, 메소드) 사용할 수 있게됨
    ex) Pizza p = new Pizza();
        p.피자종류 = "치즈피자";
```


## 피자 클래스를 만들었다고 가정, 메인메소드에 실행할 때 
```java
    public static void test(Pizza p) {
		
	}
	
	public static void main(String[] args) {
		// test(); 왜 오류? 위 test 괄호 안에 파라미터 값이 있는데 괄호에 넣지 않아서 오류.
		Pizza p = new Pizza(); //1.클래스 호출해서 변수에 담는다.
		test(p); 

		//방법2. 클래스를 변수에 담지 않고 바로 넣는다.
		test(new Pizza()); 변수 지정 안하고 바로 넣어줌(그러나 잘 안씀,,, 디버깅 안됨)
		
        //방법3. null 데이터 넘겨주기
		Pizza p = null; //=> 아직 피자 호출한거 아님.null값 주고
		test(p); 
		System.out.println(p);
	
	}
```	
    
## 클래스를 호출할 때 null값을 준다면?
```java
    public static void test(Pizza 피자) {
		피자 = new Pizza();
	}
	
	
	public static void main(String[] args) {

		Pizza p = null; //=> 아직 피자 호출한거 아님.null값만 줌
		test(p); 
		System.out.println(p);
		// 방법3은 파일을 조금 나중에 호출하고 싶을때 사용
		// 방법3은 아직 클래스를 불러오지 않았으니까 사용시 위에서 클래스를 호출해줘야 함

```

## 피자 클래스 만들어보기 
```java

    public class 피자호출 {

	public static Pizza getPizza(Pizza p) {
		p.피자조각 = 8;
		p.피자종류 = "치즈피자";
	
		return p;
	} //메소드 끝
	
	---
	public static void main(String[] args) {
		Pizza p = new Pizza(); // 메소드 파라미터에 클래스타입이 있다면 new를 이용해서 클래스를 불러온 후 파라미터에 넣어야 함!
		p = getPizza(p);
		System.out.println("피자 조각 : " + p.피자조각);
		System.out.println("피자 종류 : " + p.피자종류);
		//두번째 방법 (자세한 설명은 웹시간에)
		Pizza p2 = getPizza(p);
		p.피자조각 = 1;
		p.피자종류 = "불고기피자";
		System.out.println("피자 조각 : " + p2.피자조각);
		System.out.println("피자 종류 : " + p2.피자종류);
	}
	
}
        
    //메소드 파라미터에 new로 불러온 클래스를 넣었기 때문에 클래스 리턴이 가능함!
```

