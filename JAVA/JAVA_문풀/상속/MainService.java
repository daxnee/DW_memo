package 상속3;

import java.util.ArrayList;
import java.util.List;

class UserVO{
	private String name;
	private int sal; //급여
	
	public UserVO(String name, int sal){
		this.name = name;
		this.sal = sal;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
}

class MainUtil{
	
	public List<UserVO> getAllUsers(){ //전체 유저 호출
		return null;
	}
	
	public String getUser(List<UserVO> list, String name){ //특정 유저 호출
		return null;
	}
	
	public List<UserVO> deleteUser(List<UserVO> list, int index){
		return null;
	}
	
	public int getUserTotalSal(List<UserVO> list){
		return 0;
	}
	
}
public class MainService extends MainUtil{
	
	public static void main(String[] args) {
		//위에 MainUtil함수를 이용해서 문제풀 것.
		//1. 전체 유저 호출
		//2. 특정 유저 호출
		//3. 특정 유저 삭제
		//4. 모든 유저 급여 합 구하기
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("SMITH", 100));
		list.add(new UserVO("BRIAN", 300));
		list.add(new UserVO("ALLEN", 600));
		list.add(new UserVO("KING", 2000));
		MainService main = new MainService();
		
	}
}