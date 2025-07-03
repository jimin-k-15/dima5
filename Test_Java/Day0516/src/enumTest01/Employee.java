package enumTest01;

public enum Employee {
	이몽룡("부장") {
		public String work() {
			return "제품에 대한 R&D";
		}
	},
	성춘향("과장") {
		public String work() {
			return "판매할 제품의 검수";
		}
	},
	김방자("대리") ,
	박향단("사원"),
	변사또("이사") {
		public String work() {
			return "총괄업무 담당";
		}
	};
	
	public String title;
	private Employee(String title) {
		this.title = title;
	}
	public String work() {
		return "완성된 제품을 대리점에 납품";
	}
}
