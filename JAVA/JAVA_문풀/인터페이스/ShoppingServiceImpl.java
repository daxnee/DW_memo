package shopping;

import java.util.List;

public interface ShoppingServiceImpl {
	
	/**
	 * @param list
	 * @return List
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 모든 회원 조회
	 */
	
		
	public List<UserVO> getUserList(List<UserVO> list);
	
	/**
	 * @param list
	 * @param word
	 * @return List
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 이름으로 회원 조회
	 */
	public List<UserVO> getFindByName(List<UserVO> list, String word);
	
	/**
	 * @param list
	 * @return int
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 휴먼 계정 수 조회
	 */
	public int getSleeperUserCount(List<UserVO> list);
	
	/**
	 * @param list
	 * @param days
	 * @return List
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 장기간 미접속자 휴먼계정으로 수정
	 */
	public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days);
	
	/**
	 * @param list
	 * @param point
	 * @return List
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 포인트 점수 수정
	 */
	public List<UserVO> updatePoint(List<UserVO> list, int point);
	
	/**
	 * @param list
	 * @return UserVO
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 포인트가 가장 높은 회원 조회
	 */
	public UserVO getPointRankerUser(List<UserVO> list);
	

	/**
	 * @param list
	 * @param userNo
	 * @param vo
	 * @return List
	 * @date : 2022. 4. 21.
	 * @author : sangwon Hyun
	 * comment : 특정 회원 상품구매
	 */
	public List<UserVO> getPurchaseRankerUser (List<UserVO> list, ProductVO vo ,int userNo);
	
	

}