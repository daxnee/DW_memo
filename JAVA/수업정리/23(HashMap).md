### 220411

### 220412

### HashMap
Key와 Value로 이루어진 자료구조 = json과 같음
Key 중복x

### HashMap 예시
```java

package 컬렉션즈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class OneSoju extends Object{
	// extends Object : 모든 클래스는 Object를 상속 받는다.
	// 부모는 자식을 포함할 수 있다.
	// 모든 클래스의 부모는 Object다.
	// 그래서 OneSoju를 아래 HashMap의 Value에 넣을 수 있는 것이다.
}

public class Hash_Study {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); // arrayList
	
		OneSoju onesoju = new OneSoju();
		
		
//		HashMap<String,String> map = new HashMap<String, String>();
		HashMap<String,Object> map = new HashMap<String, Object>();
		
//		HashMap Value에 Object를 하는 이유? : 
//		Value에 어떤 값(데이터 타입)이 올지 예상 불가능. 그래서 Object로 데이터 타입을 모두 받는다.
//		Object 로 바꿔주면 문자, 숫자 모두 포함시키겠다는 의미 (부모인 Object는 모두 사용할 수 있게됨)
		Map<String,Object> map2 = new HashMap<String, Object>();
		//부모는 자식을 포함시킬 수 있다.
		map.put("1", "참이슬"); // HashMap에 데이터 넣기! map.put(key , value)
		map.put("2", "처음처럼");
		map.put("a", "한라산");
		map.put("b", 13); // Object로 설정하면 문자, 숫자 모두 출력가능
		System.out.println(map.get("1")); // key 이름으로 value 접근
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
	}

}
```