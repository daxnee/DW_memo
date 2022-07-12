## 220526
### 조회수 count 기능 만들기
```sql
-- 컬럼을 추가, 수정, 삭제하고 싶을때 사용
alter table board add column cnt integer(4) default 0;
=> 조회수 count를 위해 cnt 컬럼을 생성
```

1. 게시물을 눌렀을 때 조회수 1count
조회물 클릭 -> 웹서버에 요청(조회 수 카운트 요청)

2. 서버에서 받아야 할 데이터 
=> 게시판 번호 (Board_id), 현재 조회수를 파라미터로 받아야 한다.


### 키보드 동작
```
1. 키보드를 누를 때 => keydown
2. 누른 키를 뗄 때 => keyup
3. 키보드를 계속 누르고 있을 때 => keypress

필요한 키업을 사용할 때 검색 방법
: jquery spacebar key로 검색

```


### 

``` java
package 페이징;

public class Pagehandler {

	public static void main(String[] args) {
		//여신강림 페이지
		//야옹이 작가는 210화 까지 연재함 
		// step1. 페이지 수 알아내기(총 카운트와 한 페이지에 몇 개를 보여줄지가 중요함)
		
		int total = 210; // sql에서 쿼리문으로  count 구하면 됨! // select count(*) form board
		int pageSize = 10; // 한 페이지에 게시물을 몇 개 보여줄지 // limit 오른쪽 번호인 10
		int pages = 0;
		pages = total / pageSize;
		if(total % pageSize > 0) { // 페이지가 넘어가면 1page 증가
			pages++;
		}
		System.out.println("총 페이지 수 ===> " + pages);
		
		//step2. 블록 알아내기
		int navigatePages = 10; // 한 블록에 몇 페이지를 보여줄지 범위 설정
		int blocks=0;
		blocks = pages / navigatePages;
		if(pages % navigatePages > 0) {
			blocks++;
		}
		System.out.println("총 블럭 수 ===> " + blocks);
		
		
		//step3. 현재 블록 알아내기
		int pageNum = 11; // 페이지 번호
		int nowBlock = 0;
		nowBlock =  pageNum / navigatePages;
		if(pageNum % navigatePages >0 ) {
			nowBlock++;
		}
		System.out.println("현재 블럭은 ===> "+ nowBlock);
		
	
		//step4. 마지막 블록 알아내기 (== step2)
		int lastBlock = 0;
		//hint : total, navigatePages, pageSize 
		
		lastBlock = total /(navigatePages * pageSize);
		if(total  % (navigatePages * pageSize) > 0) {
			lastBlock++;
		}
			
		System.out.println("마지막 블록은 ===> " + lastBlock);
		
		//step5. 현재 내가 위치한 블록의 처음 페이지와 마지막페이지 구하기
		/* ex) 1블록에 있으면 1~10 
		   	   2블록에 있으면 11~20
		   	   3블록에 있으면 21~22  
		 */
		int startPage =0;
		int endPage = 0;
		
		startPage = (nowBlock * navigatePages) - (navigatePages -1);
		//방법1
		endPage = startPage * navigatePages;
		//방법2
		
		// hint 현재 페이지를 구하자
		if(nowBlock == lastBlock) {
			endPage = pages;
		}
		
		System.out.println("현재 페이지는 ===> " + startPage);
		System.out.println("마지막 페이지는 ===> " + endPage);
		
		// step6. 이전버튼, 다음버튼 유무 판단
		boolean hasPreviousPage = true; // 다음버튼
		boolean hasNextPage = true; //이전버튼

		if(lastBlock ==1 ) {
			hasPreviousPage = false;
			hasNextPage = false;
		}
		if(lastBlock > 1 && lastBlock == nowBlock) {
			hasPreviousPage = true;
			hasNextPage = false;
		}
		if(lastBlock > 1 && lastBlock <= nowBlock) {
			hasPreviousPage = false;
			hasNextPage = true;
		}
		System.out.println("이전 버튼이 있나요? ===> " + hasPreviousPage);
		System.out.println("다음 버튼이 있나요? ===> " + hasNextPage);
	}
}
```

### 페이지 설정시 쿼리문이 2개 필요하다
```sql
-- 1.  전체 count  
select
*
from emp

-- 2. limit으로 보여질 페이지 사이즈 구하기 
select
*
from emp
limit 0, 5;

```
### limit 쿼리에 불러올 파라미터값 설정하기

```sql
-- limit 왼쪽 시작 번호(startPage), 오른쪽 행 수(pageSize)
select
*
from emp
limit 0, 5;

-- myBatis
select
*
from emp
limit #{startPage}, #{pageSize};

설정하고, 서비스 로직에서 startPage-1 로직 구현하면 된다.

```