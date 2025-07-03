/*
 * Ctrl + S : 저장
 * Ctrl + space : 자동완성
 * Ctrl + F11 : 실행
 * Ctrl + a : 전체 선택 
 * Ctrl + i : 들여쓰기
 * Ctrl + d : delete 한 줄 삭제 
 * Ctrl + z : undo
 * Ctrl + y : redo 
 */
public class Fifth {
	public static void main(String[] args) {
		// 1) 지역변수 선언, 초기화
		int radius = 5;
		final double PI = 3.14;  // 상수변수 
		
		double area = PI * radius * radius;
		
		System.out.println("반지름 5인 원의 면적 : " + area);
	}
}
