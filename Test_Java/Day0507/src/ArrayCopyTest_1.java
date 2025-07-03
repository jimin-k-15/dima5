
public class ArrayCopyTest_1 {

	public static void main(String[] args) {
		int[] ary1 = {1, 2, 3, 4, 5};	
		
		// 얕은 복사
		int[] ary2 = ary1;
		
		ary1[1] = 22;
		
		for(int a : ary1)
			System.out.println(a);
		
		for(int a : ary2)
			System.out.println(a);
	}

}
