/*
 * [문제] 1년은 365.2422일이다. 이는 몇 일, 몇 시간, 몇 분, 몇 초인가를 출력하시오. 
 * 		 (단, 초수는 소수점 이하 둘째 자리까지 출력하시오.) 
 *
 * <실행예시> 
 * 365.2422일은 365일 5시간 48분 46.08초입니다.
 * 
 */
public class Exam01 {

	public static void main(String[] args) {
		double year = 365.2422;
		
		int day = (int) year;
		double temp = (year - day) * 24;
		
		int hour = (int) temp;
		temp = (temp - hour) * 60;
		
		int min = (int) temp;
		temp = (temp - min) * 60;
		
		double sec = temp;
		
		System.out.printf("%.4f일은 %d일 %d시간 %d분 %.2f초입니다.\n", year, day, hour, min, sec);

	}

}

// 교수님 풀이
//public class Exam02 {
//	
//	public static void main(String[] args) {
//		double oneYear = 365.2422, second, temp;
//		int day, hour, min;
//		
//		day = (int)oneYear;        // 일 추출
//		
//		temp = oneYear - day;      // 0.2422는 시간
//		hour = (int)(temp * 24);   // 5.8128시간 추출
//		
//		temp = (temp * 24) - hour; // 0.8128 시
//		min = (int)(temp * 60);    // 48.768분 추출
//		
//		temp = (temp * 60) - min; // 0.768분
//		second = temp * 60;    
//	}
//		
//		System.out.printf("%.4f일은 %d일 %d시간 %d분 %.2f초입니다.%n", oneYear, day, hour, min, second);