
public class MethodTest_5 {

	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}, {5, 6}};
		methodA(a);
		
		String[] s = {"ab", "cd", "ef"};
		methodS(s);
		
		
		// methodB()를 호출해서 반환값을 받으시오!
		double result = methodB();
		
		// [문제] methodC()를 호출하고 결과값을 받아 출력하는 완성 코드 작성
		double[] d = {1.5, 3.2, 1, 10.0, 15.2};
		result = methodC(d);
		System.out.println("결과: " + result);
		
		// [문제] methodD()를 호출하고 반환되는 결과값을 받는 코드 작성
		int[] b = methodD(10);
		
		methodE();
		
	}
	
	public static void methodA(int[][] a) {
	
	}
	
	public static void methodS(String[] s) {
		
	}
	
	public static double methodB() {
		return 4.5; 
	}
	
	public static double methodC(double[] d) {
		double total = 0;
		for(int i=0; i<d.length; ++i) {
			total += d[i]; 
		}
		
		return total / d.length;
		
	}
	
	public static int[] methodD(int size) {
		int[] a = new int[size];
		// 배열에 값을 초기화합니다. (생략) 
		
		return a; 
	}
	
	public static void methodE() {
		// 출력문 같은 것들!!! 
		// 멤버에 접근하는 것들...
	}

}
