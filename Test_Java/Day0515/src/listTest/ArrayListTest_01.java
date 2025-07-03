package listTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest_01 {

	public static void main(String[] args) {
		String[] ary = new String[100];
		List<String> list = new ArrayList<>();
		
		ary[0] = "호랑이";
		list.add("호랑이");
		
		String s1 = ary[0];
		String s2 = list.get(0);
		
		System.out.println(ary.length);		// 방 개수
		System.out.println(list.size());	// 데이터 개수
		
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
