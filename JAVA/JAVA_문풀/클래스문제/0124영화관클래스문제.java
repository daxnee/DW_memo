```java  
    package study;

    public class UserVO {
    private int age;
    private String name;
    private String nickName;
    private String addr;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    }

    ---

    package study;

    public class User {
	private int count;
	
	public boolean setUser(UserVO vo) {
		System.out.println(vo.getNickName());
		return true;
	}
	
	public int getUserCount() {
		return 0;
	}
	
	public int updateUser(UserVO vo) {
		return 0;
	}
	
	public int deleteUser(UserVO vo) {
		return 0;
	}
	
	public UserVO getUser(int x) {
		return null;
		//리턴타입에 클래스 타입이 왔을때 초기값은 null을 넣어준다.
	}
	
    }

---

    package study;

    public class UserCall {

	public static void main(String[] args) {
		User u = new User();
		UserVO vo = new UserVO();
		vo.setAge(28);
		vo.setName("양다은");
		vo.setNickName("다니");
		int 나이 = vo.getAge();
		String 주소 = vo.getAddr();
		String 별명 = vo.getName();
		String 이름 = vo.getNickName();
		System.out.println(나이);
		System.out.println(주소);
		System.out.println(이름);
		System.out.println(별명);

		//결과 : 28/ 대전 중구 사정동 /양다은 / 다니
	}

    }

	//u.setUser(vo);
	//User클래스의 setUser메소드에 UserVO의 데이터를 대입
    //	User클래스의 메소드 이름이 setUser인 메소드를 불러옴
    //	만약 위에 출력이 없다면 u.setUser(vo); 메소드 안의 함수들이 출력됨
    //	이유 : User클래스의 메소드이름이 setUser인 메소드안에
    //	출력데이터들이 있기 때문에

