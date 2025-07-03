
public class Fourth {

	public static void main(String[] args) {
		byte by = 1;
		short sh = 2;
		int i = 45;
		long lng = 450L;
		
		float fl = 3.1f;
		double dbl = 3.5;
		
		boolean bool = true;
		
		// 문자형 (정수범주에 포함)
		// 'a' ==> 97 
		char ch = 'a'; // 유니코드(2byte)  --> 97
		System.out.println(ch);
		
		ch = (char)(ch - ' ');   // 97 - 32 = 65 
		System.out.println(ch);
		
		// short(음수o), char(음수x) 

	}

}
