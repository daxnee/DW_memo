package 컬렉션즈;

import java.util.ArrayList;

class Student{
	String name;
	int age;
	String addr; // 주소
	
	public Student(String name, int age, String addr) {
		// this == Student
		this.name = name;
		this.age= age;
		this.addr = addr;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

public class ArrayList_Study2 {

	public static void main(String[] args) {
		Student s1 = new Student("양다은", 27, "대전"); // 배열에 클래스를 넣어줌. 배열 0번째에 Student 내용이 전부 들어가 있음.
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s1); // Student클래스 추가!
		String name = list.get(0).name; // Student 클래스의 name을 불러옴!
		System.out.println(name);
		
		int age = list.get(0).age;
		System.out.println(age);
		
		String addr = list.get(0).addr;
		System.out.println(addr);
		
		int ageMethod = list.get(0).getAge();// Student클래스 안에 있는 메소드(함수) 불러옴.
		System.out.println(ageMethod); 
		
		list.get(0).setAge(33); // 0번째 age를 33으로 set(변경)
		age= list.get(0).getAge(); 
		System.out.println(age);
		
		list.get(0).setName("홍길동");
		name = list.get(0).getName();
		System.out.println(name);
		
		
		
	}

}
