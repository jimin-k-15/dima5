package ui;

import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import vo.User;

public class UserUI {
	UserDAO dao = new UserDAOImpl();
	Scanner keyin = new Scanner(System.in);
	
	public UserUI() {
		String choice;
		
		while(true) {
			mainMenu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : create(); break;		// I
			case "2" : retrieve(); break;		// R
			case "0" : System.out.println("* 프로그램을 종료합니다."); return;
			default : System.out.println("## 메뉴를 다시 선택 ");
			}
		}
		
	}
	
	// 회원 정보 등록
	private void create() {
		System.out.println("   [ 회원 정보 등록 ] ");
		User user;
		
		String id, name, gender, tel, address;
		System.out.print("> 아이디: ");
		id = keyin.next();
		
		System.out.print("> 이 름: ");
		name = keyin.next();
		
		System.out.print("> 성 별(남:M / 여:F) : ");
		gender = keyin.next();
		
		user = new User();
		user.setId(id);
		user.setName(name);
		user.setGender(gender.toUpperCase());
		
		System.out.print("\n** 추가정보를 입력하실래요? (y/n)");
		String answer = keyin.next();
		
		if(answer.equalsIgnoreCase("y")) {
			System.out.print("> 전화번호: ");
			tel = keyin.next();
			
			System.out.print("> 주 소 : ");
			address = keyin.next();
			
			user.setTel(tel);
			user.setAddress(address);
		}
		
		int result = dao.insert(user);
		System.out.println((result == 1)? "데이터 저장 완료" : "저장 실패");
	}

	// 전체 회원 조회
	private void retrieve() {
		System.out.println("   [ 전체 회원 조회 ] ");
		List<User> list = dao.selectAll();
	
		if(list.size() == 0) {
			System.out.println("등록된 회원이 없습니다.");
			return;
		}
		
		list.forEach((user) -> System.out.println(user));
		
	}

	// 메인 메뉴
	private void mainMenu() {
		System.out.println("  [ 회원관리 ] ");
		System.out.println(" 1. 회원 정보 등록");
		System.out.println(" 2. 전체 회원 조회");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("   ** 메뉴 선택 : ");
		
	}
	
}
