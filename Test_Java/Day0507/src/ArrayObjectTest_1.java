
public class ArrayObjectTest_1 {

	public static void main(String[] args) {
//		int[] iary = new int[10];    // 0으로 초기화
		String[] s = new String[10]; // null로 초기화
		s[0] = "돼지국밥";
		s[1] = "샌드위치";
		s[2] = "짜장면";
		
		// 이전 방식(전통적인 방식)의 for문 
//		for(int i = 0; i < s.length; ++i)
//			System.out.println(s[i]);
		
		// 향상된 for문 (배열과 같은 데이터 묶음을 처리할 때) 
		for(String str : s) {
			System.out.println(str);
		}
	}
}
