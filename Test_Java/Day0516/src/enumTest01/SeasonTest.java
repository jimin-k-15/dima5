package enumTest01;

public class SeasonTest {

	public static void main(String[] args) {
		String s  = "봄";
		Season s2 = Season.봄;
		
		s2 = Season.여름;
		
		System.out.println(s + " / " + s.getClass());
		System.out.println(s2 + " / " + s2.getClass());

	}

}
