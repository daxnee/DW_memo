## Class 정리
- 클래스는 객체(== Object)다.

```java
		Public class Pizza{ 
		//피자 클래스에는
		//피자에 관련된 변수와 함수만 위치한다.
		//클래스는 '피자'에 관련된 '필드(전역)변수'와 '메소드'로만 구성
		int 햄;
		String 피자이름;

		public void 도우를 만들다(){
		      //  코드...
    	}


		}
		public static void main(String[] args) {	
		//조건) 클래스와 메소드를 실행해서 결과 값을 보고 싶을때 자바는 메인함수만 알기 때문에
		//'외부 클래스파일'을 불러올 때 메인함수에서 실행해야함!
		//'메소드'도 메인함수에서 불러와야함
		}
		
```



## 중급 문제풀이
```java
	1. public static int getSum(int start, int end){
        int array[] = {3,8,9};
        int max = 0;
        if(start < 0) {
        	if (end == array.length);{
        	if (max > 10);
        	return 0;
        }
        }
        
        for(int i=start; i<end; i++){
        		if(max < array[i] );{
        			max = array[i];
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


}






2.public static int[] getResult(int[] array){
	        int temp = 0;
	        for(int i=0; i<array.length; i++) {
	        		if((array[i]%2) == 0) {
	        		 array[i] = 0;
	        		
	        		}
	        		return array;
	        }
	        return array;
		
	    }

	    public static void main(String[] args) {
	        int array[] = {120, 340, 200, 430, 33};
	        int result[] = getResult(array);
	        for(int i : result){
	            System.out.print(i+", ");
	            
	            
	        }
	    }

}

3.
	 int max = 0;
		 for(int i=0; i<array.length; i++) {
	    	String result = array[i].replace("!", "");
	    	 String replaceStr = result.replace("$","");
	    	 int temp = Integer.parseInt(replaceStr);
	    	 if(temp <= 200) {
	    		 return 100;
	    	 }
			 if(temp >= 200) {
				 return 200;
			 }
		 }
		 return max;
	 }
	      
	    public static void main(String[] args) {
	        String array[] = {"100","1!30","11$0","200"};
	        int result = getResult(array);
	        System.out.println(result);
	    }

	
}

4. public static int calcPage(int totalCount, int rows) {
        int totalPage = 0;
        if(totalCount <= 100) {
        	totalPage = totalCount / rows;
        	if((totalCount % rows) > 0) {
        		++totalPage;
        	}
        }

		return totalPage;    
    }
	
    public static void main(String[] args) {
        int totalCount = 58; //총 인원값
        int rows = 10; //1페이지에 작성할 수 있는 기준값
        int pages = calcPage(totalCount, rows);
        System.out.println(pages+" 페이지");
    }


