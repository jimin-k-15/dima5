/*
 * 세 개의 정수를 입력받아 큰 순서대로 정렬하여 출력하는 코드 작성
 * max, median, min
 */

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int max, median, min, temp;
		
		// 입력
		System.out.print("첫 번째 정수 입력: ");
	    max = keyin.nextInt();

	    System.out.print("두 번째 정수 입력: ");
	    median = keyin.nextInt();

	    System.out.print("세 번째 정수 입력: ");
	    min = keyin.nextInt();

	    // 정렬: 큰 수 → max, 중간 → median, 작은 수 → min
	    if (max < median) {
	            temp = max;
	            max = median;
	            median = temp;
	        }

	    if (max < min) {
	            temp = max;
	            max = min;
	            min = temp;
	        }

	     if (median < min) {
	            temp = median;
	            median = min;
	            min = temp;
	        }

	     // 출력
	     //System.out.printf("큰 순서대로 출력: %d, %d, %d\n", max, median, min);
	     System.out.println("max = " + max + ", median = " + median + ", min = " + min);
		

	}

}
