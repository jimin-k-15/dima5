package justpractice;

class Parent {
	private int money = 2000;
	
	public int earning() {
		return money *= 2;
	}
	public void output() {
		System.out.println("부모 현재 자산: " + money + ", 투자 수익: " + this.earning());
	}

}

class Child extends Parent {
	private int property = 1000;
	
	public int gather() {
		return property *= 3;
	}
	public void print() {
		System.out.println("자식 자산: " + property + ", 증식 자산: " + this.gather());
	}
}

public class OOP_interitance {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.output();
		Child c = new Child();
		c.print();
		c.output();
	}

}
