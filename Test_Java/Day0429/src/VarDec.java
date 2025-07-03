
public class VarDec {

	public static void main(String[] args) {
		byte b = 125; 
		short s = 300;
		int i = 14556, j = 500;
		long l = 350L; 
		
		char c = '^';
		
		float f = 1.5F;
		double d = 35.8;
		
		// 참조형
		String str = "Korea";
		
		System.out.printf("%d, %c, %.2f, %s, %.2f%%\n", i, c, d, str, f);
		System.out.printf("%,d, %5c, %.2f, %s, %.2f%%\n", i, c, d, str, f);
		System.out.println(str.toUpperCase());
	}

}
