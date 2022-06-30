### 220630 

## 팀플젝 DB
### `엑셀파일(CSV) => DB(디비버) 옮기기`
```
-> 프로젝트 우클
-> 데이터 가져오기
-> CSV에서 가져오기, 다음
-> <input files> Source 클릭 
-> 파일 선택
```

  ![CVS파일옮기기](https://user-images.githubusercontent.com/96815399/176574651-4be00bde-c223-4e4d-ab02-9670fb1be269.PNG)

  *인코딩 : euc-kr 해야 한글 데이터 안 깨짐

```
-> 다음, 진행 
-> target :  디비버의 테이블 이름


```

### CSV 디비버 insert시 주의점 
- 테이블 create시 정해놓은 데이터 길이보다 더 길다면 
insert가 안된다. 그럴땐 modify 사용하면 된다.
```sql
ALTER TABLE 테이블명 MODIFY 수정
```
또는 디비버의 데이터 가져오기 탭에서 column 선택해서 수정할 수 있음