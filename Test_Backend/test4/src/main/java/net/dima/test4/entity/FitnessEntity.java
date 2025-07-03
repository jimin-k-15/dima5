package net.dima.test4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.test4.dto.FitnessRecord;

@Entity
@Table(name="fitness")  // class 이름과 table 이름이 다를 경우 필수
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FitnessEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // AUTO_INCREMENT
	private Integer id;
	
	@Column(name="name", nullable = false)  // 이하 동일
	private String name;
	private String gender;
	private double height;
	private double weight;
	
	public static FitnessEntity toEntity(FitnessRecord fitness) {
		return FitnessEntity.builder()
				.id(fitness.id())
				.name(fitness.name())
				.gender(fitness.gender())
				.height(fitness.height())
				.weight(fitness.weight())
				.build();
	}
}
