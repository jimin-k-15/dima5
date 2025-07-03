package enumTest01;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee[] emp = Employee.values();
		
		for(Employee e : emp) {
			System.out.println(e + " => " + e.title + " : " + e.work());
		} 
	}
}
