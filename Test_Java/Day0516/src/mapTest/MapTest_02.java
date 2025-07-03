package mapTest;	// 실행결과 에러 해결해야 함

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest_02 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		Map<Integer, Employee> empList = new HashMap<>();
		
		int empId, salary;
		String name, deptName;
		
		// 1) 직원 데이터 저장
		empList.put(1, new Employee(1, "손오공", 3800, "기획팀"));		// 사원번호 = Key
		empList.put(2, new Employee(2, "저팔계", 3750, "영업팀"));
		empList.put(3, new Employee(3, "사오정", 4900, "전산팀"));
		empList.put(4, new Employee(1, "이몽룡", 8700, "고객응대팀"));
		
		// 2) 직원수 조회 
		System.out.println("직원 수: " + empList.size());
		
		// 3) 직원 번호로 직원을 조회
		System.out.print("직원번호 : ");
		empId = keyin.nextInt();
		Employee emp = empList.get(empId);
		
		System.out.println( (emp != null) ? emp : "번호를 제대로 입력하시오" );
		
		// 4) containsValue를 이용하여 이몽룡 직원의 정보를 출력하시오.
		// 	  containsValue()는 VO 클래스 내부에 equals()가 오버라이딩되어 있어야 함.
		System.out.print("직원번호 : " );
		empId = keyin.nextInt();
		
		System.out.print("직원명 : " );
		name = keyin.next();
		
		boolean result = empList.containsValue(new Employee(empId, name, 0, null));
		System.out.println(result ? "직원 정보 찾음" : "직원 정보가 없음");
		
		if(result)
			System.out.println("찾은 직원 정보: " + empList.get(empId));
		
		System.out.println();
		System.out.println("** 전체 직원 조회");

		// Consumer   : 전달인자 1개, 반환은 void
		// BiConsumer : 전달인자 2개, 반환은 void 
		empList.forEach( (key, value) -> System.out.println("사번: " + key + ", 직원정보: " + value));
		
		// 회사 폐업
		empList.clear();
		System.out.println("남은 직원 없니? " + empList.isEmpty());
		
		
		
		
		
		
		

	}

}
