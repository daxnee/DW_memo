1. 입력한 숫자가 100이 넘지 않고, 2의 배수인지 3의 배수인지 출력
```java   
    int num = 50;
		if(num < 100 && (num%2) == 0) {
			System.out.println("2의 배수입니다.");
		}
		if(num < 100 && (num%3) == 0) {
			System.out.println("3의 배수입니다");
		}




2. 학점계산 (90점 초과 A, 80점 초과 B, 그 미만은 C)
    int score = 89;
		if(score > 90) {
		System.out.println("A");
			}
		else if(score < 90 && score > 80) {
			System.out.println("B");
		
        } else {
			System.out.println("c");
		}