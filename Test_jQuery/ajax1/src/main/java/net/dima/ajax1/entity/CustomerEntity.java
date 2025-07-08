package net.dima.ajax1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.ajax1.dto.CustomerDTO;

@Entity
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seq;
	private String name;
	private String phone;
	private String gender;
	private String location;
	
	// DTO --> CustomerEntity로 반환
	public static CustomerEntity toEntity(CustomerDTO dto) {
		return CustomerEntity.builder()
				.seq(dto.getSeq())
				.name(dto.getName())
				.phone(dto.getPhone())
				.gender(dto.getGender())
				.location(dto.getLocation())
				.build();
	}
}
