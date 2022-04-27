package test;

import java.util.ArrayList;
import java.util.List;


class Food{
	private  String foodName;
	public Food() {
		
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
}

public class 긴급점검5 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("카레");
		list.add("칼국수");
		list.add("전");
		for(int i=0; i<list.size(); i++) {
		 System.out.println("음식이름은 : " + list.get(i) );
		}
		 //List<클래스>가 오려면 어떻게 해야 할까
		 //방법1
		 List<Food> list2 = new ArrayList<Food>();
		 //1. list안에 데이터 타입 확인
		 Food f = new Food(); // String str = "100"; 같은 의미라고 보면 됨 
		 //2. 클래스 타입이면 클래스를 호출해준다. (String 제외)
		 // 이렇게 생성해주면 class 안에 사용할 메소드가 많은 경우 변수를 이용해서 여러번 사용할 수 있다.
		 f.setFoodName("김치우동");
		 list2.add(f);
		 //3. 호출한 클래스를 list에 담는다.
		 
		 //방법2
//		 list2.add(new Food());
		 
		 //Food 클래스에 파라미터가 있을경우엔 데이터타입에 맞게 넣어준다.
		 // 컬렉션즈 패키지 -> EmdMain.java 파일 참고 
		 //이 방법은 변수가 없어서 재사용이 불가하다. 다시 new로 호출해야 됨
		 
		 Food f2 = new Food();
		 f2.setFoodName("우동");
		 list2.add(f2);
		 
//		 Food f3 = list2.get(0);  // get에 food가 있으니까 데이터 타입 food로 변수를 받아줄 수 있음
		 
		 // ---------------------------
		 // 김치우동, 우동 for문으로 출력하기
		 
		 // foreach문
		 int count =0;
		  for(Food food : list2) {// Food f3 = list.get(0); => list2 뒤 get이 생략된 것임
			  System.out.println(food.getFoodName()); 
			  //foreach문은 디버깅이 힘듦
			  count++; // 이렇게 증감연산자를 줘야 몇 번째 있는지 디버깅이 가능
		  }
		  
		 //for문
		 for(int i=0; i<list2.size(); i++) {
			 //add :추가
			 //remove : 지우기
			 System.out.println( list2.get(i).getFoodName());
			 //get(0) food를 불러오는 것임
		 }
		 
		 
	}
}
