package ch06;

class Person {
	String name;
	int age;
	
	Person() {
		this("이름 없음", 1);
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}


public class CallAnotherConst {

	public static void main(String[] args) {
		Person noName = new Person();
		System.out.println(noName.name);
		System.out.println(noName.age);

	}

}
