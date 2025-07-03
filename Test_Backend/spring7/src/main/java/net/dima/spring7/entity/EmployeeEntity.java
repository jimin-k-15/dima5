package net.dima.spring7.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

// 자식 (다)
@Entity
@Table(name="employees")
@Data
public class EmployeeEntity {
	@Id
	@Column(name="employee_id") // 필수!
	private Integer employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName; 
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="hire_date")
	private LocalDate hireDate;
	
	@ManyToOne
	@JoinColumn(name="department_id", referencedColumnName = "department_id")
	private DepartmentEntity department;
	
}
