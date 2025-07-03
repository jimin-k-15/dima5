package baseball.sevice;

import java.util.ArrayList;

import baseball.vo.Player;

/**
 * BaseballManager에서 구현할 인터페이스 정의
 */
public interface BaseballService {
	/**
	 * 전달받은 번호를 리스트에서 검색한다. 
	 * @param id 검색할 선수 번호
	 * @return 있으면 선수 정보, 없으면 null
	 */
	public Player searchId(String id);

	/**
	 * 전달받은 Player객체를 리스트에 추가저장한다.
	 * @param player 리스트에 추가할 Player객체
	 * @return 중복되지 않은 번호를 가진 정보가 리스트에 추가되면 true, 그렇지 않으면 false
	 */
	public boolean insertPlayer(Player player);
	
	/**
	 * 선수 번호를 이용해 해당 선수 정보를 리스트에서 삭제하고 true를 리턴한다.
	 * 없는 선수 번호인 경우에는 false를 리턴한다.
	 * @param id 삭제할 선수 번호
	 * @return boolean 삭제 여부 리턴 (삭제 완료 시 true, 삭제 실패 시 false)
	 */
	public boolean deletePlayer(String id);
	
	/**
	 * 선수 번호와 연봉을 전달받아 해당 선수의 연봉을 수정한다.
	 * @param player 수정할 연봉금액과 선수번호가 포함된 객체
	 * @return 수정 여부
	 */
	public boolean updatePlayer(Player player);
	
	/**
	 * 최소금액과, 최대금액을 전달받아 그 영역사이의  연봉을 받는 선수 목록을 리턴한다.
	 * @param minSalary 최소값
	 * @param maxSalary 최대값
	 * @return 지정한 금액 범위의 연봉을 받는 선수들의 목록
	 */
	public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary);
	
	/**
	 * WAR기준으로 가장 높은 선수목록을 출력한다. 같은 값이 여러 명인 경우에는 모두.
	 * @return 선수 목록
	 */
	public ArrayList<Player> bestPlayers();
	
	/**
	 * 전달된 타입의 선수목록을 리턴한다.
	 * @param 선수 타입 (1:전체 2:투수 3:타자)
	 * @return 검색된 선수 목록
	 */
	public ArrayList<Player> playerListForType(int type);
	
}
