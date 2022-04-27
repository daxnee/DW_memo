package test;

import java.util.ArrayList;
import java.util.List;

class Singer{
	public String SingerName; //가수 이름
	public Singer(){ //디폴트 생성자 
		
	}
	public Singer(String singerName) {
		this.SingerName = singerName;
	}
}


public class 긴급점검3 {
	// 리턴타입을 먼저 봐서 데이터 타입을 파악하기!
	
	//파라미터가 없는 함수일때의 문제
	public static List<Singer> getListSinger(){ // 파라미터가 없으니 메소드 안에 리스트를 만들어줘야 함
		List<Singer> list = new ArrayList<Singer>();
		list.add(new Singer("김종국"));  // 배열 안에 클래스가 들어가니까 안에다 생성자 써주고 
		list.add(new Singer("서인국"));  
		list.add(new Singer("방용국")); 
		return list;
	}
		public static List<Singer> getListSinger(List<Singer> list){
			 
			return list;
		}
		public static Singer getSinger(Singer s){
			return s;
		}
	
	public static Singer getSinger(){
		Singer s = new Singer("김종국");
		
		return s;
	}
	
	public static void main(String[] args) {
		//1. getListSinger()이용해서 김종국, 서인국, 방용국 list 출력!
		//2. getSinger()이용해서 김종국만 출력!
		
		Singer s = getSinger();
		System.out.println("2번 : " + s.SingerName);
		
		for(int i=0; i<getListSinger().size(); i++) {
			System.out.println(getListSinger().get(i).SingerName);
		}
		//-----------------------
		
		List<Singer> list = new  ArrayList<Singer>();
		list.add(new Singer("김종국"));  // 배열 안에 클래스가 들어가니까 안에다 생성자 써주고 
		list.add(new Singer("서인국"));  
		list.add(new Singer("방용국"));
		
		
		Singer s2 = new Singer(); 
		System.out.println(getSinger(s).SingerName);
		// get set 사용할땐 SingerName 바로 못쓰고 get 생성 후 getSingerName
		
		
	
		
		
	}
}
