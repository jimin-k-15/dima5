package exceptTest;

class Parent {
	public int add(int a, int b) throws Exception {
		if(a <= 0 || b <= 0) {
			throw new Exception("0 이하의 값은 연산할 수 없음");
		}
		return a + b;
	}
}


class Child extends Parent {
	@Override 
	public int add(int a, int b) throws Exception  {
		if(a <= 10 || b <= 10) {
			throw new Exception("10 이하의 값은 연산할 수 없음");
		}
		return a + b;
	}
	
}


public class ExceptionTest_03 {

	public static void main(String[] args) {
		Child c = new Child();
	
		try {
			System.out.println(c.add(10, 20));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
