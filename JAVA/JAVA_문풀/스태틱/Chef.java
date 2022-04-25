package 스태틱;

public class Chef {
	private static Chef chef = null; // static으로 선언된 클래스 변수
	
	public static Chef getInstance() { // class 초기값이 null이니까 리턴타입 클래스가 가능한것임
		// 스태틱으로 선언된 메소드
		// getInstance() 이라는 싱글톤 패턴을 이용해서 
		if(chef == null) {
			chef = new Chef();
		}
		return chef;
	}
	public void printHello() {
		System.out.println("hello world");
	}
}
