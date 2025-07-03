import java.util.Scanner;

public class MethodTest_2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String choice;	// 문자열로 입력받는 이유? 에러를 덜 나게 하기 위해
		
		while(true) {
			menu(); 
			choice = keyin.next();
			
			switch(choice) {
			case "1": 
				regist();
				System.out.println("등록메뉴 선택함"); break;
			case "2": 
				retrieve();
				System.out.println("조회메뉴 선택함"); break;
			case "3": 
				delete();
				System.out.println("탈퇴메뉴 선택함"); break;
			case "4": 
				update();
				System.out.println("수정메뉴 선택함"); break;
			case "0": 
				System.out.println("** 프로그램을 종료합니다."); 
				keyin.close();
				System.exit(0);
			default :
				System.out.println("err> 메뉴선택을 다시 하세요");
			}
		}

	}
	public static void regist() {
		System.out.println("등록메뉴 선택함");
	}
	
	public static void retrieve() {
		System.out.println("조회메뉴 선택함");
	}
	
	public static void delete() {
		System.out.println("탈퇴메뉴 선택함");
	}
	
	public static void update() {
		System.out.println("수정메뉴 선택함");
	}
	
	
	public static void menu() {
		System.out.println("==== [ 회원 관리 ] ====");
		System.out.println("     1) 회원 등록");
		System.out.println("     2) 회원 조회");
		System.out.println("     3) 회원 탈퇴");
		System.out.println("     4) 회원정보 수정");
		System.out.println("     0) 종료");
		System.out.println("   선택하시오: ");
	}
	
		// 지역변수는 메모리에서 사라짐
	
	

}
