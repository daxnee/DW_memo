package shopping;

import java.util.ArrayList;
import java.util.List;

public class MainMethodClass {
	
	
	public static void main(String[] args) {
		
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(new UserVO(110,500,"BRIAN","2019-07-01 08:14:31"));
		userList.add(new UserVO(1000,500,"ALLEN","2020-03-01 14:30:31"));
		userList.add(new UserVO(120,800,"SANGWON","2021-05-11 18:20:31"));
		userList.add(new UserVO(130,1100,"KING","2022-04-21 09:10:31"));
		userList.add(new UserVO(140,300,"SMITH","2022-04-21 09:00:31"));
		userList.add(new UserVO(150,200,"SCOTT","2022-04-21 09:20:31"));
		userList.add(new UserVO(160,900,"WILLSON","2022-04-21 09:17:31"));
		userList.add(new UserVO(50,770,"SAM","2022-04-21 10:57:00"));
		
		//1. 회원 중 포인트가 가장 많은 회원 정보 조회.(단, 중복데이터는 없다고 가정) o
		//2. 회원 중 앞글자에 S가 들어간 회원 정보 조회. o
		//3. 현재날짜 기준으로 90일동안 방문 없었던 회원 휴먼 계정으로 수정.
		//4. 휴먼계정 인원 수 조회.o
		//5. 휴먼계정이 아닌 회원에게 100포인트 추가 지급.
		//6. 포인트가 가장 높은 회원 조회.(단, 중복데이터는 없다고 가정) o 
		//7. 특정 회원에게 상품구매 발생.
	    //   구매한 상품의 가격 5%가 포인트로 지급. 
		//8. 구매이력이 있는 회원만 조회.
		
		
		ShoppingServiceImpl service  = new ShoppingService();
//		
		userList = service.getUserList(userList);
		userList = service.updateNotSleeperToSleeper(userList, 90);
////    userList = service.getFindByName(userList, "S");
		
	}
}
