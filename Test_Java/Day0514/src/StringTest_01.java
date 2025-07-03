
public class StringTest_01 {

	public static void main(String[] args) {
		String str = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
		// contains : 
		boolean result = str.contains("물");
		System.out.println(result);

		int index = str.indexOf('이');
		System.out.println(index);
		
		index = str.lastIndexOf('이');
		System.out.println(index);
		
		String str2 = "** 무궁화 삼천리 화려강산";
		
		String temp = String.join("\n", str, str2);
		System.out.println(temp);
		
		String str3 = str2.replace("무궁화", "개나리");
		System.out.println(str3);
		System.out.println(str2);	// immutable한 데이터는 원본을 바꿀 수 없다.
		
		String[] arr = str.split(" ");
		System.out.println(arr[0]);
		System.out.println(arr.length);
		
		String str4 = " 1234 ";
		System.out.println(str4.trim().length());	// 앞뒤 공백 제거해서 길이가 4
		
		// Primitive 데이터를 문자열로 변환
		int data = 25;
		String str5 = String.valueOf(data);
		System.out.println(str5 + " / " + str5.getClass());		// getClass(): Object가 물려준 그대로 사용
		
		// 문자열을 Primitive 데이터로 변환하려면?
		String sub1 = "98";
		String sub2 = "85";
		
		int total = Integer.parseInt(sub1) + Integer.parseInt(sub2);
		System.out.println("합의 결과: " + total);
		
		String sub3 = "98.5";
		String sub4 = "85.1";
		
		double total2 = Double.parseDouble(sub3) + Double.parseDouble(sub4);
		System.out.println("합의 결과: " + total2);
		// 파싱하여 숫자로 변환하려면 Wrapper 클래스()를 이용해야 한다.
		/*
		byte 	= Byte
		short 	= Short
		int  	= Integer
		long 	= Long
		char 	= Character
		boolean = Boolean
		float 	= Float
		double 	= Double
		
		
		*/
		// String: 변경 불가능한 데이터
		String str6 = "나리 나리";
		String str7 = str6 + "개나리 " + "입에 " + "따다 물고요";	// ==> StringBuffer	
		// String으로 + 연산하는 것은 비추천. + 하나가 객체를 여러 개 생성하는 것처럼 동작하기 때문에 JVM의 성능 저하됨 
		
	}

}
