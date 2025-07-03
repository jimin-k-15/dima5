package net.dima.spring7.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import net.dima.spring7.entity.EmployeeEntity;

@Data
@Builder
public class EmployeeResp {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private LocalDate hireDate;
	private String departmentName;
	
	public static EmployeeResp toResp(EmployeeEntity entity) {
		return EmployeeResp.builder()
				.employeeId(entity.getEmployeeId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.salary(entity.getSalary())
				.hireDate(entity.getHireDate())
				.departmentName(
						entity.getDepartment() != null
						? entity.getDepartment().getDepartmentName()
						: "부서없음"
				)
				.build();
	}
}
