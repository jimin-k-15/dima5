import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		Point[] p = new Point[100];
		int count = 0; 	
			
		int x, y, width, height;
		double radius;
		
		while (true) {
			int choice;
			System.out.print("1. 원		2. 사각형	 3. 전체보기	 4. 종료: ");
			choice = keyin.nextInt();
			
			switch(choice) {
			case 1: {
				System.out.print("x : "); 		x = keyin.nextInt();
				System.out.print("y : "); 		y = keyin.nextInt();
				System.out.print("radius : ");  radius = keyin.nextInt();
				Circle c = new Circle(x, y, radius);
				
				p[count] = c;
				count++;
				
				break;
			}
			
			case 2: {
				System.out.print("x : "); 		x = keyin.nextInt();
				System.out.print("y : "); 		y = keyin.nextInt();
				System.out.print("width : ");   width = keyin.nextInt();
				System.out.print("height : ");  height = keyin.nextInt();
				Rectangle d = new Rectangle(x, y, width, height);
				
				p[count] = d;
				count++;
				
				break;
			}
			case 3:
				print(p);
				break;
			
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	public static double calcArea(Point point) {
		double test = 0;
		if (point instanceof Circle) {
			test = ((Circle) point).area();
		} else if (point instanceof Rectangle) {
			test = ((Rectangle) point).area();
		}

		return test;
	}
	
	public static void print(Point[] point) {
		for (int i=0; i<point.length; ++i) {
			if (point[i] instanceof Circle) {
				System.out.println((i+1)+") 원 : " 
						+ point[i].getX() + ", " 
						+ point[i].getY() + ", " 
						+ ((Circle)point[i]).getRadius()
						+ calcArea(point[i]));
			} else if (point[i] instanceof Rectangle) {
				System.out.println("   " + (i+1)+") 사각형 : " 
						+ point[i].getX() + ", " 
						+ point[i].getY() + ", " 
						+ ((Rectangle)point[i]).getWidth() + ", " 
						+ ((Rectangle)point[i]).getHeight() + ", " 
						+ calcArea(point[i]));	
			}
		}
	}
}
