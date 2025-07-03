package justpractice;

class Animal {
	public void cry() {
		System.out.println("동물이 짖는다.");
	}
}

class Dog extends Animal {
	@Override
	public void cry() {
		System.out.println("멍멍!");
	}
}

public class OverridingTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.cry();
	}
}
