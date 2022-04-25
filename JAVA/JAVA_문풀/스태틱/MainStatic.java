package 스태틱;

public class MainStatic {

	public static void main(String[] args) {
		 Chef c =  Chef.getInstance(); // 인스턴스화가 된 메소드를 스태틱으로 공유함
		 //  ==  Chef c = new Chef2();
		 c.printHello();
	}
}
