package ui;

import java.util.List;
import java.util.Scanner;

import service.DroneService;
import vo.Drone;

public class DroneUI {
	DroneService service = new DroneService();
	Scanner keyin = new Scanner(System.in);
	
	public DroneUI() {
		String menu = null;
		
		while(true) {
			mainMenu();
			menu = keyin.next()
					;
			switch(menu) {
			case "1" : inSertDrone(); break;
			case "2" : searchDrone(); break;
			case "3" : removeDrone(); break;
			case "4" : droneListForPrice(); break;
			case "5" : selectAll();   break; 
			case "0" : 
				System.out.println("* 프로그램 종료");
				return;
			default : 
				System.out.println("## 메뉴를 다시 선택");
			}
		}
	}

	/*
	 * 특정 가격대의 드론 목록 조회
	 */
	private void droneListForPrice() {
		System.out.println("==== [ 드론 가격대 검색 ] ====");
		int minPrice, maxPrice;
		
		System.out.print("> 최소가격: ");
		minPrice = keyin.nextInt();
		
		System.out.print("> 최대가격: ");
		maxPrice = keyin.nextInt();
		
		List<Drone> list = service.droneListForPrice(minPrice, maxPrice);
		
		list.forEach((drone) -> System.out.println(drone));
		System.out.println("총 " + list.size() + "개의 드론이 있습니다.");
		
	}

	/**
	 * 등록된 모든 데이터를 조회
	 */
	private void selectAll() {
		System.out.println("==== [ 드론 전체 정보 출력 ] ====");
		
		List<Drone> list = service.selectAll();
		
		list.forEach((drone) -> System.out.println(drone));
		System.out.println("총 " + list.size() + "개의 드론이 있습니다.");
	}

	/**
	 * 고유번호를 입력받아 해당 번호의 드론을 삭제
	 */
	private void removeDrone() {
		System.out.println("==== [ 드론 삭제 ] ====");
		int serialNum;
		
		System.out.print("> 고유번호: ");
		serialNum = keyin.nextInt();
		
		int result = service.removeDrone(serialNum);
		
		System.out.println((result != 0 ? "** 삭제 완료" : "** 내부 오류로 인해 삭제 실패"));
		
		System.out.println();
		
	}

	/**
	 * 드론의 serial num을 입력받아 검색
	 */
	private void searchDrone() {
		System.out.println("==== [ 드론 검색 ] ====");
		int serialNum;
		
		System.out.print("> 고유번호: ");
		serialNum = keyin.nextInt();
		
		Drone drone = service.searchDrone(serialNum);
		if (drone != null)
			System.out.println(drone);
		else
			System.out.println("** 그 고유번호의 드론은 없음");
		
		System.out.println();
	}

	/**
	 * 드론 객체를 저장하기 위해 Drone 객체를 생성
	 */
	private void inSertDrone() {
		System.out.println("==== [ 드론 정보 등록 ] ====");
		int serialNum, price, wingCount;
		String name;
		
		System.out.print("> 드론명: ");
		name = keyin.next();
		
		System.out.print("> 드론가격: ");
		price = keyin.nextInt();
	
		System.out.print("> 날개 개수: ");
		wingCount = keyin.nextInt();
		
		Drone drone = new Drone(0, name, price, wingCount);
		
		int result = service.insertDrone(drone);
		System.out.println((result != 0 ? "** 등록 완료" : "** 내부 오류로 인해 등록 실패"));
	}

	/*
	 * 주 메뉴
	 */
	private void mainMenu() {
		System.out.println("====== Drone Project ======");
		System.out.println("  1. 드론 등록");
		System.out.println("  2. 드론 검색");
		System.out.println("  3. 드론 삭제");
		System.out.println("  4. 가격대 검색");
		System.out.println("  5. 드론 전체 정보 출력");
		System.out.println("  0. 종료 ");
		System.out.print  ("  >> 메뉴 선택 :  ");
		
	}
}

