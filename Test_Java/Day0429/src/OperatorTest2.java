
public class OperatorTest2 {

	public static void main(String[] args) {
		// 단항 연산자 ( ++	-- ): 1 증감시키는 연산자. 피연산자는 변수
		int a = 0;
		int b = 0;
		
		b = ++a;	// 2순위
		System.out.println(a + " / " + b);
		
		a = 0;
		b = 0;
		
		b = a++; 	// 14순위
		System.out.println(a + " / " + b);
		
		// a = a + 1;
		// a = 10 - 9;
		// 0++;        <-- ++은 반드시 피연산자가 변수여야 함. 
	}

}
