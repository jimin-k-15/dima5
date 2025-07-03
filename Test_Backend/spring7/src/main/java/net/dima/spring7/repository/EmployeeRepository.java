package net.dima.spring7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.spring7.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}
