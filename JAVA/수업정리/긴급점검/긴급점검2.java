package 스태틱;

class Dw2{
	 String className;
	 String studentName;
	 public Dw2() {
		 //  이렇게 생성해줘야 아래 오류가 안 남
	 }
	 
	 public Dw2(String className, String studentName) {
		 this.className = className;
		 this.studentName = studentName;
	 }

}

public class 복습 {
	public static Dw2 printStudent2() {
		
		//방법2
		Dw2 d2 = new Dw2("반응형웹&앱개발반", "홍길동");
		 return d;
	}
	
	public static void main(String[] args) {
		//방법1
		Dw2 d = new Dw2("반응형웹&앱개발반", "홍길동");
		System.out.println(d.className + d.studentName);
		
		
		//방법2
		Dw2 d2 = printStudent2(); // 인스턴스화가 이뤄진 메소드 이름을 불러줌
		// static이라서 new 사용 안하고 호출이 가능
		// 주의점 : 다른 클래스에서 불러오는 경우 = > 클래스이름 d3 = 클래스이름.printStudent()
		// - 이름을 명시해줘야 오류가 나지 않음
		System.out.println(d2.className + d2.studentName);
	}
}

------------------------------------------

package 스태틱;

 class Dw{
	 String className;
	 String studentName;
	 public Dw() {
		 //  이렇게 생성해줘야 아래 오류가 안 남
	 }
	 
	 public Dw(String className, String studentName) {
		 this.className = className;
		 this.studentName = studentName;
	 }


 }

public class 긴급점검2 {
	
	public static int getNumber() { // 무조건 20 이상을 넘겨야 하는 조건이라면 
		int x= 0; // if로 조건을 주면됨
		if(x <= 20) {
		}
		return x;
	}
	
	public static Dw printStudent() {
		Dw d =  new Dw("스마트웹&앱과정", "홍길동");  // 리턴 방법1
		return d;
		
//		return new Dw("스마트웹&앱과정", "홍길동"); //리턴 방법2.  return 바로 써줘도 됨
	}

	public static void main(String[] args) {
		// 방법1 
		Dw d = printStudent();
		System.out.println("과정명 : " + d.className + ", 학생명 : " + d.studentName);
		//방법2
		System.out.println(printStudent().className);
		System.out.println(printStudent().studentName);
	}

}
