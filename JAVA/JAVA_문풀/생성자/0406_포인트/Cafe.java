public class Cafe {
	int count;
	int totalCup;
	
	public int orderCoffee(int count) {
		System.out.println(count + "잔 주문");
		return count;
	}
	
	public void savePoint() {
		
		System.out.println(totalCup + "잔 적립");
		totalCup += count;
	}
	
	public static void main(String[] args) {
		// 커피를 마시다
		// 포인트를 적립하다
		Cafe c = new Cafe();
		
		c.orderCoffee(5);
		c.savePoint();
}
}