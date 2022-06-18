### 220616

### DB 데이터 => 엑셀파일 다운 받기(with 이클립스)
---
1. 엑셀 dependency 추가 (refresh)
```java
//excel
implementation group: 'org.apache.poi', name: 'poi-ooxml', version: '5.2.2'
```
    * gradle에 추가한 항목은 어디에 다운될까?
    => :c/사용자/23/gradle 에서 확인이 가능
---
2. Excel 전용 controller, service 생성    

```java
package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet; // ss로 임포트
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.BoardMapper;
//import org.apache.poi.ss.usermodel.*; 위에 다 지우고 *로 표시도 가능

@Service
public class ExcelService {

	@Autowired
	private BoardMapper boardmapper;
	
	
	public Workbook makeExcelForm() throws Exception{ //throws Exception : 메소드에서 에러가 발생하면 캐치해줘
		
		Workbook workbook = new HSSFWorkbook(); //excel 생성
		Sheet sheet = workbook.createSheet("게시판 자료"); 
		Row row = null; //엑셀 행
		Cell cell = null; // 엑셀 열
		int rowNumber = 0; // 행 번호
		
		CellStyle headStyle = makeExcelHeadStyle(workbook);
		CellStyle bodyStyle = makeExcelBodyStyle(workbook);

		
		row = sheet.createRow(rowNumber++);//첫번째 행
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("게시판 번호");

		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("작성자");

		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("제목");

		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("수정 날짜");

		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("작성 날짜");

		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("조회 수");

		
		// mapper 데이터 호출 
		List<Map<String, Object>> list = boardmapper.selectAllBoardList();
		
		for(Map<String, Object> data : list) { // 핵심
			row = sheet.createRow(rowNumber++);//행을 계속 추가 해준다. for문 조건식이 만족할 때 까지.
			cell = row.createCell(0);//게시판 번호
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("boardId").toString());

			cell = row.createCell(1);//작성자 
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("studentsName").toString());

			cell = row.createCell(2);//제목
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("title").toString());

			cell = row.createCell(3);//수정 날짜
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("updateAt").toString());

			cell = row.createCell(4);//작성 날짜
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("createAt").toString());

			cell = row.createCell(5);//조회 수
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("cnt").toString());
		}
		
		return workbook;
	}
	
	//엑셀 Head style 수정(css)
	public CellStyle makeExcelHeadStyle(Workbook workbook) { // Head : 목록 
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		//가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		//배경색 생성
		cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//가운데 정렬
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		return cellStyle;
	}
	
	//엑셀 body style 수정
	public CellStyle makeExcelBodyStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		//가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
		return cellStyle;
	}
}

//controller
package com.dw.board.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dw.board.service.ExcelService;

/**
 * @author Daeun Yang
 * @create-date : 22.06.16
 * comment : Excel 다운로드 받는 컨트롤러
 */
@Controller
public class ExcelController {
	
	@Autowired ExcelService excelService;
	
	@GetMapping("excel")//엑셀파일 같은 애들은 다운로드 받아야 하기 때문에 리턴이 없음
	public void downloadExcelFile(HttpServletResponse response)throws Exception { //try catch를 일일히 적지 않아도 된다
		String today = new SimpleDateFormat("yyMMdd").format(new Date()); // util import
		String title = "게시판 자료";
		
		response.setContentType("ms-vnd/excel"); //엑셀 파일을 보내겠다
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(today+"_"+title,"UTF-8")+".xls"); // 엑셀 파일
        Workbook workBook = excelService.makeExcelForm();
        workBook.write(response.getOutputStream());
        workBook.close();
        
        response.getOutputStream().flush();
        response.getOutputStream().close();

	}
}
```
---
3. board jsp에 버튼 생성
```jsp
<a href="/excel" class="excel-btn">엑셀 다운로드</a> 
<!-- href 경로 주의 -->
```
---
4. board 웹에 생성된 버튼 누르면 엑셀 파일 다운로드 가능 
---

---
## Log
- 로그 사용 이유 : System.out으로 로그를 찍을 경우 에러발생 시 추적할 수 있는 최소한의 정보가 없다.
### 실무에선 `log`를 이용함. log 출력하면 요청 시간, 내가 설정한 ip, url , HTTP method가 전부 출력됨
 - ex) 쇼핑몰 주문내역 확인
    - 주문이 누락됐다는 고객 컴플레인이 들어오면 CS -> 개발자팀으로 컴플내용을 전달 
        - 1) 쿼리문 작성해서 주문내역 조회
        - 2) 로그 조회 (대개, 로그 기록을 데일리로 보관하고 있음) 
            - 이 순서로 주문내역을 확인하고 이상이 없으면 개발팀 문제가 아닌걸로 판단, 다음 유관부서로 내용을 전달한다. 

### 로그 출력 방법
- 로깅 라이브러리는 slf4j 을 사용하여 내가 로그를 남길 클래스에 선언을 해주고 메소드 내에서 사용하면 된다.

```java
	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 	throws Exception {
		
		String ip = request.getHeader("x-forwarded-For"); // 클라이언트의 ip를 수집할 수 있다.
		String url = request.getRequestURI();
		String httpMethod = request.getMethod();
		
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		
		logger.info("Client IP : " + ip); // info로 출력
		logger.info("request url : " + url);
		logger.info("request HTTP Method : " + httpMethod);

// 서버 실행 후 board로 접속하면 log에 기록이 남는 것을 볼 수 있음

```
=> 프로젝트할 땐 syso으로 출력해보고 최종 업로드시 syso 모두 지우고 서버에 배포하면 됨.

참고 : https://haenny.tistory.com/3

---
---
## AWS (EC2,S3,RDS)
```
EC2 : 프로젝트, java (db설치 가능함 but, 어려워서 rds를 이용하는 것)
S3 : 포트폴리오(웹호스팅) , 이미지 자료만 업로드(jsp같은거 업로드하면 에러남)
RDS : 프로젝트 관련 DB (프리티어)
```

### RDS(Relational Database Service)
---
```
RDS : AWS에서 제공하는 데이터베이스 전용 서버
원하는 데이터베이스 상품을 선택해서 사용 가능.
퍼블릭 엑세스를 설정해야 접속할 수 있다.

AWS에 DB설치 하는 방법이 까다롭다
=> RDS 라는 설치된 DB를 구매하면 됨 (1년 무료)
```
### RDS 생성하기
---
1. AWS에서 `RDS 생성`
```
-> 데이터베이스 생성
-> MySQL 클릭
-> <템플릿> 프리티어 선택
-> DB 인스턴스 식별자 : daeun-database
-> 암호 설정
-> <인스턴스구성> db.t2.micro 설정(무료)
-> <스토리지> 20기가 (최대)
-> <연결> 퍼블릭 엑세스 : '예' 설정 (사실 퍼블릭으로 하면 안됨. 그건 실무가서 배우기)
-> 데이터베이스 생성
```
2. 인바운드, 아웃바운드 `규칙 설정`

![인바운드규칙추가](https://user-images.githubusercontent.com/96815399/174083225-9fec78e4-2691-4510-8343-37bf66fa1741.png)


3. RDS 엔드포인트 `ctrl+c`
```
-> RDS
-> 데이터베이스 
-> DB식별자 , 식별자 이름 클릭
-> 엔드포인트 복사 
```

4. 디비버에서 `AWS 전용 DB 생성`
```
-> 디비버로 돌아가서 
-> 새 데이터베이스 연결
-> mysql 선택, 디비 생성
-> 데이터베이스(dw) 우클 
-> Edit Connection
```
<커넥션 첨부 사진>

 ![디비버커넥션](https://user-images.githubusercontent.com/96815399/173983305-f376bb6f-82a8-4814-9429-4f4b98c7f5c1.PNG)

    1) aws rds에서 만든 데이터베이스의 엔드포인트를 복붙(rds는 보안상 ip 안 알려줌)
    2) rds 생성시 설정한 비밀번호 입력
        *username : admin(default)

5. 이름변경 & 생성확인
```
-> DB 이름 변경 (Edit Connection) : AWS_DB 
-> 초록색 체크 표시 확인(연결 성공 신호)
```
### => 퍼블릭 DB 생성완료(어디서든 DB에 접속 가능하게 됨)

---

### Public IP에 기존 DB(디비버) 내보내기
```
-> aws의 sql 편집기 열기
-> CREATE database dw DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; 구문 입력 (테이블 생성)
-> 원래 로컬 호스트 데이터 테이블 다중 선택 우클
-> 데이터 내보내기 
-> 테이블 클릭 , 다음
-> choose , 경로 설정
-> aws_db 경로 확인
-> 다음 x2 , 이동 목록 확인
-> [create] : 너가 옮기는 데이터의 테이블도 create 해주고 데이터도 넣어줄게
-> 진행 클릭
```

* 일단 임시로 board / board_logs / students 테이블만 데이터 옮기기
(엔드포인트로 디비버 연결, init.sql 구문 실행, 데이터 내보내기)
                                                
---
---
### 개발모드 운영모드 쉽게 전환하기
---
### `개발환경(dev)`
```yaml
--- # ' --- ' 기준으로 하나의 프로필이라고 생각
spring:
   profiles: dev
   datasource:
      initialization-mode: always # 실행 안 시킬거면 : never
      schema : classpath:init.sql
      driver-class-name: com.mysql.cj.jdbc.Driver # 이렇게 설정하면 스프링과 sql이 서로 접속할 수 있음
      url: jdbc:mysql://localhost:3306/dw?useUnicode=true&charaterEncoding=utf-8&serverTimezone=UTC #내 ip 주소
      username: root # 디비버 -> localhost -> edit connection 
      password: 1793
   #JSP 경로 설정 
   mvc:
      view:
         prefix: /WEB-INF/views/
         suffix: .jsp
      #css, js, image 폴더 위치 설정
      static-path-pattern: /resources/static/**    
```

### `운영환경(env)`
```yaml
---
spring:
   profiles: env
   datasource:
      initialization-mode: always # 실행 안 시킬거면 : never
      schema : classpath:init.sql
      driver-class-name: com.mysql.cj.jdbc.Driver # 이렇게 설정하면 스프링과 sql이 서로 접속할 수 있음
      url: jdbc:mysql://daeun-database.ceq0maohxapl.ap-northeast-2.rds.amazonaws.com:3306/dw?useUnicode=true&charaterEncoding=utf-8&serverTimezone=UTC #내 ip 주소
      username: admin # 디비버 -> localhost -> edit connection 
      password: dkssud1951!
   #JSP 경로 설정 
   mvc:
      view:
         prefix: /WEB-INF/views/
         suffix: .jsp
      #css, js, image 폴더 위치 설정
      static-path-pattern: /resources/static/**
```

### `개발 버전 설정`
```yaml
// 개발 버전 설정(로컬환경인지 운영환경인지 선택)
spring : 
   profiles : 
      active : dev
```

### 팀플젝시 init.sql 파일에 스키마들을 적어놓기
```
1. 팀프로젝트 관련 데이터들을 create 
2. init.sql에 create 스키마(쿼리문) 작성 
3. yaml에서 운영모드로 설정 후(AWS와 연결)
4. 서버 실행 하면 AWS에 만든 DB들이 insert 된다.
```