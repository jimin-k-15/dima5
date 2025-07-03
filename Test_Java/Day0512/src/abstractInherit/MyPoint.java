package abstractInherit;

public abstract class MyPoint {
	int x;
	int y;
	
	public MyPoint() {
		// TODO Auto-generated constructor stub
	}
	public MyPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public abstract double area() ;		// abstract 메소드를 가지고 있는 클래스는 자기 자신이 abstract이 됨. 
										// abstract을 상속받으면 반드시 abstract 메소드를 override해야 함.
	// final과 abstract은 절대 같이 쓸 수 없음
	
}
