package test;

import java.util.ArrayList;
import java.util.List;

class Chef{
	 private int chefAge;

	public int getChefAge() {
		return chefAge;
	}

	public void setChefAge(int chefAge) {
		this.chefAge = chefAge;
	}
	
 }


public class 긴급점검8 {
	
	//리턴타입 list 
	public static List<Chef> getChefList(){
		List<Chef> list = new ArrayList<Chef>();
		Chef l = new Chef();
		l.setChefAge(30);
		
		Chef l2 = new Chef();
		l2.setChefAge(40);
		
		Chef l3 = new Chef();
		l3.setChefAge(50);
		
		Chef l4 = new Chef();
		l4.setChefAge(60);
		
		list.add(l);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getChefAge());
		}
		
		return list;
		
	}
	
	// 리턴타입 int, 파라미터값엔 클래스타입인 List 
	public static int getChefListCount(List<Chef> list){
		int count =0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getChefAge() >= 50) {
				count ++;
			}
		}
		return count;
	}
	

	public static void main(String[] args) {
		List<Chef> list = getChefList(); // static이라 인스턴스화 하지 않아도 메소드 호출 가넝한
//		== System.out.println(getChefList());
		System.out.println("50이상 요리사의 수는 : "+ getChefListCount(list));
		
	}
}

-------------------

package test;

import java.util.ArrayList;
import java.util.List;

import 스태틱.Chef;

class FruitVO{
	 private String fruitName;

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}


	 
 }

class FruitService{
	public FruitVO getFruit(List<FruitVO> list, String fruitName) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getFruitName().equals(fruitName)) {
				return list.get(i);

			}
		}
		return null;		
	}
}


public class 긴급점검8 {
	
	public static void main(String[] args) {
		List<FruitVO> list = new ArrayList<FruitVO>();
		FruitVO f = new FruitVO();
		f.setFruitName("포도");
		
		FruitVO f2 = new FruitVO();
		f2.setFruitName("수박");
		
		FruitVO f3 = new FruitVO();
		f3.setFruitName("참외");
		
		list.add(f);
		list.add(f2);
		list.add(f3);
		
		FruitService service = new FruitService();
		FruitVO result = service.getFruit(list, "수박");
		
		System.out.println(result.getFruitName());
		
	}
		
}
