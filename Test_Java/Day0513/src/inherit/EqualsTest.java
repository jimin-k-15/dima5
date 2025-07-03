package inherit;

class Student {
	private String name;
	private int score;
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	// 만약 name, score를 문자열로 변환해서 사용하려면 toString()을 오버라이드 해야 한다.
	
	@Override
	public String toString() {
		return super.toString() + "\n이름: " + name + ", 점수: " + score;	// super.toString()은 주소 출력을 위해 but 잘 쓰지 않음
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Student)) return false;
		
		Student std = (Student) obj;	// 다운 캐스팅: obj가 Student일 때만 다운 캐스팅 가능		
		if(name.equals(std.name) && score == std.score) return true;
		
		return false;
	}
}			

	

public class EqualsTest {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 100);
		Student s2 = new Student("전우치", 95);
		Student s3 = new Student("전우치", 95);
		Student s4 = new Student("전우치", 100);
		Student s5 = null;
		
		s2.equals(s4);	  // t
		s4.equals(s3); 	  // f
		s4.equals(null);  // f
			
		// System.out.println(s1.toString());	
		// System.out.println(); 메소드의 특이점
		// 전달인자로 객체가 전달되면 내부적으로 그 객체의 toString()을 호출하도록 설계되어 있음
		System.out.println(s3); 
		
		boolean result;
		
		result = (s1 == s2);
		System.out.println(result);
		
		result = (s2 == s3);			// 데이터가 같아도 주소는 다르다.
		System.out.println(result);		// false: 주소를 비교하는 것이기에 같지 않음
		
		// 값을 비교하도록 하고 싶다면!
		// 이름도 같고, 점수도 같아야 true가 된다!!! 
		// Object가 물려준 메소드 equals()를 오버라이드해서 사용해야 한다 !!!
		// String클래스는 이미 설계 때부터 equals()를 만들어서 제공한다. 
		// public boolean equals(Object obj); 
		String city = "서울시"; 
		result = city.equals("부산시");
		
			
	}
}
