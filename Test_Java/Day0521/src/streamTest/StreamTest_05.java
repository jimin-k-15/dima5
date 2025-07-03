package streamTest;

import java.util.List;
import java.util.stream.Stream;

public class StreamTest_05 {

	public static void main(String[] args) {
		List<String> list = List.of("순대국밥", "설렁탕", "양푼비빔밥", "돌솥비빔밥", "비빔국수", 
				"부대찌게", "달걀볶음밥");
		Stream<String> s1 = list.stream();
		
		boolean result = s1.allMatch((x) -> x.contains("밥"));
		System.out.println(result? "밥만 팔아요" : "다른 메뉴도 있어요");

		s1 = list.stream();
		System.out.println( s1.anyMatch((x) -> x.contains("밥")) ? "밥도 팔아요" : "밥은 없어요");
		
		System.out.println(
				list.stream().noneMatch((x) -> x.contains("면")) ? "면은 안 팔아요" : "면 종류 팔아요");
			
	}
}
