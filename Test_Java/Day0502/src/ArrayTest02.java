// 선형자료구조 : 배열

public class ArrayTest02 {

	public static void main(String[] args) {
		// --------1번째--------
		int[] ary = new int[10]; 
		
		// 배열의 초기화
		for(int i=0; i<ary.length; ++i) {
			ary[i] = i+1;
		}
		System.out.println();
		
		// 배열의 출력
		for(int i=0; i<ary.length; ++i) {
			System.out.printf("%d  ", ary[i]);
		}
		
		// --------2번째--------
		int[] ary2 = new int[]{1, 2, 3, 4, 5}; 
		
		for(int i=0; i<ary2.length; ++i) {
			System.out.printf("%d  ", ary2[i]);
		}
		System.out.println();
		
		// --------3번째--------
		int[] ary3 = {1, 2, 3, 4, 5}; 
		
		for(int i=0; i<ary3.length; ++i) {
			System.out.printf("%d  ", ary3[i]);
		}
	}
}