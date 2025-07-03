// FunctionalInterface : 
//		추상메소드는 오로지 1개, default 메소드는 여러 개 가능
// 		Lambda 객체를 만들기 위해서 필요
package lambdaTest;

@FunctionalInterface
interface MyInter2 {
	public void test();
}

public class FunctionalTest {

	public static void main(String[] args) {
		MyInter2  mi = new MyInter2() {

			@Override
			public void test() {
				System.out.println("이것은 펑셔널 인터페이스야!");	
			}
		};
		
		mi.test();
		
		

	}
}
