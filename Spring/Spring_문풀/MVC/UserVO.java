package com.example.first_spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Getter == @Data
//@Setter == @Data
@Data // getter setter 함수를 자동으로 만들어 줌
@AllArgsConstructor // 자동으로 생성자를 만들어줌 
public class UserVO {
	private String name;
	private int age;
	private String addr;
	
	public UserVO() {
	}
}
