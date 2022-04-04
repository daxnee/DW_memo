### 1. 별찍기
```java 
    for(int i=0; i<6; i++) {
		for(int j=1; j<=i; j++) {
			System.out.print("*");
			}
		System.out.println();
	}			

    입출력 값 : 
    *
    **
    ***
    ****
    *****
 ```   
### 2.반대로 별찍기
```java	
	for(int i=5; i>=1; --i) {
        	for(int j=1; j<=i; j++) {
            		System.out.print("*");
        	}
        System.out.println();
    	}
	
	입출력 값 :
	*****
	****
	***
	**
	*

	대체 왜 역으로 사고가 안 되는지...?ㅠ 애꿎은 j만 만지작거림..
	int i=5; i>=1; --1 : 입출력 값의 행이 몇 행인지
	j<=i : syso(*)를 몇 회 실행하는지
	이중 for문의 첫번째 for문은 한 번씩 실행하고
	다음 for문으로 넘어간다는 사실 간과하지 않기
```
