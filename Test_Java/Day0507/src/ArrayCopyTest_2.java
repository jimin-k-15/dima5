import java.util.Arrays;

public class ArrayCopyTest_2 {

	public static void main(String[] args) {
		int[] source = {1, 2, 3, 4, 5};
		int[] target;
		int[] target2;
		
		target = Arrays.copyOf(source, 3);
		for(int data: target)
			System.out.print(data + " ");
		System.out.println();
		
		target = Arrays.copyOf(source, 3);
		for(int data: target)
			System.out.print(data + " ");
		System.out.println();
		
		
		target2 = Arrays.copyOfRange(source, 2, 6);  // 3, 4, 5, 0
		
		source[2] = 999; // 복사 이후에 값을 변경한 것이므로 target2에는 영향이 없음 
		
		for(int data: target2)
			System.out.print(data + " ");
		System.out.println();
	}

}
