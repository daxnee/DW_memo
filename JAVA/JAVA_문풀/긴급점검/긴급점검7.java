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
	list.add(l);
	list.add(l2);
	
	
	for(Lunch lunch : list) {
		System.out.println(lunch.getFoodName()); // lunch : for문에서 지정해준 변수
	}
	System.out.println(l.getFoodName() + ", "+ l2.getFoodName());
	 
	
	
}
}


package test;

import java.util.ArrayList;
import java.util.List;

class Lunch{
	private List<String> foodName;
	
	

	public List<String> getFoodName() {
		return foodName;
	}

	public void setFoodName(List<String> foodName) { // 스트링을 받는 배열임
		this.foodName = foodName;
	}
	
}



public class 긴급점검7 {
public static void main(String[] args) {
	List<String> list = new ArrayList<String>(); // 배열을 list에 넣어주고 
	Lunch l = new Lunch(); // 생성
	list.add("스바라시라멘"); // 리스트에 넣어줌
	l.setFoodName(list);
	
	Lunch l2 = new Lunch();
	 l2.setFoodName(list);
	list.add("우동");
	
	for(String foodName : l.getFoodName()) {
		System.out.println(foodName);
	}
	

	
}
}


-------------

package test;

import java.util.ArrayList;
import java.util.List;


class Movie{
	private String movieName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}


public class 긴급점검7 {
	public static List<Movie> getMovieList(){
		List<Movie> list = new ArrayList<Movie>();
		Movie m = new Movie();
		m.setMovieName("공기살인");
		list.add(m);
		
		Movie m2 = new Movie();
		m.setMovieName("로스트시티");
		list.add(m2);
		return list; 
	}
	
public static void main(String[] args) {
	List<Movie> list = getMovieList();
	
	for(Movie movie : list) {
		System.out.println(movie.getMovieName());
	}
	
}
}













