package exceptTest;

public class ExceptionTest_01 {

	public static void main(String[] args) {
		String[] str = {"a", "12", "", "0"};
		
		try {
			// String data = str[str.length]; 	    // ArrayIndexOutOfBoundsException : 인덱스의 위치가 잘못됨 
			
			int a = Integer.parseInt(str[1]);
			// int b = Integer.parseInt(str[0]);	// NumberFormatException : 문자열을 정수로 바꾸려고 함
			int c = Integer.parseInt(str[3]);
			
			int result = a / c;		 				// ArithmeticException 
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();					// 어디서 오류가 났는지 알 수 있음
			// System.out.println(e.getMessage());
		} catch(NumberFormatException e) {
			e.printStackTrace();					
			// System.out.println(e.getMessage()); 
		} catch(ArithmeticException e) {
			e.printStackTrace();			
			System.exit(0);		// finally에 들르지 못한다!
			return;				// finally에 들러서 실행시킨 후 종료. 고로 reutrn이 더 나음.
			// System.out.println(e.getMessage()); 
		} catch (Exception e) {			// 이것만 있어도 위의 것들 없이 처리할 수 있지만. 위처럼 디테일하게 잡는 게 좋음. **맨 밑에 써야 함**
			e.printStackTrace();
		} finally {
			// 리소스 정리 코드
			System.out.println("finally");
		}
		
		System.out.println("끝");
	}

}
