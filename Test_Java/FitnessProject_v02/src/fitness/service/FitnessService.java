package fitness.service;

import fitness.vo.FitnessVO;

public class FitnessService {
	FitnessVO[] list = new FitnessVO[3]; 
	int count = 0; // 몇 명의 회원이 있는지 알아보기 위한 count 변수
	
	/**
	 * create : 회원 한 사람의 정보를 전달받아 배열에 저장 
	 * @param fitness
	 * @return 등록여부를 반환
	 */
	public boolean create(FitnessVO fitness) {
		int id = fitness.getId();
		
		// 회원가입이 안 되는 경우: 자리가 없어서... count == 100
		if(count >= list.length) return false;
		// 							동일한 아이디가 존재하면 
		
		// count => 10
		
		for(int i=0; i<count; ++i) {
			if(list[i].getId() == id) return false;
		
		}
		
		list[count++] = fitness;
		count++; 
		
		return true;
	}
	
	/**
	 * retrieve : Primary Key에 해당하는 id를 전달받아 그 id의 회원정보를 검색하여 반환
	 * @param id: PK
	 * @return 찾은 한 사람의 정보, null이 반환되면 조회하려는 회원이 없음
	 */
	public FitnessVO retrieve(int id) {
		
		for(int i=0; i<count; ++i)
			if(list[i].getId() == id) return list[i]; // i번째 방에 내가 원하는 회원 정보가 있는 경우
		
		return null;
	}
	
	/**
	 * update : 전달받은 멤버의 정보를 수정하는 메소드
	 * @param fitness: 수정할 정보를 담고 있는 객체
	 * @return 수정 결과를 반환
	 */
	public boolean update(FitnessVO fitness) {
		int id = fitness.getId();
		
		// 수정하려는 회원 정보를 찾아서 찾게 되면 수정
		for(int i=0; i<count; ++i) {
			if(list[i].getId() == id) {
				// 키, 몸무게 수정 
//				double h = fitness.getHeight();		// 수정될 값
//				double w = fitness.getWeight();		// 아래와 같이 직접 대입하면 코드 축약 가능
				
				list[i].setHeight(fitness.getHeight());	// 목록에서 특정 정보를 찾아서 키를 수정
				list[i].setWeight(fitness.getWeight());	// 목록에서 특정 정보를 찾아서 몸무게를 수정
				
				return true; 	// 수정 완료되면 true를 반환
			}
		}
			
		return false;	// id가 잘못된 경우 false를 반환
	}
	
	/**
	 * delete : 탈퇴할 회원의 PK를 전달받아 목록에서 삭제
	 * @param id: 탈퇴할 회원의 PK
	 * @return : 삭제결과 반환
	 */
	public boolean delete(int id) {
		
		// 삭제하려는 회원 정보를 찾아서 찾게 되면 삭제
		for(int i=0; i<count; ++i) {
			if(list[i].getId() == id) {
				// 뒷사람의 정보를 앞으로 이동 
				if(i < count-1) {	// **마지막 요소가 아니라면 for문, 마지막 요소라면 count만 감소** 잘 봐두기!
					for(int j=i; j<count; ++j) {
						list[j] = list[j+1];	// j가 마지막 데이터의 인덱스일 경우 j+1에서 오류 발생
					}
				}
				--count;
				return true; 	// 삭제 완료되면 true를 반환
			}
		}	
		
		return false;
	}
	
	/**
	 * 회원 전체의 목록을 조회할 수 있도록 배열을 반환
	 * @return 회원 목록
	 */
	public FitnessVO[] retrieveAll() {
		return list;
	}
	
	/**
	 * 현재 등록된 회원의 수 
	 * @return 수정 결과를 반환
	 */
	public int getCount() {
		return count;
	}
	
}
