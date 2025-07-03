
public class SwitchTest1 {

	public static void main(String[] args) {
		int score = 100;
		String clz = null;
		
		switch(score/10) {
		case 10: 
		case 9: clz = "A"; break;
		case 8: clz = "B"; break;
		case 7: clz = "C"; break;
		case 6: clz = "D"; break;
		default : clz = "F"; break;
		}
		System.out.println(clz);
		
		// ==================
		String family = "누구?";
		
		switch(family) {
		case "Father" : case "father" : System.out.println("아빠"); break;
		case "Mother" : case "mother" : System.out.println("엄마"); break;
		case "Sister" : case "sister" : System.out.println("시스터"); break;
		case "Brother" : case "brother" : System.out.println("브라더"); break;
		default : System.out.println("누구세요??");
		
		}
		
		
	}

}
