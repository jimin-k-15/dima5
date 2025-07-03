
public class ArrayTest_2 {

	public static void main(String[] args) {
		// 가변 배열 (가능하나 잘 사용하지 않음)
		//int[][] temp = {{1, 2}, {1, 2, 3, 5, 7}, {11, 23, 34}};
		
		int[][] ary = new int[5][5];
		int cnt = 0;
		
		// 입력
		for(int i=0; i<ary.length; ++i) { 				// 행을 돌기 위한 for문
			for(int j=0; j<ary[i].length; ++j) {		// 열을 돌기 위한 for문
				ary[j][i] = ++cnt;						// i와 j 바꿔서도 가능
			}
		}
		
		// 출력
		for(int i=0; i<ary.length; ++i) { 				// 행을 돌기 위한 for문
			for(int j=0; j<ary[i].length; ++j) {		// 열을 돌기 위한 for문
				System.out.printf("%3d", ary[i][j]);
			}
			System.out.println();
		}
		
	}

}
