
public class MyStaticClass {
	String id;		// 아이디(계좌번호)  인스턴스 변수
	int balance;	// 금액     		 인스턴스 변수

	static int memberCnt = 0;	// 클래스 변수 (공통으로 사용하는 변수)
	
	static {
		System.out.println("스태틱 블록");
	} 
	
	public MyStaticClass(String id, int balance) {
		this.id = id;
		this.balance = balance;
		System.out.println("생성자");
		memberCnt++;
	}
	
}
