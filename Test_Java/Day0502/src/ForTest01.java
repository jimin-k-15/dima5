/*
 * for문을 이용해서 알파벳 대문자 출력
 * 		ABCDEFGHIJKLMN...Z
 */
public class ForTest01 {

	public static void main(String[] args) {
		
//		for(int j=65; j<75; ++j) {  // 아래 2개의 문장을 한 묶음으로 보고, 이 묶음을 10번 반복.
//									// 시작 값을 j=0으로 하는 게 일반적이지만, 이렇게도 가능하고 90과 100도 가능.
//			for(char i='A'; i <= 'Z'; ++i)  // char i=(char)j라고 하는 것도 가능하지만, 이 경우 반복 횟수가 달라짐.
//				System.out.print(i);
			
		for(char j='A'; j<='Z'; ++j) {
			for(char i = j; i <= 'Z'; ++i) // for문에 진입할 때 다시 초기화
				System.out.print(i);
			
			System.out.println(); // char i 변수는 for문을 벗어나면 사라짐! 
		
			
//			System.out.println(); // for문 안에 있지만, 중괄호가 생략된 것이지 for문과는 무관함	
		}
	}
		
		
//		for(char i='A'; i <= 'Z'; ++i) 
//			System.out.print(i); // A-Z까지 한 줄 전체를 세 번 반복하는 코드 (중간에 줄바꿈해가면서)
//		
}

