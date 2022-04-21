package shopping;

import java.util.List;

public class UserVO {
	
	private int userNo; //사용자 번호
	private int point; //사용자 포인트
	private String userName; //사용자 이름
	private String visitAt; //최근 방문 날짜
	private boolean isSleeper; //휴면계정 여부 (true: 휴먼 , false : 휴먼 아님)
	private List<ProductVO> list; //구매한 상품 (구매 이력)
	
	public UserVO(int userNo, int point, String userName, String visitAt){
		this.point = point;
		this.userNo = userNo;
		this.userName = userName;
		this.visitAt = visitAt;
	}
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public List<ProductVO> getList() {
		return list;
	}
	public void setList(List<ProductVO> list) {
		this.list = list;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isSleeper() {
		return isSleeper;
	}
	public void setSleeper(boolean isSleeper) {
		this.isSleeper = isSleeper;
	}
	public String getVisitAt() {
		return visitAt;
	}
	public void setVisitAt(String visitAt) {
		this.visitAt = visitAt;
	}

}
