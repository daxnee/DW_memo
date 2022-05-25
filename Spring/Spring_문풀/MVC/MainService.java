package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first_spring.vo.UserVO;

@Service // '비즈니스 로직'이 있겠구나~ 라고 스프링이 알아먹음 // 여기서 코딩을 하면 된다.
public class MainService {

	public List<UserVO> getUserList2(){
		// 파라미터 타입이 없기 때문에 리스트를 생성해야 한다.
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌", 51, "서울"));
		UserVO u = new UserVO();
		u.setName("양다은");
		u.setAddr("내주소");
		u.setAge(27);
		list.add(u);
		return list;
	}
	  //문제 1. 나이가 60 이하인 배우만 리턴하시오.
	public List<UserVO> getUserList(){
			List<UserVO> list = new ArrayList<UserVO>();
			list.add(new UserVO("이병헌",51,"서울"));
	        list.add(new UserVO("조승우",42,"서울"));
	        list.add(new UserVO("이경영",61,"서울"));
	        list.add(new UserVO("배성우",49,"서울"));
	        list.add(new UserVO("백윤식",75,"서울"));
	        UserVO u = new UserVO();
	         u.setName("양다은");
	         u.setAge(28);
	         u.setAddr("대전");
	         list.add(u);
	         
	         //방법1 : 60이상을 다 지우거나
	         //방법2 : 60이상을 담는 배열을 추가하거나
	        for(int i=0; i<list.size(); i++) {
	        	if(list.get(i).getAge() >= 60) {
	        	 list.remove(i);
	        	 --i; // 원소를 지우면 컬렉션즈는 앞으로 당겨짐. 그러니까 -i를 해서 다시 검사를 진행함
	        	}
	        	System.out.println( list.get(i).getName());
	        }
			return list;
		}
	    //문제 2. 나이가 가장많은 배우의 나이를 리턴하시오.
	    public int getUserAgeMax(){
			List<UserVO> list = new ArrayList<UserVO>();
			list.add(new UserVO("이병헌",51,"서울"));
	        list.add(new UserVO("조승우",42,"서울"));
	        list.add(new UserVO("이경영",61,"서울"));
	        list.add(new UserVO("배성우",49,"서울"));
	        list.add(new UserVO("백윤식",75,"서울"));
	        int age = 0;
	        int max = 0; 
	        for(int i=0; i<list.size(); i++) {
	        	age = list.get(i).getAge();
	        	if(max< age) {
	        		max = age;
	        	}
	        }
			return age;
		}
	    //문제 3. list에 배우이름 배성우가 있다면 리턴하시오.
	    public UserVO getUser(){
			List<UserVO> list = new ArrayList<UserVO>();
			list.add(new UserVO("이병헌",51,"서울"));
	        list.add(new UserVO("조승우",42,"서울"));
	        list.add(new UserVO("이경영",61,"서울"));
	        list.add(new UserVO("배성우",49,"서울"));
	        list.add(new UserVO("백윤식",75,"서울"));
	         
	        for(int i=0; i<list.size(); i++) {
	        	if(list.get(i).getName().equals("배성우")) {
	        		return list.get(i);
	        	}
	        }
	        return null;
		}
	    //문제 4. list에 성이 이씨인 배우가 몇명인지 리턴하시오.
	    public int getUserCount(){
			List<UserVO> list = new ArrayList<UserVO>();
			list.add(new UserVO("이병헌",51,"서울"));
	        list.add(new UserVO("조승우",42,"서울"));
	        list.add(new UserVO("이경영",61,"서울"));
	        list.add(new UserVO("배성우",49,"서울"));
	        list.add(new UserVO("백윤식",75,"서울"));
	        int count = 0;
	        for(int i=0; i<list.size(); i++) {
	        	String name = list.get(i).getName().substring(0,1); // 0번째 인덱스부터 1글자
	        	if(name.equals("이")) {
	        		count++;
	        	}
	        }
	        return count;
		}
	}

