import java.time.LocalDate;
import java.util.Scanner;

public class JuminValidation {
	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String juminId = null;
		String gender = null, year, month, day;
		
//		System.out.print("주민번호 입력: ");
//		juminId = keyin.next();

		juminId = "341223-1234566";
		
		// 각종 값 체크 + 숫자로 이뤄졌는지 체크 + 검증코드도 체크
		boolean result = isValid(juminId) && isNumeric(juminId) && codeCheck(juminId);
		if(!result ) {
			System.out.println("잘못된 주민번호입니다.");
			return;
		}
		
		// 나이를 구하는 코드를 LocalDate를 이용해서 구하시오.
		// 2025년 5 14 - 1990년 5 7 => 34
		
		int age = 0;
		int birthYear = Integer.parseInt(birthyear(juminId));
		int birthMonth = Integer.parseInt(juminId.substring(2, 4));
		int birthDay = Integer.parseInt(juminId.substring(4, 6));
		
		LocalDate today = LocalDate.now();
		int currYear = today.getYear();			// 연도
		int currMonth = today.getMonthValue();  // 월
		int currDay = today.getDayOfMonth();	// 일
		
		age = currYear - birthYear;
		age -= (birthMonth < currMonth) ? 1 : 0;  // 삼항연산자 // 아직 수정 안 했음
		
		// 추가
		
		
		System.out.printf("당신은 %s년 %s월 %s일생 %s입니다.%n", 
				birthyear(juminId), 
				juminId.substring(2, 4), 
				juminId.substring(4, 6),
				genderCheck(juminId));

	}
	
	// 001223-1234567
	private static boolean isValid(String id) {
		// 길이 체크
		if(id.length() != 14) return false;
		// '-' 체크
		if(id.charAt(6) != '-') return false;
		// 성별 체크
		char tmp = id.charAt(7);
		if(!(tmp >= '1' && tmp <= '4')) return false;
		
		return true;
	}
	
	
	// 341223-1234567
	private static String birthyear(String id) {
		String year = id.substring(0, 2);
		
		// 성별 체크
		char tmp = id.charAt(7);
		if(tmp == '1' || tmp == '2') year = "19" + year;
		else 						 year = "20" + year; 
		
		return year;
	}
	
	
	
	private static String genderCheck(String id) {
		String gender = null;
		// 성별 체크
		char tmp = id.charAt(7);
		if(tmp == '1' || tmp == '3') gender = "남성";
		else 						 gender = "여성"; 
		
		return gender;
	}
	

	private static boolean isNumeric(String id) {
		for(int i=0; i<id.length(); ++i) {
			if(i == 6) continue;
			if(!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) return false;
		}
		
		return true;
	}
	
	// 341223-1234567
	private static boolean codeCheck(String id) {
		String s = null;
		int value = 2;
		int total = 0;
		int ch = 0;
		for(int i = 0 ; i < id.length()-1 ; ++i) {
			if(i == 6) continue;
//			'1' - '0' = 1
//			51 - 50   = 1
			System.out.println(id.charAt(i) - '0');  // 51 - 50 ==> 1 ==> 
			
			
//			s = id.substring(i, i+1);
			ch = id.charAt(i) - '0';
			
//			total += Integer.parseInt(s) * value; 
			total += ch * value;
			++value;
			if(value > 9) value = 2;
		}
		// 체크 코드를 구함
		int check = 11 - ( total % 11 );
		
		// 10 이상인 경우 연산을 한 번 더! 
		if(check > 9) check = check % 10;
		
		// 주민번호 마지막 자리를 가져와서 숫자로 변경 후 체크값과 비교
		if(check == Integer.parseInt(id.substring(id.length()-1))) return true;
		
		return false;

	}
	
}
