package lambdaTest;

import java.util.List;
import java.util.function.Predicate;

public class MyCalculatorTest {

	public static void main(String[] args) {
		MyCalculator result = (a, b) -> a - b;
 	
		Predicate<String> p1 = (x) -> x.equals("Seoul") ? true : false;
		System.out.println(p1.test("Busan") ? "서울":"지방");
		System.out.println(p1.test("Seoul") ? "서울":"지방");
		
		List<String> gender = List.of("여자", "여자", "남자", "여자", "남자");
		// gender라는 리스트에 포함된 모든 데이터를 영문으로 출력하시오.
		
		for(String data : gender) 
			print(((x) -> x.equals("여자") ? true : false), data);
	
	}
	
	public static void print(Predicate<String> p, String s) {
		System.out.println(p.test(s) ? "Woman" : "Man");    // 내가 정의한 내용
	}
}