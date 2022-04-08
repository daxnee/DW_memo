package 컬렉션즈;

import java.util.ArrayList; // 해줘야함

public class EmpMain {

	
	public static void main(String[] args) {
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>(); // 배열의 길이를 지정하지 않아도 유연하게 배열 길이를 조절할 수 있음
		list.add(new EmpVO(7369,"SMITH","CLERK","1980-12-17",800,20,0));
		list.add(new EmpVO(7499,"ALLEN","SALESMAN","1981-02-20",1600,30,300));
		list.add(new EmpVO(7521,"WARD","SALESMAN","1981-02-22",1250,30,500));
		list.add(new EmpVO(7566,"JONES","MANAGER","1981-04-02",2975,20,0));
		list.add(new EmpVO(7654,"MARTIN","SALESMAN","1981-09-28",1250,30,1400));
		list.add(new EmpVO(7698,"BLAKE","MANAGER","1981-05-01",2850,30,0));
		list.add(new EmpVO(7782,"CLARK","MANAGER","1981-06-09",2450,10,0));
		list.add(new EmpVO(7788,"SCOTT","ANALYST","1987-06-28",3000,20,0));
		list.add(new EmpVO(7839,"KING","PRESIDENT","1981-11-17",5000,10,0));
		list.add(new EmpVO(7844,"TURNER","SALESMAN","1981-09-08",1500,30,0));
		list.add(new EmpVO(7876,"ADAMS","CLERK","1987-07-13",1100,20,0));
		list.add(new EmpVO(7900,"JAMES","CLERK","1981-12-03",950,30,0));
		list.add(new EmpVO(7902,"FORD","ANALYST","1981-12-03",3000,20,0));
		list.add(new EmpVO(7934,null,"CLERK","1982-01-23",1300,10,0));
		
	
		
		
		for(int i=0; i<list.size(); i++) {
			//1. 사원번호, 이름 출력
			System.out.println("문제 1번 : " +list.get(i).empno); 
			System.out.println("문제 1번 : " +list.get(i).ename); 
		}
	
			
			// 2. 급여가 1300달러 이상을 받는 사원의 이름과 직업을 조회
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).sal >= 1300) {
				System.out.println("문제 2번 : " +list.get(i).ename);
				System.out.println("문제 2번 : " +list.get(i).job);
				}
		}
			
			// 3. 직업이 SALESMAN인 사원 중 급여가 1400달러 이상 받는 사원의 번호, 이름 조회
		// 문자비교는 equals()
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).job.equals("SALESMAN") && list.get(i).sal >= 1400) {
				System.out.println("문제 3번 : " + list.get(i).empno);
				System.out.println("문제 3번 : " + list.get(i).ename);
			}
		}
		
		
		//4. 입사년도가 1981년도인 사원의 번호,이름 조회
		  for(int i=0; i<list.size(); i++) { 
		  String year[] = list.get(i).hiredate.split("-",3);
		  if(year[0].equals("1981")) {
		  }
		  
		  System.out.println("문제 4번 :" + list.get(i).ename);
		  }
		  
		
		//5. 직업이 MANAGER인 사원 수 조회
		int jobCount =0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).job == "MANAGER") 
				jobCount ++;
			}
		System.out.println("문제 5번 : " + jobCount);
		
		
		// 6. 사원중 급여를 가장 많이 받는 사원의 번호, 이름, 입사년도 
		int max =0;
		int maxI = 0;
		for(int i=0; i<list.size(); i++) {
			if(max < list.get(i).sal) {
				max = list.get(i).sal;
				maxI = i;
			}
		}
		System.out.println("이름 : "  + list.get(maxI).ename);
		System.out.println("번호 : " + list.get(maxI).empno);
		System.out.println("입사년도 : " + list.get(maxI).hiredate);

		
		//7. 부서번호별 수 조회 ex) 20 : 2명, 30: 3명
		int deptno_10 = 0;
		int deptno_20 = 0;
		int deptno_30 = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).deptno == 10) {
				deptno_10++;
			}
			
			if(list.get(i).deptno == 20) {
				deptno_20++;
			}
			
			if(list.get(i).deptno == 30) {
				deptno_30++;

			}
		}
		System.out.println("문제 7번 : " + deptno_10);
		System.out.println("문제 7번 : " + deptno_20);
		System.out.println("문제 7번 : " + deptno_30);
		
	
		//8. 입사월이 02월인 사원 수 조회
		  int monthCount = 0;
		  for(int i=0; i<list.size(); i++) { 
		  String year[] = list.get(i).hiredate.split("-",3);
		  if(year[1].equals("02")) {
			  monthCount++;
		  }
		  }
		  System.out.println("문제 8번 :" + monthCount);
		  System.out.println("**************문제B**************");
		
		
		// 문제B
		//1. comm을 받은 사원 수와 직업,이름을 조회하시오. // *
		  int commCount = 0;
		for(int i=0; i<list.size(); i++) {
			
			if(list.get(i).comm > 0) {
				commCount++;
				System.out.println("B-1번 이름 : " + list.get(i).ename  + ", 직업 : " + list.get(i).job );
			}
		}
		System.out.println(commCount+ "명");

		//2. emp에 있는 급여 평균을 구하시오.
		int salSum = 0;
		int len = list.size();
		for(int i=0; i<list.size(); i++) {
			salSum += list.get(i).sal;
		}
		System.out.println("B-2번 :" + salSum / len);
		
		
		
		//3. 사원번호가 7844, 7876인 사원에게 comm 200을 지급하시오. **
		
		int comm = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).empno == 7844 || list.get(i).empno == 7876) {
				list.get(i).comm += 200;
		}
			System.out.println("B-3번 : "+list.get(i).comm);
		}
		
		
		//4. 사원이름이 null인 사원이름에 '데이터 없음' 으로 수정하시오. 
		for(int i=0; i<list.size(); i++) {
			String checkName = list.get(i).ename;
			if(checkName == null) {
				checkName = "데이터없음";
				System.out.println("B-4번 "+ list.get(i).empno +" : "+ checkName);
		}
		}
		
		//5. 20번 부서가 올해 실적이 좋지 않습니다. 20번부서를 모두 해고(제거)하십시오.
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).deptno == 20) {
				System.out.println("해고된 사람 이름 :" + list.get(i).ename ); // 지울 사람 확인하고 
				list.remove(i); // 지우기
		}
		}
		
//		int max=0;
//		int maxI = 0;
//		for(int i=0; i<list.size(); i++) {
//			if(max < list.get(i).sal ) {
//				max = list.get(i).sal;
//				maxI = i;
//			}
//		}
//		System.out.println("문제 6번 : "+ list.get(maxI).empno);
//		System.out.println("문제 6번 : "+ list.get(maxI).ename);
//		System.out.println("문제 6번 : "+ list.get(maxI).hiredate);
		
		
	// ---------------------------------------------------
		System.out.println("**********번외문제***********");
	// 번외문제1. 사원중 가장 높은 급여의 액수 	
		
		for(int i=0; i<list.size(); i++) {
			if(max < list.get(i).sal) {
				max = list.get(i).sal;
			}
		}
		System.out.println("최대 급여 : " + max);
		

	// 번외문제2. 사원중 가장 적은 급여의 액수
		int min = list.get(0).sal;
		int temp = 0;
		for(int i=0; i<list.size(); i++) {
			if(min > list.get(i).sal) {
				 min = list.get(i).sal;
			}
		}
		System.out.println("최소 급여 : " + min);
		
		
		
		
	}
	}
	
	
