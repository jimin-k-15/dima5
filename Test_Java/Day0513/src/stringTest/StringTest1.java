package stringTest;

public class StringTest1 {

	public static void main(String[] args) {
		String str = "abcdefg";
		
		System.out.println("글자개수: " + str.length());
		System.out.println("부분문자열: " + str.substring(3));
		System.out.println("부분문자열: " + str.substring(3, 6));
		System.out.println("첫번째 글자 1개: " + (int)str.charAt(0));
		
		System.out.println();
		
		String juminId = "081225-3012345";
		
		if(juminId.length() != 14) {
			System.out.println("1. 잘못된 주민번호입니다.");
			System.exit(0);
		}
		
		// 주민번호 가운데 -로 되어있는지 체크
		if(juminId.charAt(6) != '-') {
			System.out.println("2. 잘못된 주민번호입니다.");
			System.exit(0);
		}
		
		for(int i=0; i<juminId.length(); ++i) {
			if(i == 6) continue; 
			char ch = juminId.charAt(i);
			if(ch >= '0' && ch <= '9') {
				System.out.println("3. 잘못된 주민번호입니다.");
				System.exit(0);
			}
		}
		
		System.out.println("6자리 외에는 전부 숫자군요!");
		
		String temp = juminId.substring(7, 8);
		String gender = (temp.equals("1") || temp.equals("3"))? "남자" : "여자" ;
		
		System.out.println(gender);
		
		String tmp = (temp.equals("1") || temp.equals("2")) ? "19" : "20";
		
		String birthYear = tmp + juminId.substring(0, 2);
		System.out.println(birthYear + "년생");		// 1908년생
	}

}
