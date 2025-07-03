/*
 * 상속했을 때
 *  - extends 부모클래스명
 * 	- final 선언된 클래스는 상속 안 됨 (String, Math)
 *  - private 멤버, 생성자도 상속 안 됨
 *  - this, this(), super, super() - this객체, this생성자, super객체, super생성자
 * 	- override : final로 선언된 메소드는 오버라이드 불가능
 * 	- 다중상속 불가능(기본값)
 * 	- abstract 클래스 : 상속 전용 클래스, 하위클래스가 추상클래스를 상속받으면 
 * 						부모가 물려준 추상메소드를 반드시!!! 오버라이드 해야 객체 생성이 가능
 * 
 * 	- 캐스팅
 * 	  상향 캐스팅, 하향 캐스팅
 * 
 * 	- instanceof 연산자
 * 
 */
package inherit;

class Parent {
	String name;
	
	public void output() {
		System.out.println("Parent: name=" + name);
	}
}

class Child extends Parent {
	String phone;
	
	public void output() {
		System.out.println("Child: phone=" + phone);
	}
}

class Son extends Parent {
	int age;
	
	public void output() {
		System.out.println("Son: age=" + age);
	}
}


// Main을 가진 클래스
public class InheritTest {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.name = "수퍼클래스";
		p.output();
		
		Child c = new Child();
		c.phone = "010";
		c.output();
		
		// 다형성: 수퍼클래스의 참조변수가 서브클래스의 객체를 참조하는 것!
		Parent p1 = new Child();		// 상향 캐스팅: 다형성을 처리하기 위해서는 기본적으로 상향캐스팅을 해야 함
		
		// instanceof 연산자: t/f
		System.out.println(p1 instanceof Child); 		// t
		// System.out.println(p1 instanceof String); 	// 관계없는 클래스의 instanceof는 불가능
		System.out.println(p1 instanceof Parent);		// t
			
		System.out.println(p1 instanceof Son);			// f
		
		// =============================
		// [문제] p1을 통해서 name: "삼장법사", phone에는 "1234"를 대입해 보시오. 
		p1.name = "삼장법사";
		((Child)p1).phone = "1234";
		
		System.out.println(p1.name);		
		
		// 하향 캐스팅: 부모의 참조변수를 이용해 자식의 멤버에 접근
		
		System.out.println(((Child)p1).phone);	// 괄호 유의! ((Child)p1).phone
		
		p1.output();	// 어떤 output을 호출할까? ==> 자식
		// 부모의 output을 호출해보시오. 
		// ==> 안 됨! 외부클래스에서 p1은 자식클래스를 가리키는 레퍼런스이므로 
		// 자식의 output이 부모의 output을 덮어쓴 것
		
		Object obj = new Parent();
		System.out.println(obj instanceof Parent);
		
		Object obj2 = new Child();
		System.out.println(obj2 instanceof Child);
		
		Object obj3 = new String();
		System.out.println(obj3 instanceof String);
	}

	// @Override // JVM으로 하여금 오버라이드가 제대로 되었는지 검증하도록 하는 annotation
	
}
