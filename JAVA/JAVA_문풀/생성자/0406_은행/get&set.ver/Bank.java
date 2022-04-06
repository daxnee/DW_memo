

public class Bank { //은행
	
	//이자를 주는 함수
	public static double paidInterestOnAccount(int money){ 
		final double INTEREST_RATE = 0.1;
		return money * INTEREST_RATE;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setDeposit(1000);
		if(account.getTotalMoney() > 0){
			System.out.println("현재 잔고 ==> "+account.getTotalMoney() +"원");
			account.setWithdraw(500);
			System.out.println("현재 잔고 ==> "+account.getTotalMoney() +"원");
			account.setDeposit(500000); //월급 50만원
			account.setDeposit(500000); //보너스 50만원
			account.setDeposit(500000); //야근수당 50만원
			System.out.println("현재 잔고 ==> "+account.getTotalMoney() +"원");
			int myMoney = account.getTotalMoney();
			if(myMoney >= 1000000){ //입금 후 잔액이 백만원 이상이면
				int interestMoney = (int)paidInterestOnAccount(myMoney);
				System.out.println("이자는 ==> "+interestMoney);
				account.setTotalMoney(interestMoney);
				System.out.println("현재 잔고 ==> "+account.getTotalMoney() +"원");
			}
		}
		
	}
}