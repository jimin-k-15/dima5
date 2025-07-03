/*
 * 생성, 조회, 삭제, 수정 (Create, Retrieve, Delete, Update) ==> CRUD
 */

package fitness.ui;

import java.util.Scanner;

import fitness.service.FitnessService;
import fitness.vo.FitnessVO;
//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class FitnessUI {
	Scanner keyin = new Scanner(System.in);
	FitnessService service = new FitnessService();
	
	FitnessVO fitness = null;
	
	public FitnessUI() {
		// main --> ui --> vo
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
				System.out.println("## 프로그램을 종료합니다.\n");
				return;
			default :
				System.out.println("err>> 메뉴를 다시 선택하세요\n");
			}
		}
	} // 생성자 끝
	
	/**
	 * 회원 가입 
	 */
	private void create() {
		System.out.println("\n<< 회원 가입 >>");
		
		int id;
		String name, gender;
		double height, weight;
		
		if(fitness != null) {
			System.out.println("## 내부사정으로 인하여 가입을 할 수 없습니다.\n");
			return;
		}
		
		System.out.print("> 아이디:");
		id = keyin.nextInt();
		
		// 이 아이디에 해당하는 회원이 존재하는지 목록에서 확인하는 작업
		if(service.retrieve(id) != null) {
			System.out.println("## 회원 가입을 할 수 없습니다.\n");
			return;
		}
		
		System.out.print("> 이  름:");
		name = keyin.next();
		
		System.out.print("> 성별(남/여):");
		gender = keyin.next();
		
		System.out.print("> 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("> 몸무게(kg):");
		weight = keyin.nextDouble();
		
		FitnessVO fitness = new FitnessVO(id, name, gender, height, weight);
		
		boolean result = service.create(fitness);
		
		if(result)
			System.out.println("## 회원 가입이 완료되었습니다.\n");
		else
			System.out.println("## 회원 가입을 할 수 없습니다.\n");
	}

	
	
	/**
	 * 회원 정보 조회
	 */
	private void retrieve() {
		System.out.println("\n<< 회원 정보 조회 >>");
		
		int id;
		
		System.out.print("> 아이디:");
		id = keyin.nextInt();
		
		// 이 아이디에 해당하는 회원이 존재하는지 목록에서 확인하는 작업
		FitnessVO fitness = service.retrieve(id);
		
		if(fitness == null) {
			System.out.println("## 해당 아이디의 회원이 없습니다.\n");
			return;
		}
		
		// 출력
		System.out.println(fitness.output());
		
		System.out.println();
	}
	
	/**
	 * 회원 탈퇴
	 */
	private void delete() {
		System.out.println("\n<< 회원 탈퇴 >>");
		
		int id;
		String check;
		
		System.out.print("> 아이디:");
		id = keyin.nextInt();
		
		System.out.println("## 탈퇴하시겠습니까? (y/n)");
		check = keyin.next();
		
		if(!(check.equals("Y") || check.equals("y"))) {
			System.out.println("## 탈퇴 작업이 중단되었습니다.\n");
			return;
		}
		
		boolean result = service.delete(id);
		
		if(result)
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
		
		System.out.print("> 아이디:");
		id = keyin.nextInt();
		
		FitnessVO fitness = service.retrieve(id);	// 값을 수정하려는 회원 정보 조회
		
		if(service.retrieve(id) == null) {
			System.out.println("## 해당 아이디는 존재하지 않습니다.\n");
			return;
		}
		
		System.out.print("> 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("> 몸무게(kg):");
		weight = keyin.nextDouble();
		
		System.out.println("## 수정하시겠습니까? (y/n)");
		check = keyin.next();
		
		if(!(check.equals("Y") || check.equals("y"))) {
			System.out.println("## 수정 작업이 중단되었습니다.\n");
			return;
		}

		
		// 이전 정보의 데이터를 수정
		fitness.setWeight(weight);
		fitness.setHeight(height);	// 남여 확인할 때 성별을 세팅하는 코드가 없으므로 Null
		
		boolean result = service.update(fitness);
		
		if(result)
			System.out.println("## 수정 완료되었습니다.\n");		
	}
	
	/**
	 * service 클래스에게 회원 목록을 전달받아 화면에 출력
	 */
	private void retrieveAll() {
		int count = service.getCount();				// 등록한 회원 수
		
		if(count == 0) {
			System.out.println("## 가입된 회원이 없습니다.");
			return;
		}
		
		FitnessVO[] list = service.retrieveAll();	// 회원 목록 전체
		
		System.out.println("** 가입된 회원수: " + count + "명");
		for(int i=0; i < count; ++i) {
			System.out.println(list[i].output());
		}
	}
	
	
	
	/**
	 * 화면에 출력되는 메인 메뉴
	 */
	private void menu() {
		System.out.println("==== [ 피트니스 회원 관리 ] ====");
		System.out.println("	 1) 회원 가입 ");
		System.out.println("	 2) 정보 조회 ");
		System.out.println("	 3) 정보 수정 ");
		System.out.println("	 4) 탈     퇴 ");
		System.out.println("	 5) 전체 회원 조회 ");
		System.out.println("	 0) 종     료 ");
		System.out.println("--------------------------------");
		System.out.print  ("	 >> 선택:  ");
	}

	
	
	}