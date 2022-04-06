// public class Cafe {
// 	int count;
// 	int totalCup;
	
// 	public int orderCoffee() { // 주문
// 		System.out.println(count + "잔 주문");
// 		return count;
// 	}
	
// 	public void savePoint(int count) { // 적립
		
// 		System.out.println(totalCup + "잔 적립");
// 		this.totalCup += count;
// 	}
	
// 	public static void main(String[] args) {
// 		// 커피를 마시다
// 		// 포인트를 적립하다
// 		Cafe c = new Cafe();
		
// 		c.orderCoffee(5);
// 		c.savePoint();
// }
// }


package study;

public class Cafe {
	int count;
	int totalCup;


	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		System.out.println(count+"잔 주문"); // 주문 
		this.count += count;
		
		
	}

	public int getTotalCup() {
		return totalCup;
	}


	public void setTotalCup(int totalCup) { // 적립
		System.out.println(totalCup +"잔 주문"); 
		this.totalCup += totalCup;
	}


	public static void main(String[] args) {
		// 커피를 마시다
		// 포인트를 적립하다
		Cafe c = new Cafe();
		c.setCount(5);
		System.out.println(c.getTotalCup() + "잔 주문"); 
	
}
}
