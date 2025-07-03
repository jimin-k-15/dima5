package streamTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTest_01 {

	public static void main(String[] args) {
		int[] intAry = {1, 8, 5, 7, 9, 10, 45, 3, 4, 8, 4, 8};
		
		// 1) 배열을 이용하여 스트림 생성
		IntStream sInt = Arrays.stream(intAry);
		
		// 2) 중간연산 (짝수만 추출: filter)
		sInt = sInt.filter((x) -> x%2 == 0? true: false);

		
		// 2-1) 중간연산 (중복제거 연산)
		sInt = sInt.distinct();
		
		// 3) 최종연산: 스트림이 닫힘 
		sInt.forEach((x) -> System.out.println(x));
		
		// sInt 사용 불가
		System.out.println();
		
		// 4) 스트림을 다시 생성하여 chaining 처리하기
		IntStream aInt = Arrays.stream(intAry);
		aInt.filter((x) -> x%2 != 0? true: false)
			.distinct()
			.forEach((x) -> System.out.println(x));
		
		
		
		
	}
}
