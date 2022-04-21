package shopping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ShoppingService implements ShoppingServiceImpl{
	
	//1. 회원 중 포인트가 가장 많은 회원 정보 조회.(단, 중복데이터는 없다고 가정)
	@Override
	public List<UserVO> getUserList(List<UserVO> list) {
		int max = 0;
		int maxI = 0;
		for(int i=0; i<list.size(); i++) {
			if(max < list.get(i).getPoint()) {
				max = list.get(i).getPoint();
				maxI = i;
			}
		}
		System.out.println(list.get(maxI));
		return list;
	}

	//2. 회원 중 앞글자에 S가 들어간 회원 정보 조회. // *
	@Override
	public List<UserVO> getFindByName(List<UserVO> list, String word) {
		for(int i=0; i<list.size(); i++) {
			String w = list.get(i).getUserName();
			String name[] = w.split("");
			if(name[0].equals(word)) {
			}
			System.out.println(list.get(i));
			
		}
		return list;
	}

	@Override
	//3. 현재날짜 기준으로 90일동안 방문 없었던 회원 휴먼 계정으로 수정.
	//4. 휴먼계정 인원 수 조회.
	
	// 1. 두 날짜를(현재, 방문) 밀리세컨드로 바꾸고  
	//2. 현재 - visit =  diffday
	// 3. 90일의 diff를 구한 뒤
	// 3. if diff가 90보다 크다면 휴면계정으로 set(true) 
	public int getSleeperUserCount(List<UserVO> list) {
		
		
		
		return 0;
		
	}

	@Override
	public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days) {
		
		Date d = new Date();
//		1. 오늘날짜를 구해야 함 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);// 한국 시간으로 가져와야 함
		String strToday = formatter.format(Calendar.getInstance().getTime()); // 오늘 날짜 리턴
		Date today = null; //오늘 날짜 => 전역변수로 만들어줘서 사용하기 쉽게 해줌
		Date visit = null; //방문 날짜
		try { // 시도가 성공하면 아래 코드를 실행시켜줄게
			for(int i=0; i<list.size(); i++) {
				String strVisitAt = list.get(i).getVisitAt();
				today = formatter.parse(strToday);
				visit = formatter.parse(strVisitAt);
				long diffDays = (today.getTime() - visit.getTime())/(1000*60*60*24);
			if(diffDays >= days) {
				list.get(i).setSleeper(true); // 휴면 계정이라면
				
			}else {
				list.get(i).setSleeper(false);// 휴면 계정이 아니라면
			}
		}
		} catch (ParseException e) {
			// 에러가 나면 catch할게
			e.printStackTrace(); // 에러를 추적하겠다.
		}
		
		return list;
	}

	@Override
	// 6. 포인트가 가장 높은 회원 조회
	public List<UserVO> updatePoint(List<UserVO> list, int point) {
		for(int i=0; i<list.size(); i++) {
			int maxP = 0;
			int maxIndex = 0;
			if(maxP < list.get(i).getPoint()) {
				maxP = list.get(i).getPoint();
				maxIndex = i;
			}
			System.out.println(list.get(maxIndex));
		}
		return list;
	}

	@Override
	public UserVO getPointRankerUser(List<UserVO> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> getPurchaseRankerUser(List<UserVO> list, ProductVO vo, int userNo) {
		// TODO Auto-generated method stub
		return list;
	}

}
