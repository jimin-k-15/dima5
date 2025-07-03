
public class WhileTest1 {

	public static void main(String[] args) {
		int i = 0;
		int total = 0;
		
		while(i++ < 10) total = total + i;
		
		System.out.println("1~10까지의 합계: " + total);
		
		// -----
		i = 0;
		total = 0;
		
		while(true) { 
			++i;
			total = total + i; 
			if(i > 9) break;
		} 

		System.out.println("1~10까지의 합계: " + total);
		
		
	}

}
