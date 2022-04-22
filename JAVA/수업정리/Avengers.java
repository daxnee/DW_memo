package shopping;

import java.util.ArrayList;
import java.util.List;

class Members{
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
	
	
	public static Members PrintMemberName(Members member) { // 리턴타입 member
		//  null이 나올 수 있는 것을 대비해서 
		 if(member == null){
			 member = new Members();
		 } //이렇게 설정해줘서 null을 막아준다 
		 
		// --------------------------
		//  try { // null을 걸러내기 위한 작업
		// 	if(member == null) {
		// 		member =new Members();
		// 	}
		// } catch(Exception e) {
		// 	e.printStackTrace();
		// } 이렇게 try/catch 구문을 사용해서 정밀한 작업도 가능함
		 
		//---------------------------
		 

		 member.setName("토르"); //멤버세팅

		 //멤버클래스에 stone을 추가하려면?
		 List<String> list = new ArrayList<String>(); // list를 불러옴(현재 list = null)
		 list.add("파워스톤"); // list[0]:파워스톤 / list[1]:타임스톤
		 list.add("타임스톤");
		 member.setStone(list); // list를 member 클래스에 추가
		 return member;
	
}	
		public static void main(String[] args) {
		Members m = new Members();
		m.setName("캡틴아메리카");
		String name = m.getName();
		System.out.println("m의 이름은 =>"+ name);
		
		//모든 class의 초기값은 null
//		Members m2 = new Members(); // new로 초기값 주면 m과 m2는 다른 메소드다.
		Members m2 = m; // 이렇게 하면 초기화한 m은 m2로 변경됨 
		String name2 = m2.getName(); 
		System.out.println("m2의 이름은 => "+name2);
		
		
		// 방법1
		PrintMemberName(m);
		
		//방법2
		PrintMemberName(new Members());
		
		//방법3
		Members m3=null; //class의 초기값이 null 줄 수 있음
		
		PrintMemberName(m3);
		m3 = PrintMemberName(m3);
		m3.setName("헐크"); // 헐크로 세팅
		m3.getName();
		System.out.println(m3.getName());
		
		List<String> list = new ArrayList<String>();
		list.add("소울스톤");
		list.add("마인드스톤");
		list.add("스톤헨지");
		
		m3.setStone(list); // 여기서 set을 안해주면 PrintMemberName class에서 세팅한 파워, 타임만 나온다.
		System.out.println(m3.getStone().size()); //size : 3
		// m3.getStone() : [소울스톤, 마인드스톤, 스톤헨지]
		// 
	}

}
