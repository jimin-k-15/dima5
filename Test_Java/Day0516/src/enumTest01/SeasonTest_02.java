package enumTest01;

public class SeasonTest_02 {

	public static void main(String[] args) {
		Season s = Season.가을;
		
		switch(s) {
		case Season.봄   : System.out.println("Spring"); break;
		case Season.여름 : System.out.println("Summer"); break;
		case Season.가을 : System.out.println("Fall")  ; break;
		case Season.겨울 : System.out.println("Winter"); break;
		}
	}
}
