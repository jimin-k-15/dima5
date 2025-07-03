package bank;

import java.util.Scanner;

public class AccountTest2 {
	static Scanner keyin = new Scanner(System.in);		// static에서는 non-static에 접근하려면

	public static void main(String[] args) {
		Account account = new Account();	// A라는 사람의 계좌 개설
											// JVM이 만든 생성자를 호출하여 메모리에 멤버들을 적재
		String choice;	
		
		while(true) {
			menu(); 
			choice = keyin.next();
			
			switch(choice) {
			case "1": 		// 계좌 개설
				regist(account);	// call by value(값을 전달)? call by reference(주소 전달)? => call by reference! 중요
									// call by reference의 특징 : 원본에 접근할 수 있다. 
				break;
			case "2": 		// 계좌 조회
				retrieve(account);
				break;
			case "3": 		// 예금하기
				deposit(account);
				break;
			case "4": 
				withdraw(account);	// 출금하기
				break;
			case "0": 
				System.out.println("** 프로그램을 종료합니다."); 
				keyin.close();
				System.exit(0);
			default :
				System.out.println("err> 메뉴선택을 다시 하세요");
			}
		}

	}
	public static void regist(Account account) {
		System.out.println("<< 계좌 개설 >>");
		
		System.out.print("* 계좌번호: ");
		String accountNo = keyin.next();	// 여기서 accountNo, accountName 는 지역변수
		
		System.out.print("* 이름: ");
		String accountName = keyin.next();
		
		account.setAccountNo(accountNo);
		account.setAccountName(accountName);
		
	}
	
	public static void retrieve(Account account) {
		System.out.println("<< 계좌 조회 >>");
		System.out.println(account.output());
	}
	
	public static void deposit(Account account) {
		System.out.println("<< 예금하기 >>");
		String no;
		int money;
		
		System.out.print("* 계좌번호: ");
		no = keyin.next();
		System.out.print("* 입금액: ");
		money = keyin.nextInt();
		
		// account 변수의 계좌번호와 입력번호가 같은지 확인
		String myNo = account.getAccountNo();
		
		if(no.equals(myNo)) {
			account.deposit(money);
		} else {
			System.out.println("err>> 계좌번호가 잘못 입력되었습니다.\n");
		}
 	}
	
	public static void withdraw(Account account) {
		System.out.println("<< 출금하기 >>");
		String no;
		int money;
		
		System.out.print("* 출금할 계좌번호: ");
		no = keyin.next();
		System.out.print("* 출금할 금액: ");
		money = keyin.nextInt();
		
		if(account.withdraw(money) == -1) {
			System.out.println("** 잔액이 부족합니다.");
		} else {
			System.out.println(money+"원이 출금되었습니다.");
		}
		
	}
	
	
	public static void menu() {
		System.out.println("==== [ 오기은행 고객 관리 ] ====");
		System.out.println("        1) 계좌 개설");
		System.out.println("        2) 잔고 확인");
		System.out.println("     	3) 예금하기");
		System.out.println("     	4) 출금하기");
		System.out.println("     	0) 종료");
		System.out.println("   ** 	선택하시오: ");
	}

}
