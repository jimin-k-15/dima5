package enumTest01;

public class SeasonTest_03 {

	public static void main(String[] args) {
		// 열거상수 전체를 배열로 반환
		Season[] season = Season.values();
		
		System.out.println("열거상수 개수: " + season.length);
		System.out.println("마지막 데이터: " + season[season.length-1]);
		
		String str = "여름";
		Season s = Season.valueOf(str);

		System.out.println(s+ " / " + s.getClass());
		
		int index = s.ordinal();
		System.out.println(s + "위치 : " + index);
		
		//------------
		Season s2 = Season.겨울;
		String name = s2.name();
		System.out.println(name + " / " + name.getClass());
		
		// 비교
		
		int result = s.compareTo(s2); // 여름과 겨울 비교 (앞의 값이 크면 양수, 앞의 값이 작으면 음수, 같으면 0)
		System.out.println(result < 0 ? "여름이 겨울보다 앞" : "여름이 겨울의 뒤에");
		System.out.println(result);	  // -2이므로 여름이 겨울보다 두 칸 앞
		
		
		
		
		
		
	}
}
