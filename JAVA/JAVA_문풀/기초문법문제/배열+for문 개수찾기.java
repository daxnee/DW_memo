1. 1부터 10까지 짝수, 홀수 판단.


  	for(int i=0; i<=10; i++) {
			if(i%2 == 0) {
				System.out.println("짝수는 : " + i);
			}
			if(i%2 != 0) {
				System.out.println("홀수는 : " + i);
			}
		}
	}

결과 : 4


2. 1부터 100까지 짝수 개수 구하기.

	int count = 0;
	int count2 = 0;
	for(int i=0; i<=10; i++) {
		if(i%2 == 0) {
				count++;
		}
		if(i%2 != 0) {
			count2++;
		}
		}
		System.out.println("짝수는 : " + count);
		System.out.println("홀수는 : " + count2);
		


3. 배열을 선언하고 100이 넘는 개수가 몇개인지 찾으시오.


    public static void main(String[] args) {
		   int count = 0;
		   int array[] = {101, 110, 120, 130, 88, 30};
		   int len = array.length;
		   for(int i=0; i<len; i++) {
			   if(array[i] >= 100) {
				   count++;
			   }
		   }			
		   System.out.println(count);
	}

4. 1부터 10까지 더한값 구하기 

		int sum = 0;
		for(int i=0; i<=10; i++) {
			sum += i;
		}
		System.out.println(sum);
			
				