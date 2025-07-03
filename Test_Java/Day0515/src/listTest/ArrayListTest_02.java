package listTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest_02 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("아메리카노");
		list.add("카페라떼");
		list.add("카푸치노");
		list.add("말차");
		list.add("오렌지주스");
		
		System.out.println("데이터의 개수: " + list.size());
		String temp = list.get(3);
		
		
		System.out.println(temp);
		
		// 전부 꺼내기
		for(int i=0; i<list.size(); ++i) System.out.print(list.get(i));
		System.out.println();
		
		for(String s : list) System.out.print(s + " ");
		System.out.println();
		
		// 람다 메소드
		list.forEach( (item) -> System.out.print(item + " "));
		System.out.println();
		
		// 데이터 삽입
		list.add(1, "자몽주스");
		System.out.println(list);
		
		// 데이터 교체
		list.set(1, "딸기주스");
		System.out.println(list);
		
		// 데이터 삭제
		String tmp = list.remove(1);
		System.out.println(list);
		System.out.println(tmp);
		
		boolean b = list.remove("말차");
		System.out.println(list);
		System.out.println(b);
		
		// 데이터 확인
		b = list.contains("오렌지주스");
		System.out.println("있나? " + b);
		
		b = list.isEmpty();
		System.out.println("리스트에 데이터가 하나도 없니? " + b);
		
		b = list.isEmpty();
		System.out.println("리스트에 데이터가 하나도 없니? " + b);
		
		list.clear();
		b = list.isEmpty();
		System.out.println("리스트에 데이터가 하나도 없니? " + b);
		
		// 전체 데이터 순회 ==> Iterable 타입으로 전달받아 순회
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
