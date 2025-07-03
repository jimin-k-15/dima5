
public class MethodTest_1 {

	public static void main(String[] args) {
		add("a = ",1, 2);
		add("b = ",1, 2, 3);
		// Object라는 객체는 모든 데이터타입의 조상
		System.out.printf("aaa", 2, "abc", 'a', 6, true, 45.7F);

	}
	
//	public static int add(int a, int b) {
//		return a + b;
//	}
//	
//	public static int add(int a, int b, int c) {
//		return a + b + c;
//	}

	public static int add(String str, int... data) {
		int total = 0;
		for(int i=0; i<data.length; ++i) {
			total += data[i];
		}
		return total;
	}
	
}
