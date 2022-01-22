##<if로 학점 계산하기>
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

##<if, else 계산식>
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