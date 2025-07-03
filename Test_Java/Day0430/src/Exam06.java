/*
 * [문제] 어떤 놀이동산에서 열차에 사람을 태워서 출발하려고 한다!
 * 		  무조건 5명이 채워져야 출발 가능
 * 		  그런데, 그 열차에 탈 수 있는 사람은
 * 		  키가 150~180 사이여야 한다.
 * 
 * <실행>
 *    키? 151
 *    1명 탑승
 *    키? 189
 *    1명 탑승
 *    키? 145
 *    1명 탑승
 *    ...
 *    키? 156
 *    5명 탑승
 *    열차 출발합니다.
 * 
 */
import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double height = 0.0;     // 키
        int count = 0;           // 탑승 인원
        
        while(count < 5) {
        	System.out.print("키? ");
        	height = keyin.nextDouble();
        	
        	if (height >= 150 && height <= 180) ++count; 
        	System.out.println(count + "명이 탑승 완료!");
        }   // end while

        System.out.println("열차 출발합니다.~");
	}

}
