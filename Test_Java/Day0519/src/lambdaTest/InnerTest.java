package lambdaTest;

// 상수변수, 추상메소드, static메소드, default메소드 <- interface 안에 들어갈 수 있는 것들
interface MyInter {
	public int add(int a, int b);
}

public class InnerTest {
	public static void main(String[] args) {
		// Anonymous class 
		MyInter inter = new MyInter() {
			@Override								// 한 번 override되면 수정할 수 없음. Anonymous class의 특징
			public int add(int a, int b) {
				return a + b;
			}
			
		};
		
		int result = inter.add(1, 4);
		System.out.println(result);
		
		int data = new MyInter() {			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		}.add(25, 36);
		System.out.println(data);

	}

}
