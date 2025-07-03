package enumTest01;

public enum Skill {
	LANGUAGE("프로그래밍 언어"), ML("머신러닝"),
	ANALYSIS("데이터 분석"), BACKEND("웹서버개발"), FRONTEND("프론트 기술");
	
	String korean;
	
	private Skill (String korean) {
		this.korean = korean;
	}
}
