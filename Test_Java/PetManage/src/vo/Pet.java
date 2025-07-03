package vo;

public class Pet {
	private String name;
	private String kind;
	private int age;
	
	// 생성자: 멤버필드를 메모리에 적재시키고 초기화하는 특수한 메소드
	// 기본 생성자
	public Pet() {}
	
	// 오버로딩 생성자
	public Pet(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
	}
	
	// setter / getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String output() {
		return "이름=" + name + ", 종류=" + kind + ", 나이=" + age;
	}
	
}
