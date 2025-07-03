package setTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest_01 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("포도");
		set.add("딸기");
		set.add("수박");
		set.add("멜론");
		set.add("참외");
		
		// 1) 데이터 개수 확인
		System.out.println("개수: " + set.size());
		
		// 2) 전체 조회
		set.forEach( (fruit) -> System.out.print(fruit + " ") );
		System.out.println();
		
		// 3) 조회
		boolean result = set.contains("수박");
		System.out.println(result);
		
		// 4) 삭제
		result = set.remove("수박");
		System.out.println(result ? "삭제 완료!" : "삭제 실패");
		System.out.println("남은 개수: " + set.size());
		
		// 5) 추가
		result = set.add("딸기");
		System.out.println(result ? "추가 완료!" : "추가 실패");
		System.out.println("남은 개수: " + set.size());
		
		// 6) Iterator 객체를 이용해 전체 순회
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// 7) 집합 비우기
		set.clear();
		
		System.out.println("남은 개수: " + set.size());
		System.out.println("집합이 비었는지 여부: " + set.isEmpty());
	}

}
