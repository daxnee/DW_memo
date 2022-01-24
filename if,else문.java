
<if로 학점 계산하기>
public static void main(String[] args) {
		int myscore = 90;
		{
			System.out.println("A학점입니다.");
		}
		if (myscore < 90 && myscore >= 80) {
			System.out.println("B학점입니다.");
		}
		if (myscore <= 75 && myscore >= 70) {
			System.out.println("C학점입니다.");
		}
	}


<if, else>
public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int num = 0;
		if (x == y) {
			num = x * y; // num 100
			if (x != y) { // => if조건 안 맞음(넘어감)
				num = 0;
			} else {
				num += num;
			}
			num = num + 100; // 300
			System.out.println(num);
		}
	}



<삼항 연산자>(실무에서 많이 쓰임)
		public static void main(String[] args) {
		int 변수 = 0;
		int 손흥민 = (10 > 4) ? 10 : 30;
		System.out.println(손흥민);
	}
}
//		? 기준으로 왼쪽 조건이 맞으면 10 거짓이면 30이 나옴
//		변수 = (회원이 로그인했는데 연산자) ? home : login
//		로그인했으면 home 로그인 안됐으면 login


<과목 총점, 평균 계산>	
public static void main(String[] args) {
		int 국어 = 100;
		int 수학 = 50;
		int 영어 = 88;
		int 과학 = 38;
		final int 과목수 = 4; // final = 상수(변하지 않는 값)
		int sum = 0; // 총합
		double avg = 0; // 평균


		sum = 국어 + 수학 + 영어 + 과학;
		avg = sum / 과목수;


		System.out.println("총합 : " + sum + "입니다");
		System.out.println("평균 : " + avg + "입니다");

	}
