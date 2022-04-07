package 컬렉션즈;

import java.util.ArrayList;

public class ArrayList_Study {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();  // () : 생성자
		// ctrl + shift + o => import 
		// <> : 제네릭
		
		list.add("시금치 파스타"); // add : 배열에 데이터를 삽입.
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		
//		int len = list.size();
//		System.out.println("list 길이는: " + len);
		int count = 0;
		String value = list.get(0);
		System.out.println(value);
		String value2 = list.get(1);
		System.out.println(value2);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == "곱창 파스타") {
				++count;
			}
		}
		System.out.println(count);
		
		//int를 담는 ArrayList
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(40);
		list2.add(60);
		list2.add(80);
		list2.add(30);
		
		int sum = 0;
		for(int i=0; i<list2.size(); i++) {
			if(list2.get(i) != 40) {
			sum += list2.get(i); 
		}
		}
		System.out.println(sum);
	}

	
}
