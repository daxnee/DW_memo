public class Apple {
		int count;
		
	public int getAppleCount() {
		int count = this.count;
		return count;
		// return this.count; 이것도 가능 
		}
		
	public void buyApple(int 수량) {
		System.out.println("사과를 " + count + "구매했어요");
		this.count += 수량;
		
	}
		
	public void eatApple(int 수량) {
		if(this.count >= count) {
			System.out.println("사과를 "+ count + "개 먹었어요");
			this.count -= count;
		}else {
			System.out.println("사과가 부족해요!" + count + "개 만큼 먹을 수 없어요ㅠ");
		}
	}
	
	
	
	
}
