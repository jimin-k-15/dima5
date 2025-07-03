package abstractInherit;

public class MyCircle extends MyPoint {
	double radius;
	
	public MyCircle() {
		super();
	}

	public MyCircle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	@Override
	public double area() {
		return this.radius * this.radius * Math.PI;
	}

	
	
	
}
