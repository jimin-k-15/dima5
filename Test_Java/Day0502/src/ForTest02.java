
public class ForTest02 {

	public static void main(String[] args) {
		int dan = 5;   // 2~9단 
		
		for(dan=2; dan<=9; ++dan) { 
			for (int i=1; i<=9; ++i) {
				System.out.printf("%d x %d = %d\n", dan, i, (dan*i));
			}
			System.out.println();
		}
	}
}
