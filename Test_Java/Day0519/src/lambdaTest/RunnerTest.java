package lambdaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RunnerTest {

	public static void main(String[] args) {
		Runner a = new Runner("사오정", 2.35);
		Runner b = new Runner("저팔계", 2.42);
		
		if(a.compareTo(b) == 1)
			System.out.println("사오정의 시간이 큽니다.");
		else if(a.compareTo(b) == -1)
			System.out.println("저팔계의 시간이 큽니다.");
		else
			System.out.println("두 사람의 시간이 같습니다.");
		
		List<Runner> list = Arrays.asList(
				new Runner("삼장법사", 3.45),
				new Runner("손오공", 2.15),
				new Runner("전우치", 1.45),
				new Runner("임꺽정", 4.75),
				new Runner("이몽룡", 3.12)
				);
		// 오버로딩 메소드가 2종류 있는데, 그 중에 전달인지 1개만 받는  sort()를 써보자
		// list 내의 각 객체에서 compareTo()가 정의되어 있을 경우,
		// 전달인자 1개짜리 sort() 사용 가능
		Collections.sort(list);
		list.forEach((x) -> System.out.println(x));

	}

}
