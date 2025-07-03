/*
 * [문제-1] 문자열이 저장된 스트림을 생성해서 "밥"이 포함되지 않은 데이터만 
 * 		  추출해서 출력하시오. 
 * 
 * [문제-2] int형 배열 20개짜리 생성한 후에 1~50 사이의 난수를 발생시켜 저장한다. (일반 for문)
 * 			발생된 배열 내의 데이터를 스트림으로 변환하고
 * 			3의 배수거나 8의 배수인 숫자만 추출하여 최종 출력하는 코드를 작성하시오. 
 */
package streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest_02 {
	
	// [문제-1]
	public static void main(String[] args) {
		// 스트림 생성
		Stream<String> stream = List.of("순대국밥", "설렁탕", "양푼 비빔밥", 
				"돌솥 비빔밥", "비빔국수", "부대찌개", "달걀볶음밥").stream();
		
		// 스트림 연산 (추출한 후 내림차순 정렬하고 출력)
		stream.filter((x) -> !x.contains("밥"))
			.sorted((x,y) -> y.compareTo(x))  // x, y 바꾸면 오름차순
			.forEach((x) -> System.out.println(x));
		
	
	// [문제-2]
		int[] iary = new int[20];
		// 1~50 사이의 난수로 배열 채우기
		for (int i=0; i<iary.length; ++i) {
			iary[i] = (int)(Math.random() * 50) + 1;
		}
		
		// 3의 배수 또는 8의 배수만 추출
		IntStream istream = Arrays.stream(iary);
		int[] result = istream.filter(x -> x%3 == 0 || x%8 ==0).toArray();
		
		//	.forEach(x -> System.out.print(x + " "));
		
		
		
		
	}
}
