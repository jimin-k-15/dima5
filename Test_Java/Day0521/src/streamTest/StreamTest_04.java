package streamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest_04 {

	public static void main(String[] args) {
		Stream.iterate(2, x->x+2).limit(10).forEach((x) -> System.out.println(x));
		Stream.generate(() -> Math.random() * 10).forEach((x) -> System.out.println(x));
		
		// [문제] 
		// generate()를 이용해서 정수를 발생시키시오. (1~46) 수 10개를 발생시킨 후 
		// 이렇게 발생된 데이터 6개를 List로 반환하시오.
		// 10번의 로또게임을 저장할 리스트
		List< List<Integer> > finalList = new ArrayList<>();
		
		for(int i=0; i<10; ++i) 
			finalList.add(Stream.generate(() -> (int)(Math.random() * 45 + 1)).limit(6).toList());
		
		System.out.println(finalList);
		
	}

}
