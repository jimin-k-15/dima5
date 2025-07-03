// Call By Reference 
// 		참조 주소를 메서드로 전달하면서 호출하는 방식
//		자바에서는 99% 이상 call by reference를 사용한다! 
public class MethodTest_4 {

	public static void main(String[] args) {
		int[] ary = {10, 20};
		
		System.out.printf("a = %d, b = %d%n", ary[0], ary[1]);
		exchange(ary);
		System.out.printf("a = %d, b = %d%n", ary[0], ary[1]);
		
	}
	
	public static void exchange(int[] ary) {		// 위 int a = 10, b = 20과 다른 a, b임
		int temp;
		temp = ary[0];
		ary[0] = ary[1];
		ary[1] = temp;
	}
	
}
