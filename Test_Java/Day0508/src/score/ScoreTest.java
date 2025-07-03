package score;
import java.util.Scanner;

public class ScoreTest {

	public static void main(String[] args) {
		// VO를 사용하려면 
		// 1) 해당 클래스를 메모리에 로딩 (클래스 선언). new : 해당 데이터를 Heap 영역에 업로드 
		int a;
		Scanner sc = new Scanner(System.in);
		int[] ary  = new int[10];

		Score hong = new Score();	// 생성자 메소드를 호출하여 객체를 Heap 영역에 생성하고 초기화
		// 직접접근은 데이터를 외부에 노출시키는 것이므로 private으로 숨김
//		hong.id = "1234";		// 데이터 저장
//		hong.name = "홍길동";	
//		hong.kor = 78;
//		hong.eng = 88;
//		hong.math = 89;
		
		// 간접접근하도록 함! ==> 메소드를 통해서 접근 

		// set 전 : null 또는 0 값으로 초기화 
		System.out.println("학번: " + hong.getId());
		System.out.println("이름: " + hong.getName());
		System.out.println("국어: " + hong.getKor());
		System.out.println("영어: " + hong.getEng());
		System.out.println("수학: " + hong.getMath());
		
		hong.setId("1234");
		hong.setName("홍길동");
		hong.setKor(78);
		hong.setEng(88);
		hong.setMath(89);
		
		// set 후 
		System.out.println("학번: " + hong.getId());
		System.out.println("이름: " + hong.getName());
		System.out.println("국어: " + hong.getKor());
		System.out.println("영어: " + hong.getEng());
		System.out.println("수학: " + hong.getMath());
		
		Score son = new Score();
//		son.id = "5647";
//		son.name = "손오공";
//		son.kor = 90;
//		son.eng = 100;
//		son.math = 95;
		
		Score lee = new Score(); 
		
		
//		son = null;		// 아무것도 참조하고 있지 않다! GC에 의해 객체가 소멸된다. 
		


	}

}
