/* 
 * 입력함수: nextInt(), nextDouble(), next(), nextLine()
 * 
 * White Space: 탭, 스페이스, 엔터 (입력 버퍼 내의 데이터를 변수로 이동) 
 * 
 * 문자열 입력받는 메소드 (next(), nextLine())를 사용하여
 * 입력버퍼에 대해 익혀봅시다.
 */

import java.util.Scanner;

public class InputTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		int kor, eng, mat, total;
		double avg;
		
		System.out.print("국어, 영어, 수학점수를 연달아 입력: ");
		kor = keyin.nextInt();
		eng = keyin.nextInt();
		mat = keyin.nextInt();
		
		total = kor + eng + mat;
		avg = total / 3.0;
		
		System.out.println(total + ", " + avg);
	}

}
