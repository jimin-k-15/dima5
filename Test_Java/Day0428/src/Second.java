// Source Code(*.java) ---(compile:저장하면 자동 컴파일) ---- Byte code (*.class)  ---- Build 
/*
 * 각종 데이터 출력해보기
 */
public class Second {
	public static void main(String[] args) {
		// 값, Literal 
		System.out.print("KITA DIMA 5기");	 // 문자열 
		System.out.println("2025년 4월 28일");
		System.out.println("월요일");
		System.out.println();
		System.out.println(3.14195);         // 실수(double) 
		System.out.println(15);              // 정수(int)
		System.out.println(true);            // 진위형(boolean) 
		System.out.println('♥');             // 문자(char) 홑따옴표 안에 하나의 문자 --> 컴퓨터 내부에서는 숫자로 변경됨
		System.out.println(42.195F);         // 실수(float) 
		System.out.println(25L);             // 정수(long) 
		System.out.println();
		System.out.println(5 * 10);          // int * int ==> int. 연산을 할 때에는 데이터 타입이 중요
	}
}
