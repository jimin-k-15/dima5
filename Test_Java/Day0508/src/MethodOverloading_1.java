
public class MethodOverloading_1 {

	public static void main(String[] args) {
		System.out.println("정수 합의 결과는 : "+ add(15, 20));	

		System.out.println("실수 합의 결과는 : "+ add(15.5, 22.7));
		
		System.out.println("Float 실수 합의 결과는 : "+ add(15.5F, 22.7));	// 정확한 데이터타입이 없을 경우
																			// 이 타입을 담을 수 있는 가장 가까운 메소드 호출
																			// float이 없으면 double
		
//		System.out.println(12, 24, 17);	// 에러 : println은 전달인자가 하나여야 함
		
	}
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static void add(int a) {
		System.out.println(a + 10);		// 메소드 오버로딩이 아님 
	}

	public static double add(double a, double b) {
		return a + b;
	}
	
	public static double add(float a, float b) {
		return a + b;
	}
}
