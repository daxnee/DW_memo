### 220512
### `HashMap 다시 이해하기`
```java
package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




class EmpVO{
	private int empno;
	private String ename;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}

class 햄버거{
	private String 햄버거이름;
	private int 햄버거가격;
	private String 매장이름;
	public String get햄버거이름() {
		return 햄버거이름;
	}
	public void set햄버거이름(String 햄버거이름) {
		this.햄버거이름 = 햄버거이름;
	}
	public int 햄버거가격() {
		return 햄버거가격;
	}
	public String get매장이름() {
		return 매장이름;
	}
	public void set매장이름(String 매장이름) {
		this.매장이름 = 매장이름;
	}
	public void 햄버거가격(int 햄버거가격) {
		this.햄버거가격 = 햄버가격;
	}
}



// List<Map<String, Object>>
List안에 Map을 포함하여 값을 List 안에 Key와 value로 받기 
Map에 데이터를 추가하면 key : value 로 값이 들어간다.

ex) Map<String, Object> map = new Hashmap<String, Object>();
map.put("이름","양다은")

=> map.get("이름") 으로 key에 접근하면 value값을 출력할 수 있다.

public class 긴급점검50 {

	// List와 Map을 알아보자!
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		List<String> list2 = new ArrayList<String>(); //자식이(ArrayList) 부모(List)에 대입도 가능
		list2 = new LinkedList<String>(); // 재활용때문에 부모에 대입해준다
		list2.add("hello");
		//List<>안에는 ArrayList<>,LinkedList<>,Vector<>를 포함하고 있기때문에 변수(list2)를 활용할 수 있다.

		//제네릭 안에 컬렉션도 포함된다는 점이 포인트!

		// Spring에선 쿼리에서 나온 결과를 MyBatis가 list에 넣어주는 것 (list2.add 역할)

		
		List<햄버거> list3 = new ArrayList<햄버거>();
		햄버거 불고기버거 = new 햄버거();
		불고기버거.set햄버거가격(3000);
		불고기버거.set햄버거이름("통새우와퍼");
		불고기버거.set매장이름("버거킹");
		list3.add(불고기버거);
		System.out.println(불고기버거.get매장이름());
		

		// ---- list도 클래스
		// 포인트는 제네릭 안에 컬렉션도 포함됨
		// 컬렉션도 클래스니까!
		List<ArrayList<String>> list4 = new ArrayList<ArrayList<String>>(); // 그래서 이것도 가능하다(쓰진 않음)
		
		Map<String, Object> 불고기 = new HashMap<String, Object>(); //위에 있는 햄버거 생성자를 쓰고 싶다면 자식에 부모를 대입해주면 된다.
		불고기.put("햄버거종류", "불고기버거"); // 그러면 이렇게도 가능함
		불고기.put("햄버거가격", 2000);
		불고기.put("매장이름", "선화점");
		
		//maplist 0번째에 햄버거 이름과 가격을 추가
		List<Map<String, Object>>  mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> 치킨 = new HashMap<String, Object>();
		치킨.put("햄버거이름", "치킨버거");
		mapList.add(불고기);
		치킨.put("햄버거가격", 3000);
		mapList.add(치킨);
		System.out.println(mapList.get(0));
		System.out.println(mapList.get(1));
		System.out.println(mapList.get(1).get("햄버거이름"));
		
		
		
		// vo을 담는 list
		List<EmpVO> empList = new ArrayList<EmpVO>();
		EmpVO emp = new EmpVO();
		emp.setEmpno(7369);
		emp.setEname("양다은");
		empList.add(emp);
				
		
		
		
		
		
		
		// ------------------
		// map을 담는 list
		List<EmpVO> empList = new ArrayList<EmpVO>();
		EmpVO vo =  new EmpVO();
		vo.setEmpno(1);
		vo.setEname("양다은");
		empList.add(vo);
		
		List<Map<String, Object>> empMapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> 사원 = new HashMap <String, Object>();
		사원.put("사원번호", 1); // put 해주고
		사원.put("사원이름", "양다은");
		empMapList.add(사원); // list에 넣기 
		System.out.println(사원);
		// list과 hashmap 공통점 : 추가 (add) 해준다는 점

		// put과 add를 마이바티스가 해준다

		Map<String,Object> SMITH = new HashMap<String,Object>();
		SMITH.put("empNo", 7369);
		SMITH.put("ename", "SMITH");
		empMapList.add(SMITH);
		System.out.println(empMapList.get(1).get("empNo"));
		System.out.println(empMapList.get(1).get("ename"));
		
		Map<String,Object> ALLEN = new HashMap<String,Object>();
		ALLEN.put("empNo", 7499);
		ALLEN.put("ename", "ALLEN");
		empMapList.add(ALLEN);
		System.out.println(empMapList.get(2).get("empNo"));
		System.out.println(empMapList.get(2).get("ename"));
		
		System.out.println("------------");
		
		System.out.println(empMapList.get(0).get("ename"));
		System.out.println(empMapList.get(1).get("ename"));
		System.out.println(empMapList.get(2).get("ename"));
		
	}

}




```


### `list vs map (실무)`  (spring vo vs map => 구글링해서 차이점 알아두기)### `Spring VO(DTO) vs Map`
--- 
```
실무시 list안에 vo(EmpVO)가 없으면 Hashmap을 쓰는거라고 생각하자!
```

### `List에 왜 Map을 담을까?`
---
```
1. 해당 테이블에 조인할 테이블이 너무 많을 때 (다중상속이 안된다는 문제)
2. 데이터의 컬럼수가 너무 많을 때 (private 필드변수를 만들고, getter setter를 만들어줘야 하는 번거로움이 문제)
```


### `List에 map 담아보기`
---
```java
-- mxl --
<select id="selectEmpMapList" resultType="map">
	SELECT
        empno,
        ename,
        job,
        sal,
	    e.deptno
	 FROM 
        emp as e INNER JOIN dept as d
	 ON e.deptno = d.deptno
	</select>


-- Mapper --
public List<Map<String, Object>> selectEmpMapList();


-- Service -- 
public List<Map<String, Object>> getEmpMapList(){
		return empMapper.selectEmpMapList();
	}


-- Controller--
@GetMapping("/emp/map/list")
	public List<Map<String, Object>> callEmpMapList(){
		return empService.getEmpMapList();
	}

-- postman --
http://localhost:8080/emp/map/list 


// 출력값 : List에 EmpVO를 담은 결과와 동일하게 출력된다.
```

### `VO vs Map 장단점 비교`
---
```
- vo의 장점 
어떤 필드변수가 리턴이 되는지 파악이 가능하다(디버깅 가넝한)

- hashMap
어떤 필드변수가 리턴이 되는지 파악이 어렵다는 점
why? MyBatis가 다 해주니까!

=> 쉽게 말해 번거로움의 차이!
```
### `데이터 조작 언어에 따라 List에 담긴게 Map인지 VO인지 결정된다(정답은 없음)`
---
### `SELECT 사용시 : map`
```
이유 : 조인이 많아지면 필드변수가 늘어남(노가다)

장점 : 컬럼이름이 맞게 알아서 매핑
```

### `DELETE, UPDATE, INSERT 사용시: VO`
```
이유 : 필드변수에 맞게 데이터가 Mapping되어야 하는데(쉽게 말해 데이터와 필드변수 간의 매칭이라고 칭하자)
       만약 내가 실수로 잘못된 데이터를 put해버렸다? => 그러면 데이터가 변경되니까 큰일남
장점 : VO클래스에 미리 필드변수를 정의해서 문서화, 유지보수 가능
```


### `로그 : 이벤트에 대한 기록`
```
로그 : 프로그램 개발이나 운영 시 발생하는 문제점(이벤트)을 추적 하거나 운영 상태를 모니터링 하는 정보를 기록하는 것
	*에러도 이벤트임
```

### `포스트맨에 send 하면 남는 log 기록 == logback`
```
설치방법 : resources파일에 logback.xml 파일 복붙 -> 컴파일
그걸 보고 어떤 에러인지 쉽게 알 수 있다
```
### `banner 만들기`
```
src/main/resources  -> new -> other -> General -> File -> Next ->  banner.txt -> 파일 생성 -> 커스텀한 텍스트와 글자 복붙,저장,컴파일

ex)

     _                                    
    | |                                   
  __| | _____  _   _  ____   _____  _____ 
 / _  |(____ |( \ / )|  _ \ | ___ || ___ |
( (_| |/ ___ | ) X ( | | | || ____|| ____|
 \____|\_____|(_/ \_)|_| |_||_____)|_____)
                                          
${application.title} ${application.version}
Powered by Spring Boot ${spring-boot.version}

```

