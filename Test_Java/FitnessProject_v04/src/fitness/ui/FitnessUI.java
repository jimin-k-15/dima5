/*
 * 생성, 조회, 삭제, 수정 (Create, Retrieve, Delete, Update) ==> CRUD
 */

package fitness.ui;

import java.util.List;
import java.util.Scanner;

import fitness.service.FitnessService;
import fitness.service.FitnessServiceImpl;
import fitness.vo.FitnessVO;

public class FitnessUI {
	Scanner keyin = new Scanner(System.in);
	FitnessService service = new FitnessServiceImpl();
	
	FitnessVO fitness = null;
	
	public FitnessUI() {
		String choice;
		
		while(true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : create();   break;
			case "2" : retrieve(); break;
			case "3" : update();   break;
			case "4" : delete();   break;
			case "5" : retrieveAll();   break;
			case "0" : 
				System.out.println("## 프로그램을 종료합니다.");
				return;
			default :
				System.out.println("err>> 메뉴를 다시 선택하세요");
			}
		}
	} // 생성자 끝
	
	/**
	 * 회원 가입
	 * 
	 */
	private void create() {
		System.out.println("\n<< 회원 가입 >>");
		
		int id;
		String name, gender;
		double height, weight;
		
		System.out.print("> 아이디: ");
		id = keyin.nextInt();
		
		// 이 아이디에 해당하는 회원)이 존재하는지 목록에서 확인하는 작업
		// 회원 정보가 있다. ==> exception (x) ==> 가입 불가능
		// 회원 정보가 없다. ==> exception ==> 가입이 가능
		FitnessVO fitness = null;
		try {
			fitness = service.retrieve(id);
			
				System.out.println("## 회원정보가 존재합니다.");
				return;
			
		} catch (Exception e) { // 회원이 없어야(즉, Exception 상태여야) 데이터 삽입이 가능
			System.out.print("> 이  름: ");
			name = keyin.next();
			
			System.out.print("> 성별(남/여): ");
			gender = keyin.next();
			
			System.out.print("> 키(cm): ");
			height = keyin.nextDouble();
			
			System.out.print("> 몸무게(kg): ");
			weight = keyin.nextDouble();

			fitness = new FitnessVO(id, name, gender, height, weight);
			
			try {
				service.create(fitness);
				System.out.println("## 회원 가입이 완료되었습니다.\n");
			} catch (Exception e1) { 
				System.out.println(e1.getMessage());
			}
		}	
	}
	
	/**
	 * 회원 정보 조회
	 */
	private void retrieve() {
		System.out.println("\n<< 회원 정보 조회 >>");
		
		int id;
		
		System.out.print("> 아이디: ");
		id = keyin.nextInt();
		
		// 이 아이디에 해당하는 회원)이 존재하는지 목록에서 확인하는 작업
		FitnessVO fitness = null;
		
		try {
			fitness = service.retrieve(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		// 출력
		System.out.println(fitness);

		System.out.println();
	}
	
	/**
	 * 회원 탈퇴
	 */
	private void delete() {
		System.out.println("\n<< 회원 탈퇴 >>");
		
		int id;
		String check;
		
		System.out.print("> 아이디: ");
		id = keyin.nextInt();
		
		System.out.print("## 탈퇴하시겠습니까? (y/n)");
		check = keyin.next();
		
		if(!(check.equals("Y") || check.equals("y") )) {
			System.out.println("## 탈퇴 작업이 중단되었습니다.\n");
			return;
		}
		
		try {
			service.delete(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("## 탈퇴 완료되었습니다.\n");
	}
	
	/**
	 * 회원 정보 수정
	 */
	private void update() {
		System.out.println("\n<< 회원 정보 수정 >>");
		
		int id;
		String check;
		double height, weight;
		
		System.out.print("> 아이디: ");
		id = keyin.nextInt();
		
		FitnessVO fitness = null;
		
		try {
			fitness = service.retrieve(id);  // 값을 수정하려는 회원 정보 조회
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.print("> 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("> 몸무게(kg): ");
		weight = keyin.nextDouble();
		
		System.out.print("## 수정하시겠습니까? (y/n)");
		check = keyin.next();
		
		if(!(check.equals("Y") || check.equals("y") )) {
			System.out.println("## 수정 작업이 중단되었습니다.\n");
			return;
		}
		
		// 이전 정보의 데이터를 수정
		fitness.setWeight(weight);
		fitness.setHeight(height);
		
		try {
			service.update(fitness);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	
		System.out.println("## 수정 완료되었습니다.\n");
	}
	
	/**
	 * service 클래스에게 회원 목록을 전달받아 화면에 출력
	 */
	private void retrieveAll() {
		List<FitnessVO> list = service.retrieveAll();	// 회원 목록 전체
		
		int count = list.size();

		if(count == 0) {
			System.out.println("## 가입된 회원이 없습니다.");
			return;
		}
		
		System.out.println("** 가입된 회원수: " + count +"명");
		
		list.forEach((fitness) -> System.out.println(fitness) );
		System.out.println();
	}
	
	/**
	 * 화면에 출력되는 메인 메뉴
	 */
	private void menu() {
		System.out.println("==== [ 피트니스 회원 관리 ] ====");
		System.out.println("          1) 회원 가입");
		System.out.println("          2) 정보 조회");
		System.out.println("          3) 정보 수정");
		System.out.println("          4) 탈     퇴");
		System.out.println("          5) 전체 회원 조회");
		System.out.println("          0) 종     료");
		System.out.println("--------------------------------");
		System.out.print  ("           >> 선택: ");
	}
}
