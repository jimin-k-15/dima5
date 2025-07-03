package exam;

public class MyCircle {
	private int x;
	private int y;
	private double radius;
	
	// 기본생성자, 오버로딩된 생성자
	
	public MyCircle() {}
	
	public MyCircle(int x, int y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	// setter, getter, toString()
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "MyCircle [x=" + x + ", y=" + y + ", radius=" + radius + "]";
	}
}
