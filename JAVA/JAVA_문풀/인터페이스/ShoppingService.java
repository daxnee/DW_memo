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
		System.out.println("포인트가 가장 많은 사람 : " + list.get(maxI));
		return list;
	}

	//2. 회원 중 앞글자에 S가 들어간 회원 정보 조회. // *
	@Override
	public List<UserVO> getFindByName(List<UserVO> list, String word) {
		for(int i=0; i<list.size(); i++) {
			String na = list.get(i).getUserName();
			String name[] = na.split("");
			if(name[0].equals(word)) { // main 파라미터에 S를 넣어주면 비교 가능
				System.out.println("S로 시작하는 이름은 : " + list.get(i).getUserName());
			}
		}
		return list;
	}
	
	// 2번째 방법 : substring을 이용하기
//	public List<UserVO> getFindByName(List<UserVO> list, String word) {
//		for(int i=0; i<list.size(); i++) {
//			String name = list.get(i).getUserName().substring(0, 1);
//			if(name.equals(word)) {
//				System.out.println("S로 시작하는 이름은 : "+list.get(i).getUserName());
//			}
//		}
//		return null;
//	}

	@Override
	//3. 현재날짜 기준으로 90일동안 방문 없었던 회원 휴먼 계정으로 수정.
	//4. 휴먼계정 인원 수 조회.
	public int getSleeperUserCount(List<UserVO> list) {
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).isSleeper()) {
				count++;
			}
		}
		System.out.println("휴면계정 인원 수 : "+count);
		return count;
	}
	
	@Override
	public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days) {
		
		Date d = new Date();
//		1. 오늘날짜를 구해야 함 
		// java에서 날짜를 계산할때는 SimpleDateFormat을 사용!
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);// Locale.KOREA : 한국 시간으로 가져와야 함
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
		for(int i=0; i<list.size(); i++) {
			System.out.println("회원 이름 : "+list.get(i).getUserName()+", 휴먼 계정여부 : "+list.get(i).isSleeper());
		}
		
		return list;
	}

	@Override
	public List<UserVO> updatePoint(List<UserVO> list, int point) {
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).isSleeper()) {
				list.get(i).setPoint(list.get(i).getPoint()+point);
//			System.out.println("휴먼계정이 아닌 회원에게 포인트+100 => "+list.get(i).getPoint()+"점");
			}
		}
		return list;
	}

	// 6. 포인트가 가장 높은 회원 조회
	@Override
	public UserVO getPointRankerUser(List<UserVO> list) {
		int maxP = 0;
		int maxIndex = 0;
		for(int i=0; i<list.size(); i++) {
			if(maxP < list.get(i).getPoint()) {
				maxP = list.get(i).getPoint();
				maxIndex = i;
			}
		}
		System.out.println("포인트가 가장 많은 사람 : " + list.get(maxIndex).getUserName());
		return null;
		}
	
	

	@Override
	public List<UserVO> getPurchaseRankerUser(List<UserVO> list, ProductVO vo, int userNo) {
		double pointP= 0.05;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUserNo() == userNo) { // main에서 설정한 username과 같다면 (상품을 구매한 사람)
				list.get(i).setPoint(list.get(i).getPoint()+(int)(vo.getPrice()*pointP));  // 포인트 지급
				// 데이터타입이 double이라서 강제로 int형을 더해줘야만 계산이 가능함!
				// (vo.getPrice()*pointP) : 상품 가격의 5%
				int point = list.get(i).getPoint();
				System.out.println("가격의 5%인 " +(int)(vo.getPrice()*pointP)+"를 포인트로 적립, 총 포인트 점수 = "+list.get(i).getPoint());
			}
		}
		return list;
	}

}
