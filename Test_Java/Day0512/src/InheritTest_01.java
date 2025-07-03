class Parent {
	private String name;	// 외부 접근 불가 
	protected int age;		// 패키지가 다르면 외부에서 접근 불가
	
	public String output() {
		return this.name + " = " + this.age;
	}
}
// private, 부모의 생성자는 상속이 안 됨!
// public, protected, 
class Child extends Parent {
	private String addr;
	
	public void allData () {
		
	}
}



public class InheritTest_01 {

	public static void main(String[] args) {
		Parent p = new Parent();
		
		Child c = new Child();
		
		
		
		
	}

}
