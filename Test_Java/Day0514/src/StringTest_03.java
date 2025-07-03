
public class StringTest_03 {

	public static void main(String[] args) {
		String a = "서울시";
		String b = "서울시";
		String c = new String("서울시");
		
//		System.out.println(a.equals(b));
//		System.out.println(a.equals(c));
		
		System.out.println(a == b);
		System.out.println(a == c);
		
		String e = "abCd";
		String f = "abcd";
		
		int result = e.compareTo(f);	// 양수 : 앞이 더 큼, 음수 : 전이 더 큼, 0 : 동일
		System.out.println(result);

	}

}
