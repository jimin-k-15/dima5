package mapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest_01 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		
		Integer data = 1;
		
		// 1) 데이터 저장
		map.put(1, "이순신");
		map.put(2, "김유신");
		map.put(3, "권율");
		map.put(4, "강감찬");
		
		// 2) 개수 조회
		System.out.println("개수 : " + map.size());
		
		// 3) 조회
		boolean result = map.containsKey(5);
		System.out.println(result? "5번 장군 있음" : "5번 장군 없음");
		
		result = map.containsValue("홍범도");
		System.out.println(result? "홍범도 장군 있음" : "홍범도 장군 없음");
		
		String value = map.get(5);	// Key 값이 5인 사람
		System.out.println("5번 장군 : " + value);
		
		value = map.get(1);			// Key 값이 1인 사람
		System.out.println("1번 장군 : " + value);
		
		// 4) 이미 존재하는 Key면 새로운 값으로 Update된다. 
		value = map.put(4, "홍범도");
		System.out.println("튕겨 나온 값: " + value);
		
		System.out.println(map);
		
		// 5) 새로운 값으로 대체
		value = map.replace(3, "맥아더");
		System.out.println(map);
		
		// 6) Key를 이용해서 데이터 삭제
		value = map.remove(2);
		System.out.println("삭제된 데이터: " + value);
		
		System.out.println(map);
		
		// 7) Iterator를 이용한 전체 순회
		// 	  Key의 모든 목록을 반환 받는다 ==> Set
		//	  Set에 들어있는 Key를 가지고 데이터에 접근
		Iterator<Integer> iter = map.keySet().iterator();

		while(iter.hasNext()) {
			Integer key  = iter.next();		
			System.out.println(key + " : " + map.get(key));
		}

		// 8) 전부 삭제
		map.clear();
		System.out.println("데이터가 있니? " + map.isEmpty());
	}
}
