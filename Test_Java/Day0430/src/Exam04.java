/*
 * [문제] 띠 구하기
 * - 태어난 해를 4자리 정수로 입력받아서 해당 년도의 띠를 출력하시오. (switch~case 사용)
 * - 띠 순서: 원숭이, 닭, 개, 돼지, 쥐, 소, 호랑이, 토끼, 용, 뱀, 말, 양
 * 
 * <실행 결과>
 * 태어난 해를 입력하세요 : 2021
 * 2021년생은 소띠 입니다. 
 * 
 * 
 * 
 */

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int year;
		
		System.out.print("태어난 해를 입력하세요 : ");
		year = keyin.nextInt();
	
		String zodiac = switch(year % 12) {
		case 0: yield "원숭이"; 
		case 1: yield "닭"; 
		case 2: yield "개"; 
		case 3: yield "돼지"; 
		case 4: yield "쥐"; 
		case 5: yield "소"; 
		case 6: yield "호랑이"; 
		case 7: yield "토끼"; 
		case 8: yield "용"; 
		case 9: yield "뱀"; 
		case 10: yield "말"; 
		case 11: yield "양"; 
		default: yield "오류";
		
		};
		
		// 띠 순서: 0:원숭이, 1:닭, 2:개, 3:돼지, 4:쥐, 5: 소
		//			6:호랑이, 7:토끼, 8:용, 9:뱀, 10:말, 11:양
		System.out.print(year + "년생은 " + zodiac + "띠입니다.");
		

		
		
		}
		

	}


