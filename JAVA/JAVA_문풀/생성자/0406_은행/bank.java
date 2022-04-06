public class Bank {
	int money;
	int totalMoney;
	double payback = 0.1;
	
	
	public int checkMoney() {
		System.out.println(+ totalMoney + "만원");
		return this.totalMoney;
		
	}
	
	public void depositMoney(int money) { //입금
		if(money > 500000) {
			System.out.println("입금은 50만원 이하까지 가능합니다.");
		}else {
			System.out.println("입금금액 : " + money + "만원" );
			this.totalMoney += money ;
			System.out.println("현재 잔액 : " + totalMoney + "만원");
			System.out.println("****************************");
		}
		
		if (this.totalMoney >= 1000000) {
			payback = totalMoney * 0.1;
			 this.totalMoney += payback;
			System.out.println("이자 10%가 입금되었습니다. 현재 잔액 : " +totalMoney +"만원");
		}
		
	}
	
	
	public void withdrawMoney(int money){ //출금
		if(this.money < money) {
			System.out.println("출금 가능한 잔액을 확인해주세요");
		}else {
			System.out.println("출금금액 : " + money + "만원");
			System.out.println("****************************");
			this.totalMoney -= money;
			System.out.println("현재 잔액 : " + totalMoney + "만원");
		}
		
	}
	
	
	
}