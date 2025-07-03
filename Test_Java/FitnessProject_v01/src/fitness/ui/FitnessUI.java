/*
 * 생성, 조회, 삭제, 수정 (Create, Retrieve, Delete, Update) ==> CRUD
 */

package fitness.ui;

import java.util.Scanner;

import fitness.vo.FitnessVO;

public class FitnessUI {
	Scanner keyin = new Scanner(System.in);
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
		
		System.out.print("> 이  름:");
		name = keyin.next();
		
		System.out.print("> 성별(남/여):");
		gender = keyin.next();
		
		System.out.print("> 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("> 몸무게(kg):");
		weight = keyin.nextDouble();
		
		fitness = new FitnessVO(id, name, gender, height, weight);
		
		System.out.println("## 회원 가입이 완료되었습니다.\n");
	}
	
	/**
	 * 회원 정보 조회
	 */
	private void retrieve() {
		System.out.println("\n<< 회원 정보 조회 >>");
		
		int id;
		
		if(fitness == null) {
			System.out.println("## 조회할 정보가 없습니다.\n");
			return;
		}
		
		System.out.print("> 조회 아이디:");
		id = keyin.nextInt();
		
		if(fitness.getId() != id) {
			System.out.println("## 해당 아이디의 회원은 없습니다.\n");
			return;
		}
		
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
		
		if(fitness == null) {
			System.out.println("## 탈퇴할 회원 정보가 없습니다.\n");
			return;
		}
		
		System.out.print("> 아이디:");
		id = keyin.nextInt();
		
		if(fitness.getId() != id) {
			System.out.println("## 해당 아이디의 회원은 없습니다.\n");
			return;
		}
		
		System.out.println("## 정말 탈퇴하시겠습니까? (y/n)");
		check = keyin.next();
		
		if(!(check.equals("Y") || check.equals("y"))) {
			System.out.println("## 탈퇴 작업이 중단되었습니다.\n");
			return;
		}
		
		fitness = null;
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
		
		if(fitness != null) {
			System.out.println("## 내부사정으로 인하여 수정을 할 수 없습니다.\n");
			return;
		}
		
		System.out.print("> 아이디:");
		id = keyin.nextInt();
		
		if(fitness.getId() != id) {
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
		
		fitness.setWeight(weight);
		fitness.setHeight(height);
		System.out.println("## 수정 완료되었습니다.\n");
		
		

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
		System.out.println("	 0) 종     료 ");
		System.out.println("--------------------------------");
		System.out.print  ("	 >> 선택:  ");
	}

	
	
	}