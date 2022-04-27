package test;

import java.util.ArrayList;
import java.util.List;

class MemberVO{
	private String memberNo;
	private int sal;
	
	public String getMemberNo() {
		return memberNo;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
}

class MemberCode{
	public static final double BONUS = 0.1;
	public static final int MAX_VALUE = 300;
	
}

class MemberService implements MemberServiceImpl{
	
	@Override
	public List<MemberVO> getMemberList(List<MemberVO> list){ // 파라미터가 리스트니까 넘겨줄 의무가 있음
		//2. member번호가 200인 사람의 급여 10% 인상된 list 리턴하는 로직 구현
		for(int i=0; i<list.size(); i++) {
			String memberno = list.get(i).getMemberNo();
			if(memberno.equals("200")) { // 멤버번호가 200이면
				int sal = list.get(i).getSal(); // 200인 멤버의 급여
				sal = (int)(sal+sal*MemberCode.BONUS); // 더블 타입이니까 강제로 int변경
				list.get(i).setSal(sal); 
				System.out.println(list.get(i).getMemberNo());
			}
		}
		return list;
	
	}
	@Override
	public String getMemberNo(List<MemberVO> list) {
		for(int i=0; i<list.size(); i++) {
			int memsal = list.get(i).getSal();
			if(memsal >= MemberCode.MAX_VALUE) {
				System.out.println("급여 300 이상인 사람은: " );
				System.out.println(list.get(i).getMemberNo());
				
			}
		}
		return null;
}
	
}



public class 긴급점검9 {
	public static void main(String[] args) {
		
		//1. member 100, 200, 300 추가
		MemberVO m = new MemberVO();
		m.setMemberNo("100");
		m.setSal(100);
		MemberVO m2 = new MemberVO();
		m2.setMemberNo("200");
		m2.setSal(200);
		MemberVO m3 = new MemberVO();
		m3.setMemberNo("300");
 		m3.setSal(300);
		
 		List<MemberVO> list = new ArrayList<MemberVO>(); 
		list.add(m);
		list.add(m2);
		list.add(m3);
		
		// ---- 리스트 호출, 리스트 넣어줌
		
		MemberVO sal1 = new MemberVO();
		MemberVO sal2 = new MemberVO();
		MemberVO sal3 = new MemberVO();
		
		
		MemberService service =  new MemberService();
		service.getMemberList(list);
		
		
		//3. member 100, 200,300 번호, 급여 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMemberNo());
			System.out.println(list.get(i).getSal());
		}
		
		//4. getMemberNo메소드를 이용해서 급여가 300 이상인 멤버의 번호를 리턴하시오
		MemberService service2 = new MemberService();
		 service2.getMemberList(list);
		 service2.getMemberNo(list);
		 
		
		//5. MemberService 안에 있는 메소드 2개를 MemberServiceImpl 이라는 Interface를 생성후 오버라이딩으로 수정할 것

	}
}
