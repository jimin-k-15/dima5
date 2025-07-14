package net.dima.ajax1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.dima.ajax1.dto.CustomerDTO;
import net.dima.ajax1.entity.CustomerEntity;
import net.dima.ajax1.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository repository;
	
	public void insert(CustomerDTO dto) {
		CustomerEntity entity = CustomerEntity.toEntity(dto);
		repository.save(entity);
	}
	
	public List<CustomerDTO> selectAll() {
		List<CustomerEntity> temp = repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION.ASC, "name"));
		List<CustomerDTO> list = new ArrayList<>();
		
		temp.forEach((entity) -> list.add(CustomerDTO.toDTO(entity)));
		return list;
	}
	
	public void delete(Integer seq) {
		repository.deleteById(seq);
	}
}
