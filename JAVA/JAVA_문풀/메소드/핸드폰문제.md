1. 핸드폰 번호 뒷자리만 남기고 *로 바꾸기
```java  
    public static String solution(String phone_number) {
		String answer = "";
		int EXCEPTION_COUNT = 4;
		int phoneNumberLen = phone_number.length();
		int temp = phoneNumberLen - EXCEPTION_COUNT;
		String fristAndSecondPhoneNumber = phone_number.substring(0,temp);
		String lastSecondPhoneNumber = phone_number.substring(temp, phoneNumberLen);
		String star = "";
		for(int i=0; i<fristAndSecondPhoneNumber.length(); i++) {
			star += "*";
		}
		answer = star + lastSecondPhoneNumber;
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		String phone = "01099993333";
		solution(phone);
	}

    출력값 : *******3333