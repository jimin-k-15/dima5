package net.dima.ajax1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.ajax1.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
