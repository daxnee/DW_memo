package test;

import java.util.ArrayList;
import java.util.List;

class MemberVO{
	private String memberNo;
	private int sal;
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
}

class MemberCode{ // static 변수라 생성자 없이 호출이 가능
	public static final double BONUS = 0.1;
	public static final int MAX_VALUE = 300;
}


class MemberService {
	
	public List<MemberVO> getMemberList(List<MemberVO> list){
		//2. member번호가 200인 사람의 급여 10% 인상된 list 리턴하는 로직 구현
		for(int i=0; i<list.size();i++) {
			String memberno = list.get(i).getMemberNo();
		if(memberno.equals("200")) {
			int sal = list.get(i).getSal();
			sal = (int)(sal+(sal*MemberCode.BONUS));
			list.get(i).setSal(sal);
			System.out.println("급여가 10% 인상된 사람은");
			System.out.println(list.get(i).getMemberNo()+"번");
		}
	}
		return list;
	}
	
	public String getMemberNo(List<MemberVO> list) {
	//4. getMemberNo메소드를 이용해서 급여가 300 이상인 멤버의 번호를 리턴하시오
		for(int i=0; i<list.size(); i++) {
			int memSal = list.get(i).getSal();
			if(memSal >= MemberCode.MAX_VALUE) {
				System.out.println("급여 300 이상인 사람은");
			System.out.println(list.get(i).getMemberNo());
			
			return list.get(i).getMemberNo();
			}
		}
		
		return null;
	}
	
}
	
public class 긴급점검10 {

	public static void main(String[] args) {
		//1. member 100, 200, 300 추가
		MemberVO m1 = new MemberVO();
		m1.setMemberNo("100");
		m1.setSal(100);
		MemberVO m2 = new MemberVO();
		m2.setMemberNo("200");
		m2.setSal(200);
		MemberVO m3 = new MemberVO();
		m3.setMemberNo("300");
		m3.setSal(300);
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		
		MemberService service = new MemberService();
//		MemberVO sal1 = new MemberVO();
//		MemberVO sal2 = new MemberVO();
//		MemberVO sal3 = new MemberVO();
		
		
		MemberService Service1 = new MemberService();
//		System.out.println("급여 인상 멤버"+ Service1.getMemberList(list));
		System.out.println("%%%%%");
		Service1.getMemberList(list);
		
		MemberService Service2 = new MemberService();
		System.out.println(" d" +Service2.getMemberNo(list));
		System.out.println("$$$");
		
		
	}

}
