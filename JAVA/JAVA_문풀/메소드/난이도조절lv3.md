## 1번 문제
문제설명
메소드 파라미터에 정수형 데이터 start와 end를 받는다.
array[]배열에서 가장 큰 수를 리턴한다.
리턴 받은 값을 리턴타입이 boolean인 isNum함수 파라미터에 넣는다.

제한사항
아래 메소드 생성
start는 0보다 클 수 없습니다.
end는 배열길이와 같아야 합니다.
max에 10보다 큰 수가 오면 0을 return 해야 합니다. 

```java
    public static boolean isNum(int max){
        final int standardVal = 10;
        if(max < standardVal){
            return true;           
        }
        return false;
    }
    public static int getSum(int start, int end){
        int array[] = {3,8,9};
        int max = 0;
        //아래부터 리턴까지 로직 구현
        end = array.length;
        if(start < 0) {
        for(int i=start; i<end; i++){
           if(max < array[i]) {
        	  max  =  array[i];
        	  if(max > 10) {
        		  return 0;
        	  }
           }
         }
      
       }
        return max;
    }
    public static void main(String[] args) {
        int start = 0;
        int end = 0;
        int max = getSum(start, end);
        boolean isFlag = isNum(max);
        System.out.print(isFlag);
    
    }

    출력값 : true


2. 메소드 파라미터에 정수형 배열을 받는다.
배열 인덱스 값중 짝수인 값은 0으로 대입한다.
단, 인덱스 값중 짝수이고 300이 넘으면 0 대입을 무시한다.
     
     public static int[] getResult(int[] array){
         //return까지 로직구현
        int len = array.length;
    	for(int i=0; i<len; i++) {
    		if((array[i]%2) == 0) {
    			if(array[i]<300) {
    				array[i] = 0;	
    			}
    		}
    	}
    	return array;
    }
    
    public static void main(String[] args) {
        int array[] = {120, 340, 200, 430, 33};
        int result[] = getResult(array);
        for(int i : result){
            System.out.print(i+", ");
       }


3. 메소드 파라미터에 문자열 배열을 받는다.
배열 인덱스값에 기호가 들어간 문자는 제거한다.
배열 인덱스값을 문자에서 숫자로 변환한다.
인덱스값 중 1번째 인덱스값이 200이하면 100을 리턴. 
200 이상이면 200을 리턴 하시오. 
		    public static int getResult(String[] array){
           int len = array.length;
		   int temp[] = {0,0,0,0};
		   for(int i=0; i<len; i++) {
			array[i] = array[i].replace("!","");
			array[i] = array[i].replace("$","");
			temp[i] = Integer.parseInt(array[i]);
		   }
		   if(temp[1]<=200){
			   return 100;
		   }
		   if(temp[1]>=200) {
			   return 200;
		   }
		  
		   return 0;
	    }
	    public static void main(String[] args) {
	        String array[] = {"100","1!30","11$0","200"};
	        int result = getResult(array);
	        System.out.println(result);