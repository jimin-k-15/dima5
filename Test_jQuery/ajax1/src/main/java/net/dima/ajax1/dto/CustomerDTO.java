package net.dima.ajax1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.ajax1.entity.CustomerEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	private Integer seq;
	private String name;
	private String phone;
	private String gender;
	private String location;
	
	// Entity --> DTO
	public static CustomerDTO toDTO(CustomerEntity entity) {
		return CustomerDTO.builder()
				.seq(entity.getSeq())
				.name(entity.getName())
				.phone(entity.getPhone())
				.gender(entity.getGender())
				.location(entity.getLocation())
				.build();
	} 
}
