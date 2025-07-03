/*
 * 3중 for문 만들기
 * 2 x 1 = 2	3 x 1 = 3	4 x 1 = 4	5 x 1 = 5
 * 2 x 2 = 4	3 x 2 = 6	4 x 2 = 8	5 x 2 = 10 
 * 
 * 2 x 9 = 18	3 x 9 = 27	4 x 9 = 36	5 x 9 = 45
 */
public class ForTest03 {

	public static void main(String[] args) {
		
		for(int j = 2; j <= 6; j += 4 ) {
			for(int i=1; i<=9; ++i) {
				for (int dan = j; dan <= j+3; ++dan) {
					System.out.printf("%d x %d = %d\t", dan, i, (dan* i));
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
