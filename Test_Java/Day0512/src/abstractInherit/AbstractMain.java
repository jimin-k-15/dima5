package abstractInherit;

public class AbstractMain {

	public static void main(String[] args) {
	// Mypoint p = new MyPoint();	// MyPoint는 추상 클래스기 때문에 인스턴스화할 수 없음. (객체를 만들 수 없음)
		MyCircle c = new MyCircle(1, 1, 5.5);
		System.out.println(c.area());
		
		MyRectangle r = new MyRectangle(5, 6, 3, 4);
		System.out.println(r.area());
		
		// 다형성, 상속
		// 부모 타입의 레퍼런스 변수가 자식 객체를 참조
		// 호출하는 메소드가 abstract 이어야 동적 바인딩이 됨
		MyPoint p;
		
		p = new MyCircle(1, 1, 5.5);
		print(p);
//		System.out.println(p.area());	// (동적 바인딩) 원의 면적
		
		p = new MyRectangle(5, 6, 3, 4);
		print(p);
//		System.out.println(p.area());	// 사각형의 면적
		
		// -> 같은 코드임에도 불구하고 어떨 때는 원의 면적, 어떨 때는 사각형의 면적 --> 다형성

	}
	
	public static void print(MyPoint p) {
		System.out.println(p.area());	// 이걸 구현하기 위해 다형성을 배우는 것
	}
}
