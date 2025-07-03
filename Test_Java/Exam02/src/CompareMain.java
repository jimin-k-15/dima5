import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CompareMain {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		List<Person> list = Arrays.asList(
				new Person("김홍도", 45), 
				new Person("박지원", 12), 
				new Person("신윤복", 31),
				new Person("유형원", 27), 
				new Person("정약용", 51)); 
		
		while (true) {
			int choice;
			System.out.print("1. 이름순    2. 나이순    0. 종료  ==> ");
			choice = keyin.nextInt();

			switch (choice) {
			case 1: {
				// 이름순 정렬
				Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()) > 1 ? 1
											   : a.getName().compareTo(b.getName()) < -1 ? -1 : 0); 
				list.forEach((x) -> System.out.println(x));
				System.out.println();
				break;
			}
			case 2: {
				// 나이순 정렬
				Collections.sort(list, (a, b) -> a.getAge() < b.getAge() ? 1 			// b.getAge - a.getAge의 부호가 양수, 음수, 0을 반환하도록 해도 됨. 
						   					   : a.getAge() > b.getAge() ? -1 : 0);
				list.forEach((x) -> System.out.println(x));
				System.out.println();
				break;
				
			}
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}	

}
	

//	public static void printAge(List<Person> list) {
//		
//	}
//
//
//	private static void printName(List<Person> list) {
//
//	}	

