import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		int code;				// 사용자 코드
		int usedAmount;			// 사용량
		int waterBill = 0;  	// 수도요금
		int totalWaterBill;		// 총 수도요금
		double tax = 0.05; 		// 세금
		String type = null;		// type이 아무것도 참조하지 않는다!
		
		// 1) 입력
		System.out.print("* 사용자 코드를 입력하시오. (1:가정용, 2:상업용, 3:공업용) ");
		code = keyin.nextInt();

		System.out.print("* 사용량을 입력하시오. (ton 단위) :");
		usedAmount = keyin.nextInt();
		
		// 2) 처리
		if(code == 1) {
			waterBill = usedAmount * 50;
			type = "가정용";
		} else if(code == 2) {
			waterBill = usedAmount * 45;
			type = "상업용";
		} else if(code == 3) {
			waterBill = usedAmount * 30;
			type = "공업용";
		}
		
		totalWaterBill = waterBill + (int)(tax * waterBill);
		
		// 3) 출력 
		System.out.printf("* 사용자코드: %d (%s)%n", code, type);
		System.out.printf("* 사용량: %d톤%n", usedAmount);
		System.out.printf("* 총 수도요금: %d원%n", totalWaterBill);
		
		// 4) 메모리 정리
		keyin.close();
		
	}

}
