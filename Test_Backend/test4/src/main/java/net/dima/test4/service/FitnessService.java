package net.dima.test4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.test4.dto.FitnessRecord;
import net.dima.test4.dto.FitnessResp;
import net.dima.test4.entity.FitnessEntity;
import net.dima.test4.repository.FitnessRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class FitnessService {
	private final FitnessRepository repository;
	
	/**
	 * 전달받은 정보를 entity로 변환하여 DB에 저장
	 * @param fitnessRecord
	 */
	public void insert(FitnessRecord fitnessRecord) {
		FitnessEntity entity = FitnessEntity.toEntity(fitnessRecord);
		repository.save(entity);
	}
	
	/**
	 * 모든 회원의 정보를 DB에서 조회
	 * @return
	 */
	public List<FitnessResp> selectAll() {
		// 전체 데이터를 name 순으로 오름차순 정렬해서 조회
		List<FitnessEntity> temp = repository.findAll(Sort.by(Sort.Direction.ASC, "name")); 
		List<FitnessResp> list = new ArrayList<>();
		
		temp.forEach((member) -> list.add(FitnessResp.toFitnessResp(member)));
		
		log.info("변환된 데이터: {}", list.get(0).toString());
		return list;
	}

	/**
	 * 회원 정보 조회
	 * @param id
	 * @return
	 */
	public FitnessResp selectOne(Integer id) {
		Optional<FitnessEntity> temp = repository.findById(id);
		
		if(temp.isPresent()) {
			return FitnessResp.toFitnessResp(temp.get());
		}
		
		return null;
	}

	/**
	 * 회원 정보 삭제
	 * @param id
	 */
	public void delete(Integer id) {
		Optional<FitnessEntity> temp = repository.findById(id);
		
		if(temp.isPresent()) {
			// 삭제하기 전 id의 데이터가 DB에 존재하는지 확인할 것!
			repository.deleteById(id);
		}
		
	}

	/**
	 * 회원 정보 수정
	 * @param id
	 * @param height
	 * @param weight
	 */
	@Transactional
	public void update(Integer id, double height, double weight) {
		Optional<FitnessEntity> temp = repository.findById(id);
		
		if(temp.isPresent()) {
			FitnessEntity entity = temp.get();
			entity.setWeight(weight);
			entity.setHeight(height);
		}
	}
}
