package test;

class eed{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


public class 긴급점검4 {
	public static eed call() {
		eed e =  new eed();
		e.setName("아메리카노");
		return e;
	}

	public static void main(String[] args) {
		String s = call().getName();
		System.out.println(s);
	}
}
