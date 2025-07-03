/* [연습] 주어진 문자열 배열의 데이터를 이용해 합계와 평균을 구하는 프로그램을 작성하시오. 
 * 1 홍길동  85  75  98  xxxx  xx.xx
 * 2 전우치  95  88  74  xxxx  xx.xx
 * 3 손오공	 75  68  84  xxxx  xx.xx
 */
public class StringTest_02 {

	public static void main(String[] args) {
		String[] exam = {"1 홍길동 85 75 98", "2 전우치 95 88 74", "3 손오공 75 68 84"};

		System.out.println("번호  이름  점수1  점수2  점수3  합계  평균");
		System.out.println("-----------------------------------------------");
		
		for (String data : exam) {
			String[] score = data.split(" ");
			int sub1 = Integer.parseInt(score[2]);
			int sub2 = Integer.parseInt(score[3]);
			int sub3 = Integer.parseInt(score[4]);
			
			int total = sub1 + sub2 + sub3;
			double avg = total / 3.0; 
			
			System.out.printf("%2s %4s %3d %3d %3d %4d %6.2f\n",
					score[0], score[1], sub1, sub2, sub3, total, avg);
			
		}
		
		
	}

}
