package net.dima.test4.dto;

public record FitnessRecord (
		Integer id,
		String name,
		String gender,
		double height,
		double weight
	) {
	public FitnessRecord {
		if(id == null) id = null;  
	}	
}
