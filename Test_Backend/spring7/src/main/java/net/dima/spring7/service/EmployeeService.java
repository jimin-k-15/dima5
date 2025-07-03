package net.dima.spring7.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring7.dto.EmployeeResp;
import net.dima.spring7.entity.EmployeeEntity;
import net.dima.spring7.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
	private final EmployeeRepository repository;
	
	public List<EmployeeResp> selectAll() {
		List<EmployeeEntity> temp = repository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));  // findAll() -> 오류 가능성
		List<EmployeeResp> list = new ArrayList<>();
		
		temp.forEach((entity) -> list.add(EmployeeResp.toResp(entity)));
		
		return list;
	}
}
