### 220503
### `lombok, spring boot devtools 등 서치 방법`
```
스프링 이니셜라이즈 사이트에서 
Spring Web 뿐만 아니라 
sts 사이트에서 add dependencies 검색 기능으로 lombok과 같은 기능들을 추가해서 알집으로 다운 받으면 됨 
```

### `MVC 아키텍쳐(Model-View-Controller)` *** 
: 프로그래밍 로직을 `서로 영향 없이 쉽게 고칠 수 있는` 소프트웨어 디자인 패턴

`등장배경` : spring 이용시, 문제를 풀 때 마다 controller에 코드가 길어짐 => `유지보수가 힘들었음`

=> 그래서 `MVC 아키텍쳐`가 등장 (spring이 오랫동안 사용할 수 있는 이유가 됨.)

- `M : Model`
    - `비즈니스 로직(Service)` , `DB 연동 로직(Mapper(Interface))` 두가지로 나뉘어짐. 여기서  `로직 구현`

- `V : View`
    - 최종 사용자에게 결과를 화면(UI)로 보여줌

- `C : Controller`
    - url 요청을 받아서 화면과 Model을 연결시켜주는 역할

### `Spring 3대장`
### 1. `IOC(Inversion of Control)` 
스프링이 제어하는 클래스를 `bean` 이라고 한다.
	- `bean` : 생성부터 소멸까지 관리해 주는 class


@Autowired : Spring이 해당 객체(클래스)를 관리해줌 (new로 인스턴스화 할 필요가 없게 된다) 
- new로 인스턴스화 할 필요가 없게 된다. ***기술면접빈출
@Autowired 쓰면 불러올 클래스에도 @Service가 있어야 한다.


### 2. `DI(Dependency Injection)`
```
- Spring이 객체(클래스)가 필요하다면 외부에서 가져다가 `주입하는 방식`
    (객체(클래스)를 외부에서 가져다가 쓰기 때문에 new 연산자 사라짐)
    * 주입 == 대입
```

### 3. `AOP(Aspect Oriented Programming)`
```
- 여러 메소드(함수)에서 중복되는 코드가 있다면, 따로 모아서 재활용 하는 것 
```
### `컨트롤러 == 요청 /  서비스 == 호출 `
@Controller : URL 요청이 오면 응답을 담당
@Service : 비즈니스 로직, 계산 수행, 외부 API 호출을 수행하는 Java클래스를 표시

`어노테이션(@)`을 붙여서 `spring`한테 알려주는 것임

### `문제푸는 방법`
1. 해당 클래스가 컨트롤러면 `@컨트롤러`, 서비스면 `@서비스`
2. 서비스에 로직을 만들었으니까 `@Autowired` 붙여주기 
    -  @Autowired : 객체 생성과 소멸을 `spring이 관리`해주겠다.


### HttpServletRequest 객체
```java
	@GetMapping("/actor/age")
	public int callUserAgeMax(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-For"); // 클라이언트의 ip를 수집할 수 있다.
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		System.out.println("IP ====> " + ip);
		return service.getUserAgeMax();
	}
```