package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCircleTest {

	public static void main(String[] args) {
		// 1) x, y, radius를 각각 난수로 발생시켜 초기화시키는 코드
		//    x, y => 1~10, radius => 1~20 사이의 난수로 처리하시오
		List<MyCircle> list = new ArrayList<>();
		
		// 2) List에 1)에서 발생된 값으로 생성한 MyCircle 10개를 저장하시오 (forEach로 출력)
		for (int i=0; i<10; ++i) {
			int x = (int) (Math.random() * 10 + 1);			// 1~10
			int y = (int) (Math.random() * 10 + 1);			// 1~10
			double radius = (Math.random() * 20 + 1);		// 1~20
			list.add(new MyCircle(x, y, radius));
		}
		print(list); 
		
		// 3) compare() 메소드를 이용해서 면적이 큰 -> 작은 순서대로 정렬 (forEach로 출력)
		Collections.sort(list, 
				(x, y)
				-> x.getRadius() > y.getRadius() ? 1
				 : x.getRadius() < y.getRadius() ? -1 : 0 
				);
		
		print(list); 
		
		// 4) 반지름이 10 미만인 모든 원을 삭제 (forEach로 출력)
		list.removeIf((x) -> (x.getRadius() < 10));
		print(list);
	}
	
	private static void print(List<MyCircle> list) {
		list.forEach((x) -> System.out.println(
				String.format("x=%d, y=%d, radius=%.2f, area=%.2f", 
						x.getX(), x.getY(), x.getRadius(),
						x.getRadius()*x.getRadius()*Math.PI)));
		
		System.out.println("================");
	}
}


