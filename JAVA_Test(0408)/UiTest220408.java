package test;

class User{
	//�ʵ庯��
	String userId;
	String password;
	String rePassword;
	boolean isLogin;
	//������
	public User(String userId, String password, String rePassword, boolean isLogin){
		this.userId = userId;
		this.password = password;
		this.rePassword = rePassword;
		this.isLogin = isLogin;
	}
}
// test ��Ű�� ���� ��  UiTest220408 Ŭ���� ������ ��!
public class UiTest220408 {
	
	public static void main(String[] args) {
		String userId = "daxnee";
		String password = "123";
		String rePassword = "123";
		boolean isLogin = false;
		//1.userId�� ���̵� ������ ���� (���̵�� 20���� ����)
		 if(userId.length() > 20) {
			 System.out.println("id�� 20���� ���Ϸ� �������ּ���");
		 }
		 
		 //2.��й�ȣ�� ���й�ȣ ������ ���� (��й�ȣ ���ڴ� 15���� ����)
		 if(password.length() > 15 && rePassword.length() > 15) {
			 System.out.println("��й�ȣ�� 15���� ���Ϸ� �������ּ���!");
		 }
		//3.��й�ȣ�� ���й�ȣ ��ġ �ϸ� isLogin�� true ����
			 if(password.equals(rePassword)) {
				 isLogin = true;
			 }
		 
		//4.1~3�� �����ϸ� UserŬ���� ȣ��, ������ �Ķ���Ϳ� �� ����.
			 if(isLogin) {
			 User user =  new User(userId, password, rePassword, isLogin);
			 System.out.println("ID : " + userId );
			 System.out.println("PASSWORD : " + password);
			 }
	}
}

