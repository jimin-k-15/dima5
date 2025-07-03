package exceptTest;

public class ExceptionTest_02 {
	public static void main(String[] args) {
		int[] myAry = new int[10];
		
		for(int i=0; i<myAry.length; ++i) {
			try {
				myAry[i] = even();
			} catch (Exception e) {
//				System.out.println(e.getMessage());
				i--;		// 언제 i를 빼야 하는지, 언제 빼지 않는지 유의
			}
		}
		
		for(int temp : myAry) {
			System.out.print(temp + " ");
		}
		System.out.println();
		
	}

	// 짝수 값을 발생시켜 반환하는 메소드
	// 홀수가 발생되면 익셉션으로 처리
	// 짝수가 발생되면 정상처리이므로 반환
	private static int even() throws  Exception {	// throw new Exception에 대응하는 메소드 signature
		int data = (int)(Math.random() * 100 + 1);
		
		if(data % 2 == 0) {
			return data;
		} else {
			// 1. 직접 처리 (try~ catch~)
//			try {
//				System.out.println("홀수 발생");
//			} catch(Exception e) {
//				return;
//			}
			// 2. 메소드를 호출한 쪽에서 처리하도록 함 ==> 예외 전가
			throw new OddException("홀수값이 발생됨");		// 메소드를 발생시켜서 던져버림
		}		
	}
}
