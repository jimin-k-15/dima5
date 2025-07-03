package net.dima.spring7.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

//부모 (1)
@Entity
@Table(name="departments")
@Data
public class DepartmentEntity {
	@Id
	@Column(name="department_id")
	private Integer departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)  // One = departments, Many = employees
	private List<EmployeeEntity> employees;
}
