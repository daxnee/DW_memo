package com.example.first_spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.vo.UserVO;

import lombok.AllArgsConstructor;

@RestController //  이 클래스는 url을 요청받는 곳이야~ 라고 인식해줌 
public class MainController {
	
	@GetMapping("/index") // / : index라는 주소(url)를 요청하면 call() 메소드를 실행할게
	public String call() {
		String word = "다은 world";
		return word;
	}
	@GetMapping("/sum")
	public int callSum() {
		int x = 10; 
		int y = 300;
		return x+ y;
		
		}

	@GetMapping("/array")
	public int[] call2() {
		int[] array = {1,2,3} ;
		for(int i=0; i<array.length; i++) {
			array[i] *= 2; 
		}
		return array; 
	}
	
	@GetMapping("/user")
	public UserVO callUser() { // call or load로 짓는다(회사규칙에 따름)
	 	UserVO vo = new UserVO();
	 	vo.setAge(20);
	 	vo.setName("홍길동");
		return vo;
	}
	
	@GetMapping("/user2")
	public UserVO callUserName() {
		UserVO vo = new UserVO();
		return vo;
	}
	
	@GetMapping("/userList")
	public List<UserVO> callUserlist(){
		List<UserVO> list  = new ArrayList<UserVO>();
		UserVO u = new UserVO();
		u.setAge(27);
		u.setName("양다은");
		list.add(u);
		
		UserVO u1 = new UserVO();
		u1.setAge(28);
		u1.setName("김가가");
		list.add(u1);
		
		UserVO u2 = new UserVO();
		u2.setAge(28);
		u2.setName("김나나");
		list.add(u2);
		
		UserVO u3 = new UserVO(); // 방법1
		u3.setAge(28);
		u3.setName("김다다");
		list.add(u3);
		
		UserVO u4 = new UserVO("김라라" , 22); // 방법2
		list.add(u4);
		return list;
		//원래는 UserVO에 this.name = name을 써줘야 하는데 
		//@AllArgsConstructor 설정하면 그걸 안해줘도 된다.
	}
}
