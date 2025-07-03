package baseball.sevice;

import java.util.ArrayList;

import baseball.vo.Batter;
import baseball.vo.Pitcher;
import baseball.vo.Player;

/**
 * 데이터의 처리를 담당
 */
public class BaseballServiceImpl implements BaseballService {
	/**
	 * 선수 정보를 저장할 리스트
	 */
	private ArrayList<Player> playerList;
	
	/**
	 * 생성자
	 */
	public BaseballServiceImpl () {
		playerList = new ArrayList<Player>();
		
		//기존 저장된 파일이 있으면 열어서 읽는다.
		//저장된 파일이 없으면 새로운 리스트를 생성한다.
	}

	/**
	 * 전달받은 번호를 리스트에서 검색한다. 
	 * @param id 검색할 선수 번호
	 * @return 있으면 선수 정보, 없으면 null
	 */
	@Override
	public Player searchId(String id) {
		for(int i=0; i<playerList.size(); ++i) {
			Player player = playerList.get(i);
			String searchedId = player.getId();
			
			if(id.equals(searchedId)) return player;
		}
		
		return null;
	}
	
	/**
	 * 전달받은 Player객체를 리스트에 추가저장한다.
	 * @param player 리스트에 추가할 Player객체
	 * @return 중복되지 않은 번호를 가진 정보가 리스트에 추가되면 true, 그렇지 않으면 false
	 */
	@Override
	public boolean insertPlayer(Player player) {
		return playerList.add(player);
	}

	/**
	 * 선수 번호를 이용해 해당 선수 정보를 리스트에서 삭제하고 true를 리턴한다.
	 * 없는 선수 번호인 경우에는 false를 리턴한다.
	 * @param id 삭제할 선수 번호
	 * @return boolean 삭제 여부 리턴 (삭제 완료 시 true, 삭제 실패 시 false)
	 */
	@Override
	public boolean deletePlayer(String id) {
		Player player = null;
		
		for(int i=0; i<playerList.size(); ++i) {
			player = playerList.get(i);
			String pid = player.getId();
			
			if(pid.equals(id)) {
				playerList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 선수 번호와 연봉을 전달받아 해당 선수의 연봉을 수정한다.
	 * @param player 수정할 연봉금액과 선수번호가 포함된 객체
	 * @return 수정 여부
	 */
	@Override
	public boolean updatePlayer(Player player) {
		Player findPlayer = null;
		String findId = player.getId();
		
		for(int i=0; i<playerList.size(); ++i) {
			findPlayer = playerList.get(i);
			if (findId.equals(findPlayer.getId()) ) {
				playerList.get(i).setSalary(player.getSalary()); // 바뀐 연봉으로 수정
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 최소금액과, 최대금액을 전달받아 그 영역사이의  연봉을 받는 선수 목록을 리턴한다.
	 * @param minSalary 최소값
	 * @param maxSalary 최대값
	 * @return 지정한 금액 범위의 연봉을 받는 선수들의 목록
	 */
	@Override
	public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {
		ArrayList<Player> selectPlayer = new ArrayList<>();
		Player player = null;
		
		for(int i=0; i<playerList.size(); ++i) {
			player = playerList.get(i);
			int salary = player.getSalary();
			
			if(salary >= minSalary && salary <= maxSalary);
				selectPlayer.add(player);
		}	
		
		return selectPlayer;
	}

	/**
	 * WAR기준으로 가장 높은 선수목록을 출력한다. 같은 값이 여러 명인 경우에는 모두.
	 * @return 선수 목록
	 */
	@Override
	public ArrayList<Player> bestPlayers() {
		ArrayList<Player> bestPlayer = new ArrayList<>();
		Player player = null;
		int cnt = 0;
		
		for(int i=0; i<playerList.size(); ++i) {
			player = playerList.get(i);
			
			for (int j=0; j<playerList.size(); ++j) {
				if(player.getWar() < playerList.get(j).getWar()) {
					cnt++;
				}
			}
			
			// player보다 기여도가 큰 선수가 없으면 현재 player가 기여도가 가장 높다고 볼 수 있다. 
			if(cnt == 0) bestPlayer.add(player);  
		}
		
		return bestPlayer;
	}

	/**
	 * 전달된 타입의 선수목록을 리턴한다.
	 * @param 선수 타입 (1:전체 2:투수 3:타자)
	 * @return 검색된 선수 목록
	 */
	@Override
	public ArrayList<Player> playerListForType(int type) {
		ArrayList<Player> selectPlayer = new ArrayList<>();
		Player player = null;
		
		for(int i=0; i<playerList.size(); ++i) {
			player = playerList.get(i);
			
			switch(type) {
			case 1: // 전체 정보 반환
				selectPlayer.add(player);
				break;
			case 2: // 투수 정보
				
				if(player instanceof Pitcher) 
					selectPlayer.add(player);
			
				break;
			case 3: // 타자 정보
				if(player instanceof Batter) 
					selectPlayer.add(player);
					
				break;
			}
		}		
				
		return selectPlayer;
	}
	
}

