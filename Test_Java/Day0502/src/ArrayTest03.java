
public class ArrayTest03 {

	public static void main(String[] args) {
		int[] ary = new int[10];
		int number;
		
		// 초기화
		for (int i=0; i<ary.length; ++i) {
			number = (int)(Math.random() * 99) + 1; // 1 ~ 100
			// 3이나 8의 배수인 경우만 배열에 저장
			if(number % 3 == 0 || number % 8 == 0)
				ary[i] = number;
			else 
				--i;
		}	
		
		// 출력
		for (int i=0; i<ary.length; ++i) {
			System.out.println(ary[i] + "   ");
		}
		System.out.println();
		
		// 자리이동하는 작업  
		/* 0  9 (ary.length-1)
		 * 1  8 (ary.length-2)
		 * 2  7 (ary.length-3)
		 * 3  6 (ary.length-4)
		 * 4  5 (ary.length-5)
		 * ary[i]   ary[ary.length-(i+1)]  
		 */
		
		int temp;
		for(int i=0; i < ary.length/2; ++i) {
			temp = ary[i];
			ary[i] = ary[ary.length-(i+1)];
			ary[ary.length-(i+1)] = temp;
		}
		
		// 출력
		for (int i=0; i<ary.length; ++i) {
			System.out.println(ary[i] + "   ");
		}
		System.out.println();
			
	}
}
