package fitness.service;

import java.util.List;
import fitness.vo.FitnessVO;

public interface FitnessService {
	public void create(FitnessVO fitness) throws Exception;	
	public FitnessVO retrieve(int id) throws Exception;
	public void update(FitnessVO fitness) throws Exception;
	public void delete(int id) throws Exception;
	public List<FitnessVO> retrieveAll();
	
}
