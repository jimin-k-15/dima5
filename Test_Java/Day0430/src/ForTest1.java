/*
 * 코드값 0 ~ 127까지의 값에 해당하는 문자를 출력하시오.
 * 단, 5개를 한 줄로 출력하시오.
 * 
 * \n : new line
 * \r : carriage return
 * \t : tab
 * \b : back
 * \r\n : 자바에서는 엔터로 인식
 * 
 * 0  1  2  3  4
 * 5  6  7  8  9
 * 
 * 
 * 0: x    1: x    2: x    3: x    4: x
 * ...
 * 65: A   66: B   67: C ....
 * 
 * 
 * 97: a
 * 127
 * 
 */
public class ForTest1 {

//	public static void main(String[] args) {
//		for(int i=0; i<10; ++i) {
//			System.out.println(i);
//		}
	
	public static void main(String[] args) {
		for(int i=0; i<=127; ++i) {
			System.out.print(i + " : " + (char)i + "\t");
			if((i+1) % 5 == 0) System.out.println();
		}
	}
}


// a: 97, A: 65, ' ':32,
// 