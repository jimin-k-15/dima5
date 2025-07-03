
public class ArrayObjectTest_2 {

	public static void main(String[] args) {
		String[] s; 
		s = new String[10]; // null로 초기화 // 생성(선언)과 초기화를 별도로 함
		
		int[] iary = new int[] {12, 3, 4, 5, 67, 8, 6};
		int[] iary2 = {12, 3, 4, 5, 67, 8, 6};
		
		String[] sary = new String[] {"월", "화", "수"}; // 배열 ( []대괄호가 있음에 유의 )		
		String[] sary2 = {"목", "금", "토"};	// 이 방식을 훨씬 더 많이 씀
		
		String name = new String("전우치"); 	// 단일 변수 
		
		
		for (int i = 0; i < s.length; ++i)
			System.out.println(s[i]);
	}

}
