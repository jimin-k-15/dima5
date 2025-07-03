/*
 * 변수를 선언하고 값을 저장한 후 연산
 */
public class Third {
	public static void main(String[] args) {
		// 메소드 내부에 선언된 변수 : 지역변수(Local Variable)
		// 선언 후 초기화한 다음 사용해야 한다. 
		byte by = -128;
		System.out.println(by);
		
		short sh = 45;
		// sh = sh * 2;
		
		// promotion이 일어남: 연산할 때 타입이 안 맞으면 타입을 맞추는 동작 
		// 큰 타입으로 맞추려는 동작 
		// byte + int = int + int => int ==> 작은 변수에 큰 값을 넣으려는 동작   
		// by = by + 1;    // 연산을 할 때에는 int, double 기본으로 사용
		
		// 0000 0000 0000 0000 0000 0000 0000 1010 
		int age = 10;     // 2진수로 변경되어 저장된다. 
		
		double area = 5 * 5 * 3.14;
		
		//   1111 1111 1111 1111 1111 1111 1111 1111 : 정수 -1이 2진수로 바뀐 모습
		//   0000 0000 0000 0000 0000 0000 0000 0001 
		// 1 0000 0000 0000 0000 0000 0000 0000 0000 : overflow 발생 
		
		int temp = -2147383648;
		System.out.println(temp);
		
		temp = temp - 1;
		System.out.println(temp);
		
		// 정수를 2의 보수표현법을 사용하기 때문이다! 
		// 0111 1111 1111 1111 1111 1111 1111 1111
		// 0000 0000 0000 0000 0000 0000 0000 0001
		// 1000 0000 0000 0000 0000 0000 0000 0000 // 음수로 표현할 수 있는 가장 작은 값 
		// temp = 가장 큰 값 + 1; ==> 가장 작은 값 
		//        가장 작은 값 - 1; ==> 가장 큰 값
		
		// 정수는 0이 한 개임 (0)
		// 실수는 0이 두 개임 (0.0, -0.0)
		// IEEE 754 
		// 실수값은 메모리에 저장될 때 부호, 지수, 가수로 쪼개져서 저장됨
		// -0.01*2^-12 =(float point)=> -1 * 2^-11 ==> -, 1 -11
		double dbl = 45 / -0.0;  // 무한수
		System.out.println(dbl);  
		
		System.out.println(0.1 + 0.3);
		
		double a = 0.1;
		double b = 0.2;   // 10진수 ==> 2진수 ==> 오차 ==> float  < double 
		double c = a + b;
		System.out.println(a+", " + b +", " + c);
		System.out.println(c == 0.3);   // false가 나올 확률이 매우 높음 
	}
}
