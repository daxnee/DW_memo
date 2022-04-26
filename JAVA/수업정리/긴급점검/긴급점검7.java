package test;

import java.util.ArrayList;
import java.util.List;

class Lunch{
	private String foodName;
	public Lunch() {
		
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
}



public class 긴급점검7 {
public static void main(String[] args) {
	List<Lunch> list = new ArrayList<Lunch>();
//	list.add(10);
//	list.add(20);
//	// 
//	for(int i : list) { // Integer는 int니까 
//		System.out.println(i);
//	}
	Lunch l =  new Lunch();
	Lunch l2 =  new Lunch();
	l.setFoodName("칼국수");
	l2.setFoodName("스바라시라멘");
	
	System.out.println(l.getFoodName() + ", "+ l2.getFoodName());
	 
	
	
}
}
