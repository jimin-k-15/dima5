
public class ArrayTest_1 {

	public static void main(String[] args) {
		// 1차원 배열
		int[] iary1 = new int[5];
//		int[] iary1 = {1, 2, 3, 4, 5};
		
		// 2차원 배열
		int[][] iary2 = new int[3][4];  // <- 3행 4열로 선언. 12개의 정수형 배열
		int iary3[][] = new int[3][4];  // 대괄호가 뒤로 가는 게 문법적으로 가능은 함. 
		int[] iary4[] = new int[3][4];  // 이 방법도 문법적으로 가능은 하지만, 권장하지 않음. 
		
		int[][] iary5 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};   // 3행x4열 
	
		// 전통적인 for문
		for(int i=0; i < iary5.length; ++i) {
			for(int j=0; j < iary5[i].length; ++j) {
				System.out.printf("%3d", iary5[i][j]);
			}
			System.out.println();       // 한 줄 출력하고 나서 줄바꿈용 
		}
		
		// 향상된 for문
		for(int[] temp : iary5) {
			for(int data : temp) {
				System.out.printf("%3d", data);
			}
			System.out.println();		// 한 줄 출력하고 나서 줄바꿈용 		
		}
		
		
//		System.out.println(iary2);
//		System.out.println(iary2[0]);
//		System.out.println(iary2[1]);
//		System.out.println(iary2[2]);
//		
//		System.out.println(iary2[0][0]);
		
		
		
	}

}
