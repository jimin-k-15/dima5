package lambdaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		Comparator<Student> c = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getScore() > o2.getScore()) return -1;
				else if(o1.getScore() < o2.getScore()) return 1;
				
				return 0;
			}
		};
				
		Student boy  = new Student("이철수", 85);
		Student girl = new Student("홍영희", 80);
		
		// 누가 큰 값인가? 이름으로 비교할 경우 가나다 순서 이철수 < 홍영희
		// 누가 큰 값인가? 성적으로 비교할 경우 가나다 순서 홍영희 < 이철수
		// 객체를 비교하고 싶다. 
		//		==> VO 클래스 안에서 비교할 수 있는 인터페이스를 구현해놓아야 한다. 
		//			Comparable(x), Comparator(o)
		
		int result = boy.compare(boy, girl);	// boy.compare 이렇게 객체 레퍼런스가 있어야 compare를 호출할 수 있다.
		System.out.println(result);
		
		// ---------- 성적순서대로 학생들 정렬하기
		// List를 만드는 방법
		// 1) new로 생성한 후 add()로 추가 --> mutable한 자료구조
		// 2) Arrays.asList()로 추가 --> mutable한 자료구조
		// 3) List.of()로 추가 --> immutable한 자료구조
		List<Student> list  = Arrays.asList(
					new Student("이철수", 85),
					new Student("홍영희", 95),
					new Student("이정후", 88),
					new Student("강정호", 90),
					new Student("박찬호", 75)
				);  								// mutable
		
		List<Student> list2 = List.of();            // immutable
		
//		Collections.sort(list, c);
		
		// 성적 순 정렬 
		// ** 시험 출제 ** 
		Collections.sort(list, (a, b) -> a.getScore() < b.getScore() ? 1
									   : a.getScore() > b.getScore() ? -1 : 0); // 오름차순, 내림차순 바꾸고 싶으면 부등호 방향 바꾸기
		
		list.forEach((x) -> System.out.println(x));
		System.out.println();
		
		// 이름 순 정렬 (문자열 클래스에 정의된 compareTo() 메소드를 사용하시오)
		Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()) > 1 ? 1
									   : a.getName().compareTo(b.getName()) < -1 ? -1 : 0); // 오름차순
		
		list.forEach((x) -> System.out.println(x));
		System.out.println();
		
	}

}
