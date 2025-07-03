
public class Circle extends Point implements Area {
	private double radius;

	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
}
