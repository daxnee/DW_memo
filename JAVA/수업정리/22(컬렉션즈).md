### 220407

## 제네릭 & 컬렉션즈
---
```

- 컬렉션즈를 왜 사용할까? 
=> 실무에선 배열을 잘 사용하지 않는다.

- 연관된 데이터(같은 데이터타입)를 관리하기 위해서 배열을 사용.
int arr[] = [1,3,4,10,11]; // 배열 선언방법 1
int arr[] = new int[20]; // 배열 선언방법 2 : 내용 안 넣고 배열의 크기만 정해줌 

배열의 단점: 한 번 정해진 배열의 크기를 변경할 수 없다는 점

=> 컬렉션즈를 사용하면 이러한 불편함이 줄어든다.
자료구조 공부 없이도 쉽게 코딩할 수 있게 됨. 
```

### 프로그래밍 언어의 컬렉션즈 
---

- C언어 -> 컬렉션즈 x
- ava, Python, JavaScript(TypeScript) -> 컬렉션즈 o

* 프로그래밍을 하려면 자료구조를 알아야 함.
STACK, HEAP, 큐 ,,,


## 컬렉션즈 (컬렉션즈 프레임워크)
---
- 컬렉션즈 : 프레임워크. 다른 말로는 컨테이너라고 부름. 즉 '값을 담는 그릇'이라는 의미
	- 그런데, 그 값의 성격에 따라 컨테이너의 성격이 조금씩 달라짐.
자바에선 여러 상황에서 사용할 수 있는 다양한 컨테이너를 제공하는데 이것을 컬렉션즈 프레임워크라고 부른다.

```
Collection(최상위카테고리)             Map (최상위카테고리)

- Set
- List
- Queue

- Collection과 Map이라는 최상위 카테고리가 있고, 그 아래에 다양한 컬렉션들이 존재한다.
```

- 컬렉션 종류
ArrayList, HashMap, HashSet이 대표적
	- 이 중 ArrayList를 정말 많이 사용함. 
ArrayList를 : 무한정으로 데이터를 추가할 수 있고 , 수정과 삭제가 쉬움


## 컬렉션즈 문법
---
```java
	import java.util.ArrayList; //ctrl + shift + o : import 생성

	ArrayList<String> list = new ArrayList<String>();  // () : 생성자
	// ctrl + shift + o => import 
	// <> : 제네릭
 
```
 <> : 제네릭
- 제네릭 <> 안에 지정된 데이터 타입에 의해서 ArrayList가 결정된다.
	- <> 안에는 클래스만 올 수 있음.
	
- int -> Integer
String (String은 클래스라서 대문자로 시작)
double -> Double

- 결론 : <> 제네릭이고, 괄호 안에는 클래스만 올 수 있다!


---
## 생성자 함수의 파라미터에 값을 넣어주면 디폴트 생성자가 없어짐  
---
- 디폴트 생성자 그대로 두려면
```java
public Student {

}
// 이렇게 해줘야 함
```



## 문제 예시
### ArrayList 
```java
// for(EmpVO vo : list) { } // foreach문


import java.util.ArrayList;

public class ArrayList_Study {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();  // () : 생성자
		// ctrl + shift + o => import 
		// <> : 제네릭
		
		list.add("시금치 파스타"); // add : 배열에 데이터를 삽입.
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		
//		int len = list.size();
//		System.out.println("list 길이는: " + len);
		int count = 0;
		String value = list.get(0);
		System.out.println(value);
		String value2 = list.get(1);
		System.out.println(value2);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == "곱창 파스타") {
				++count;
			}
		}
		System.out.println(count);
		
		//int를 담는 ArrayList
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(40);
		list2.add(60);
		list2.add(80);
		list2.add(30);
		
		int sum = 0;
		for(int i=0; i<list2.size(); i++) {
			if(list2.get(i) != 40) {
			sum += list2.get(i); 
		}
		}
		System.out.println(sum);
	}

}
```
### ArrayList 예시 

```java 
import java.util.ArrayList;

class Student{
	String name;
	int age;
	String addr; // 주소
	
	public Student(String name, int age, String addr) {
		// this == Student
		this.name = name;
		this.age= age;
		this.addr = addr;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

public class ArrayList_Study2 {

	public static void main(String[] args) {
		Student s1 = new Student("양다은", 27, "대전"); // 배열에 클래스를 넣어줌. 배열 0번째에 Student 내용이 전부 들어가 있음.
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s1); // Student클래스 추가!
		String name = list.get(0).name; // Student 클래스의 name을 불러옴!
		System.out.println(name);
		
		int age = list.get(0).age;
		System.out.println(age);
		
		String addr = list.get(0).addr;
		System.out.println(addr);
		
		int ageMethod = list.get(0).getAge();// Student클래스 안에 있는 메소드(함수) 불러옴.
		System.out.println(ageMethod); 
		
		list.get(0).setAge(33); // 0번째 age를 33으로 set(변경)
		age= list.get(0).getAge(); 
		System.out.println(age);
		
		list.get(0).setName("홍길동");
		name = list.get(0).getName();
		System.out.println(name);
		
	}

}
```


### java 문자 비교

- String = 동적타입 클래스 
	- heap 메모리 공간에 저장, 저장될 때 고유번호를 받음
그 번호가 메모리 주소!
String 일때는 문자를 비교하는게 아니라 주소를 비교하는 것임
그래서 'equals'를 사용해야함




###  메소드 원리 파악하기
```java
public static String getValue(String name) {
		System.out.println("너의 이름은?" +name);
		return name;
	}
	
	public static void main(String[] args) {
		String name = "아이유";
		String result = getValue(name);
	}
```


### 원리를 바탕으로 메소드로 호출해보기 (실무)

```java
public class EmpMain {
	// 메소드로 풀어보기
	public static ArrayList<EmpVO> getEmpList(ArrayList<EmpVO> list){ // EmpVO를 담고 있는 ArrayList를 파라미터로 받고 있다.
		for(int i=0; i<list.size(); i++) {
			System.out.println("메소드로 호출 : "+ list.get(i).empno);
			System.out.println("메소드로 호출 : " + list.get(i).ename);
		}
		return list;
	}
	
public static void main(String[] args) {
		getEmpList(list);
}
```


