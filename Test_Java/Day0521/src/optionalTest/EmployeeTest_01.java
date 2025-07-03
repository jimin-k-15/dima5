package optionalTest;

import java.util.Optional;

public class EmployeeTest_01 {

	public static void main(String[] args) {
		Department d = new Department("홍보팀", "서울시 동작대로 125", "06045");
		Employee e = new Employee(123L, "저팔계", 8500, d);
		
		// e 변수를 통해 부서명을 꺼내어 출력
		String dname = getDepartmentNameOfEmployee(e);
		System.out.println(dname);
		
	}

	private static String getDepartmentNameOfEmployee(Employee e) {
		if(e == null) return "Null 데이터(직원정보)가 전달됨";
		Department dd = e.getDept();
		
		if(dd == null) return "부서정보가 없습니다.";
		
		return dd.getDepartName();
	}
	
	
	// 여기서부터 띄워주신 pdf 보고 받아적은 부분
	
	String departName2 = findDepartmentNameofEmployee(null);
	// System.out.println(departName2);		// 왜 에러 뜨는지 모르겠음 . . . 
	
	/* 직원이 근무하고 있는 부서명을 조회한다. */
	// null인지 여부를 확인하기 위해 if 대신 Optional 클래스 사용 
	public static String findDepartmentNameofEmployee(Employee employee) {
		Optional<Employee> emp = Optional.ofNullable(employee);
		Optional<Department> address = emp.map(Employee::getDept);
		Optional<String> deptName = address.map(Department::getDepartName);
		String result = deptName.orElse("부서명 검색 실패");
		
		return result;
	}
}
