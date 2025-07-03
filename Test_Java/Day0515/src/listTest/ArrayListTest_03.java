package listTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest_03 {

	public static void main(String[] args) {
//		Employee[] empList = new Employee[100];
		List<Employee> list = new ArrayList<>();
		
		// 1) 직원 데이터 저장
		list.add(new Employee(1, "손오공", 3800, "기획팀"));
		list.add(new Employee(2, "저팔계", 3750, "영업팀"));
		list.add(new Employee(3, "사오정", 4900, "전산팀"));
		list.add(new Employee(1, "이몽룡", 8700, "고객응대팀"));
		
		// 2) 직원수
		System.out.println("직원 수: " + list.size());
		
		// 3) 전직원 출력
		list.forEach((emp) -> System.out.println(emp));
		
		// 4) 사원번호가 3번인 직원의 정보 조회
		for(int i=0; i< list.size(); ++i) {
			if(list.get(i).getEmpId() == 3) {
				System.out.println(list.get(i));
				break;
			}
		}
		
		// 5) 이름이 "이몽룡"인 직원을 검색 -> 이름만으로는 검색 불가능
		//	  Employee 클래스 내부에 equals()가 오버라이드 되어 있어야 사용 가능
		// 	  contains 메소드 내에서 equals()를 호출하는 코드가 있다!
		boolean b = list.contains(new Employee(4, "이몽룡", 0, null));
		System.out.println(b);
	}

}
