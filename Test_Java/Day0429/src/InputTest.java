/*
 * 입력함수: nextInt(), nextDouble(), next(), nextLine()
 * 
 * White Space: 탭, 스페이스, 엔터 (입력 버퍼 내의 데이터를 변수로 이동) 
 * 
 * "123.5	"
 * 
 * 문자열 입력받는 메소드 (next(), nextLine())를 사용하여
 * 입력버퍼에 대해 익혀봅시다.
 */

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		String name, addr, phone;
		int age;
		
		System.out.print("이름: ");
		name = keyin.nextLine();      // 단어만 입력받음
		
		System.out.print("나이: ");
		age = keyin.nextInt();        // 버퍼가 비워지게 됨 ===> 엔터  
		
		keyin.nextLine();             // 버퍼를 비우는 역할 
		
		System.out.print("주소: ");
		addr = keyin.nextLine();      
		
		System.out.print("전화번호: ");
		phone = keyin.nextLine();  
		
		System.out.println("너의 이름은: " + name);
		System.out.println("너의 주소: " + addr);
		System.out.println("너의 번호: " + phone);

	}

}
