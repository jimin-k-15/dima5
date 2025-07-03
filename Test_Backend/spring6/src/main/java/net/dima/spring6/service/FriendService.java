package net.dima.spring6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring6.dto.FriendDTO;
import net.dima.spring6.dto.FriendResp;
import net.dima.spring6.entity.FriendEntity;
import net.dima.spring6.repository.FriendRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendService {
	private final FriendRepository repository;
	
	public void regist(FriendDTO friendDTO) {
		log.info("{}", friendDTO.toString());
		FriendEntity entity = FriendEntity.toEntity(friendDTO);
		
		repository.save(entity);
	}

	public FriendResp selectOne(Integer id) {
		FriendResp real = null;
		
		Optional<FriendEntity> entity = repository.findById(id);
		
		if (entity.isPresent()) {
			real = FriendResp.toFriendResp(entity.get());
			log.info("조회완료된 Entity: {}", real.toString());
		} else {
			log.info("데이터가 존재하지 않습니다.");
		}
		
		return real;
		}

	public List<FriendResp> selectAll() {
		List<FriendResp> fList = new ArrayList<>();
		List<FriendEntity> list = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		
		// entity -> resp
		list.forEach((friend) -> fList.add(FriendResp.toFriendResp(friend)));
		
		return fList;
	}

	public void delete(Integer id) {
		Optional<FriendEntity> temp = repository.findById(id);
		
		if(temp.isPresent()) {
			// 삭제하기 전 id의 데이터가 DB에 존재하는지 확인할 것!
			repository.deleteById(id);
		}
		
	}
	
	@Transactional
	public void update(FriendDTO dto) {
		Optional<FriendEntity> temp = repository.findById(dto.id());
		
		if(temp.isPresent()) {
			FriendEntity entity = FriendEntity.toEntity(dto);
			
			repository.save(entity);  
		}
	}
}


/*
 * C - save(entity) -- PK가 동일한게 없으면 
 * R - findAll(), findById(id)
 * U - save(entity) -- PK가 동일한게 있으면
 * D - deleteById(id)
 */

