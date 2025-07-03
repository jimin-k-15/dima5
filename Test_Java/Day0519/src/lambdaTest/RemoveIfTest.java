package lambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveIfTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i < 20; ++i)
			list.add((int)(Math.random()*50));
		
		System.out.println(list);
		list.removeIf( (x) -> !(x % 3 == 0 || x % 8 == 0));
		System.out.println(list);
		
		// "밥"이라는 단어가 포함된 요소를 삭제하시오. 
		List<String> bab = new ArrayList<>();
		bab.add("콩나물국밥");
		bab.add("순대국밥");
		bab.add("돈까스");
		bab.add("스테이크");
		bab.add("돼지국밥");
		bab.add("닭갈비");
		
		System.out.println(bab);
		bab.removeIf((y) -> y.contains("밥"));
		System.out.println(bab);

	}

}
