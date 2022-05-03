package test;

class User{
	//필드변수
	String userId;
	String password;
	String rePassword;
	boolean isLogin;
	//생성자
	public User(String userId, String password, String rePassword, boolean isLogin){
		this.userId = userId;
		this.password = password;
		this.rePassword = rePassword;
		this.isLogin = isLogin;
	}
}
// test 패키지 생성 후  UiTest220408 클래스 생성할 것!
public class UiTest220408 {
	
	public static void main(String[] args) {
		String userId = null;
		String password = null;
		String rePassword = null;
		boolean isLogin = false;
		//1.userId에 아이디 데이터 대입 (아이디는 20글자 이하)
		//2.비밀번호와 재비밀번호 데이터 대입 (비밀번호 글자는 15글자 이하)
		//3.비밀번호와 재비밀번호 일치 하면 isLogin에 true 대입
		//4.1~3번 만족하면 User클래스 호출, 생성자 파라미터에 값 대입.
	}
}
