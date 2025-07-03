import java.util.Comparator;

public class Person implements Comparator<Person> {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.age > o2.age) return 1;
		else if(o1.age < o2.age) return -1;
		
		return 0;
	}
}
