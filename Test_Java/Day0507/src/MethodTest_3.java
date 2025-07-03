// Call By Value
public class MethodTest_3 {

	public static void main(String[] args) {
		int a = 10, b = 20;
		
		System.out.printf("a = %d, b = %d%n", a, b);
		exchange(a, b);
		
	}
	
	public static void exchange(int a, int b) {		// 위 int a = 10, b = 20과 다른 a, b임
		int temp;
		temp = a;
		a = b;
		b = temp;
	}
	
}
