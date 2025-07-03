import java.util.Random;

public class RandomTest_01 {

	public static void main(String[] args) {
		Random rand = new Random(1);  // java.lang.* 
		
		rand.setSeed(10);
		for(int i=0; i<10; ++i)
			System.out.println(rand.nextInt(46));

	}

}
