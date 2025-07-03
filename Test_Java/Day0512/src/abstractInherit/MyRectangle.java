package abstractInherit;

public class MyRectangle extends MyPoint {
	double width;
	double height;
	
	public MyRectangle() {}

	public MyRectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}



	public MyRectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}


	@Override
	public double area() {
		return this.height * this.width;
	}

}
