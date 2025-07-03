
public class SwitchTest2 {

	public static void main(String[] args) {
		String yoil = "월";
		double cal = 0;
		
		cal = switch(yoil) {
		case "월", "수", "금" :
			System.out.println(yoil +"요일 운동: 에어로빅");
			yield 664.5;
		case "화", "목", "토" :
			System.out.println(yoil +"요일 운동: 수영");
			yield 528;
		default :
			System.out.println(yoil +"요일 운동: 없음");
			yield 1200;
		};

		System.out.println("소비 칼로리: " + cal + "kcal");
	}

}
