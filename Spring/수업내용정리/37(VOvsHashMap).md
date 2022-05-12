### 220512
### `HashMap 다시 이해하기`




### `list vs map (실무)`  (spring vo vs map => 구글링해서 차이점 알아두기)

### `Spring VO(DTO) vs Map`
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
### `데이터 조작 언어에 따라 List에 담는 Map과 VO가 결정된다(정답은 없음)`
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