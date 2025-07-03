package fitness.service;

import java.util.List;
import fitness.vo.FitnessVO;

public interface FitnessService {
	public void create(FitnessVO fitness) throws Exception;	
	public FitnessVO retrieve(int id) throws Exception;
	public void update(FitnessVO fitness) throws Exception;
	public void delete(int id) throws Exception;
	public List<FitnessVO> retrieveAll();
	
	public void loadFile();		// 읽기 : 프로그램이 구동되자마자
	public void saveFile(); 	// 쓰기 : 프로그램 종료 직전에 
}
