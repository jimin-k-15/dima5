package wrapperTest;

public class WrapperTest_01 {

	public static void main(String[] args) {
		// auto boxing : 자동으로 값이 객체로 변환됨 (jdk 1.5버전의 기능)
		Integer it1 = 15;	// 레퍼런스 변수 = 주소 ===> 변수 = 객체
		Integer it2 = 22;
		
		// auto unboxing , auto boxing
		Integer result = it1 + it2;	// 주소 연산이 아님(값 연산). 
									// Wrapper 타입의 객체로 연산을 하면, 각 변수가 가리키는 곳에 있는 값끼리 연산됨.
		System.out.println(result);
		
		// 객체로 만드는 것은 auto boxing, 객체가 가리키는 값을 꺼내서 작업하는 것은 auto unboxing 
		
		System.out.println(Integer.SIZE);		// 32 : Integer의 비트 수
		System.out.println(Integer.MAX_VALUE);	// 2147483647 : Integer 안에 넣을 수 있는 가장 큰 값
		System.out.println(Integer.MIN_VALUE);	// -2147483647 : Integer 안에 넣을 수 있는 가장 작은 값
		
		Double dbl1 = 45.195;
		System.out.println(Double.SIZE);	
		System.out.println(Double.MAX_VALUE);	
		System.out.println(Double.MIN_VALUE);
		
		String str = "15.954";
		double data = Double.parseDouble(str);
		
		int maxValue = Integer.MAX_VALUE;
		
		maxValue = maxValue + 1;	// 최대값에 1을 더하면 최소값으로 변경 (Overflow)
		System.out.println(maxValue); 
		
	}

}
