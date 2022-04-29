package final_test;

import java.util.ArrayList;
import java.util.List;

public class EmpService implements EmpServiceImpl{

	@Override
	public List<final_test.EmpVO> getEmpList(List<final_test.EmpVO> list) {
		int sal =0;
		for(int i=0; i<list.size(); i++) {
			sal =list.get(i).getSal(); 
			sal = sal + EmpCode.SPECIAL_BONUS;
			list.get(i).setSal(sal);
			System.out.println("사원번호"+ list.get(i).getEmpno());
			System.out.println("이름"+ list.get(i).getEname());
			System.out.println("문제 1. 사원급여 : "+ list.get(i).getSal());
			
			
		}
		return list;
	}

	@Override
	public final_test.EmpVO getEmp(List<final_test.EmpVO> list) {
		int max = 0; 
		int maxIndex = 0;
		for(int i=0; i<list.size(); i++) {
			int sal = list.get(i).getSal();
			if(max < list.get(i).getSal()) {
				max = list.get(i).getSal();
				maxIndex = i;
			}
		}
		System.out.println("문제 2. 최고 급여 : "+ list.get(maxIndex).getEname());
		return list.get(maxIndex);
	}

	@Override
	public int getCount(List<final_test.EmpVO> list, int sal) {
		int count =0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSal() < sal ) {
				count++;
			}
		}
		System.out.println("문제 3. 급여 300 이하 : " + count + "명");
		
		return count;
	}

	@Override
	public final_test.EmpVO setDept(final_test.EmpVO empVO) {
		//4번. 특정 사원에 부서번호 10, 부서이름 SALES 부서를 추가하고 사원을 리턴하시오.
		List<DeptVO> list2 = new ArrayList<DeptVO>();
		DeptVO d = new DeptVO(10, "ALLEN");
		d.setDeptno(10);
		d.setDname("SALES");
		list2.add(d);
		
		
		// -------- 여기부터 모르겠습니다 다시 풀어보겠습니답!
		
		return empVO;
	}

	
	
}
