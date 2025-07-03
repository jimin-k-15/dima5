/*
 * [문제-4] 중복값을 제거한 배열
 * 10개짜리 정수 배열을 선언하고 생성한 후
 * 1~100 사이의 정수를 발생시켜 저장하고 출력하시오. 
 * 단, 중복된 값은 제외 (동일한 값을 발생시켰을 경우 배열에 저장하지 않는다!)
 * 
 * <주의>
 * 배열에 발생된 값을 바로 넣지 않고, temp 방에 넣은 후
 * temp 방 값과 0~i까지 비교하여 동일한 값이 있으면 다시 발생시킨다. 
 * 
 * <실행 예시>
 * 1 5 3 6 7 8 2 1 10 88 99 33
 * 합계 : xxx 
 */
public class Exam04 {

	public static void main(String[] args) {
	      int[] data = new int[10];

	        for (int i = 0; i<data.length; ++i) {
	            data[i] = (int)(Math.random() * 100 + 1);  // i-1방까지 동일 값이 있는지 확인
	            
	            for (int j = 0; j < i; ++j) {
	            	if (data[i]== data[j]) {
	            		--i;
	            		break;
	            	}
	            }
	              	
	        } // end for
	        
	        // 중복 제거된 배열 출력
	        for (int i = 0; i<data.length; ++i) {
	        	System.out.printf("%-4d", data[i]);
	        }
	        System.out.println();
	}
}
