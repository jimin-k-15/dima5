package net.dima.ajax1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.dima.ajax1.dto.CustomerDTO;
import net.dima.ajax1.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository repository;
	
	public void insert(CustomerDTO dto) {
		// todo
	}
	
	public List<CustomerDTO> selectAll() {
		return null;
	}
	
	public void delete(Integer seq) {
		
	}
}
