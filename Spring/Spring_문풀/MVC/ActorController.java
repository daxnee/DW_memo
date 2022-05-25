package com.example.first_spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.MainService;
import com.example.first_spring.vo.UserVO;

@RestController // 1번순서
public class ActorController {
	@Autowired // 3번순서
	private MainService service; //2번순서
	
	@GetMapping("/actor/list")
	public List<UserVO> callUserList(){
		return service.getUserList();
	}
	
	@GetMapping("/actor/age")
	public int callUserAgeMax(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-For"); // 클라이언트의 ip를 수집할 수 있다.
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		System.out.println("IP ====> " + ip);
		return service.getUserAgeMax();
	}
	
	@GetMapping("/actor")
	public UserVO callUserName(){
		return service.getUser();
	}
	
	@GetMapping("/actor/count")
	public int callUserCount(){
		return service.getUserCount();
	}
}
