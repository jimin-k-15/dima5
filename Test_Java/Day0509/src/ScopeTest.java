
public class ScopeTest {
	int data = 100;		// 인스턴스 변수 : 선언된 클래스가 생성되면  
	
	public static void main(String[] args) {
		int data = 10; 		// 지역변수의 scope은 선언된 메소드 내부
		
		System.out.println(data);
		
		{
			int data2 = 15; 
			System.out.println(data2);
			System.out.println(data);
		}	
		
		ScopeTest st = new ScopeTest();
		System.out.println(st.data);

	}

}
