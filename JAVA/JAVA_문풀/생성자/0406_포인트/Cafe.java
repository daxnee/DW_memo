package study;

public class Cafe {
	int count;
	int totalCup;
	String rank;

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		
		this.count = count;
		totalCup += count;
		System.out.println(count+"잔 주문"); // 주문 
		
	}

	public int getTotalCup(int totalCup) {
		return totalCup;
	}


	public void setTotalCup() { // 적립
		this.totalCup = totalCup;
		System.out.println(totalCup +"잔 적립"); 
	}
	
	public void CheckRank() {
		if(totalCup >0 && totalCup <= 10) {
			System.out.println("브론즈 등급입니다.");
		}
		
		if(totalCup > 10 && totalCup <= 20) {
			System.out.println("실버 등급입니다.");
		}
		
		if(totalCup > 20 ) {
			System.out.println("골드 등급입니다.");
		}
	}


	public static void main(String[] args) {
		// 커피를 마시다
		// 포인트를 적립하다
		Cafe c = new Cafe();
		
		c.setCount(5);
		c.getCount();
		c.setTotalCup();
		c.setCount(5);
		c.getCount();
		c.setTotalCup();
		c.CheckRank();
		c.setCount(10);
		c.setTotalCup();
		c.CheckRank();
	
} 
}
