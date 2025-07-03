
public class MethodTest_1 {

	public static void main(String[] args) {
		int result = plus(10, 20);				// 메서드 호출
		
		System.out.println(result);
		
		result = minus(10, 7);
		System.out.println(result);
		
		// static 메서드 내부에서는 non-static 메서드 호출 불가!! -> 암기
		// output(); -> 에러 
	}
	
	// static 메서드 정의
	public static int plus(int a, int b) {
		return a + b;
	}
	
	public static int minus(int a, int b) {
		return a - b;
	}
	
	public static int multiply(int a, int b) {
		return a * b;
	}
	public static double divide(int a, int b) {
		return a / (double)b;	// 5 / 10 ==> 0
	}
	
	
	
	// instance 메서드 : 메서드가 포함된 클래스를 생성한 후 호출할 수 있다. (static이 안 붙으면 무조건 인스턴스) 
	public void output() { 						// void : return(반환)할 게 없는 경우 
		System.out.println("나는 출력 메서드!!");
		return;		// 그 메서드의 마지막에 있을 경우 생략 가능  }이 return 대신 
	}

}
