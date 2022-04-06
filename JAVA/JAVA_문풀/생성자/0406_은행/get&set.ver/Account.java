package 은행문제풀이;


class Account{ //계좌
	int deposit; //입금
	int withdraw; //출금
	int totalMoney; //잔고
	
	//getter, setter
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) { //입금
		System.out.println("입금한 금액은 =>"+deposit+"원 입니다.");
		this.deposit += deposit; //총 입금 금액
		this.totalMoney += deposit; //내 잔액
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) { //출금
		if(this.totalMoney < withdraw){
			System.out.println("이체할 수 없습니다.");
		}else{
			System.out.println("출금한 금액은 =>"+withdraw+"원 입니다.");
			this.withdraw += withdraw;
			this.totalMoney -= withdraw;
		}
			
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int interest) { //잔액에서 이자 플러스
		this.totalMoney += interest;
	}
	
}