package listTest;

import java.util.Objects;

public class Employee {
	private int empId;
	private String name;
	private int salary;
	private String deptName;
	public Employee() {
	}
	public Employee(int empId, String name, int salary, String deptName) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.deptName = deptName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(deptName, empId, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		
		// 사원번호가 같으면 동일인물이므로 true, 아니면 false
		return this.empId == other.empId && this.name.equals(other.name);
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", deptName=" + deptName + "]";
	}
}
