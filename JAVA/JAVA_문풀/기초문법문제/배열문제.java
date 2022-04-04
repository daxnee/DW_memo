1. 배열안에 있는 모든 인덱스값 더하기
    
	int array[] = {2,4,6,9};
	int sum = 0;
	for(int i = 0; i < array.length; i++) {
	 sum = sum + array[i];
	}
	System.out.println(sum);



2. 아래 배열을 선언하고, 3의배수 개수를 찾아내시오.
 
		int count = 0; 
		int array[] = {3,6,9,10,1};
		for(int i = 0; i < array.length; i++) {
			if((array[i]%3) == 0) {
				count++;
			}
		}
		System.out.println(count + "개");

    출력값 : 3개



3. 배열선언후 총합과 평균값을 구하시오
 
	int sum = 0;
		int array[] = { 80, 90, 100, 70, 50 };
		int len = array.length;
		for (int i = 0; i < len; i++) {
			sum = sum + array[i];
		}
		System.out.println(sum);
		System.out.println(sum / len);
	


4. 최소값 구하기


public static void main(String[] args) {
		int array[]  = {8,7,5,4,10,6};
		int min = array[0];
		 int len = array.length;
			for(int i=0; i<len; i++) {
				if(min > array[i]) { 
				min = array[i] ;
				}
			}
			System.out.println(min);
		
	}




5. 최대값 구하기


public static void main(String[] args) {
		int max = 0;
		int array[]  = {8,7,5,4,10,6};
		int min = array[0];
		 int len = array.length;
			for(int i=0; i<len; i++) {
				if(max > array[i]) { 
				max = array[i] ;
				}
			}
			System.out.println(max);
	}






6. 아래 배열을 선언하고, 짝수를 0으로 수정하시오.

int array[] = {2,4,6,8,10};
		int len = array.length;
		int temp = 0;
		for (int i = 0; i < len; i++) {
			if ((array[i]%2) == 0) {
				array[i] = 0;
				System.out.print(array[i]+ " ");
			}
		}

    출력값 : 0 0 0 0 0 


7. 아래 배열을 선언하고 정렬하시오. (실무에서 사용하는 코드)
	  
    int array05[] = {5,11,2,0,7};
	Arrays.sort(array05);//정렬 한줄로 끝!
	for(int i : array05){
	 System.out.print(i+", ");
		}

