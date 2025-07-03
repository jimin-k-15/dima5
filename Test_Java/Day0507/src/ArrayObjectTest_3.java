// 클래스 정의 <-- 사용자가 만든 클래스 (사용자 정의 클래스)
class Human {
	String name; // 멤버변수
	int age; 	 // 멤버변수
	
	// 생성자(Constructor) 메서드 -> Human이라는 클래스 객체를 생성하고, 멤버변수를 초기화하는 역할
	Human(String n, int a) {
		this.name = n;
		this.age = a;
	}
}


public class ArrayObjectTest_3 {

	public static void main(String[] args) {
		Human h1 = new Human("전우치", 25);	 // 생성자 메서드 호출
		Human h2 = new Human("손오공", 21);  
		Human h3 = new Human("사오정", 29);
		
		Human[] hAry = new Human[3]; // 객체배열 (Human 데이터타입에 대한 방 3개짜리 배열 생성)
									 // 객체배열은 주로 1차원 배열을 사용, 2차원 배열은 잘 안 만듦
		hAry[0] = h1; 
		hAry[1] = h2;
		hAry[2] = h3;
		
		Human[] hAry2 = new Human[] {
				new Human("전우치", 25),
				new Human("손오공", 21),
				new Human("사오정", 29),
		};
		
		Human[] hAry3 = {h1, h2, h3};
		
		for(Human h: hAry2)         // (타입 변수 : 배열의 이름)
			System.out.println(h);  // 해시 주소 출력 
		
		for(Human h: hAry2)
			System.out.println(h.name + " / " + h.age);  // 직접 접근 (가능하지만 객체 지향 언어에서는 권장하지 않음)
	}

}
