package shopping;

import java.util.ArrayList;
import java.util.List;

class Member{
	private String name;
	private List<String> stone;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getStone() {
		return stone;
	}

	public void setStone(List<String> stone) {
		this.stone = stone;
	}
	
}

public class Avengers {
	
	public static 
	
	public static Member printMemberName(Member member) { // 리턴타입 member
		//  null이 나올 수 있는 것을 대비해서 
		 if(member == null){
			 member = new Member();
		 } //이렇게 설정해줘서 null을 막아준다 

		 member.setName("토르"); //멤버세팅

		 //멤버클래스에 stone을 추가하려면?
		 List<String> list = new ArrayList<String>(); // list를 불러옴(현재 list = null)
		 list.add("파워스톤"); // list
		 list.add("타임스톤");
		 member.setStone(list);
		 return member;
	
}	
	public static void main(String[] args) {
		Member m3 = null;
		 m3 = printMemberName(m3);
		 m3.setName("헐크");
		 m3.getName();
		 System.out.println(m3.getName()); // 헐크
		
		 List<String> m4 =  new ArrayList<String>(); 
		 String powerStone = m3.getStone().get(0);
		 m3.setName(powerStone);
		 System.out.println(m3.getName());
		
	}

}
