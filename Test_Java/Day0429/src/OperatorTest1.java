/* 1) 피연산자의 개수
 * 		- 단항(Unary)  : 피연산자가 한 개
 * 		- 이항(Binary) : 피연산자가 두 개 
 * 		- 삼항(Tenary) : 피연산자가 세 개
 * 
 *  2) 연산의 결과값에 따라
 *  	- 산술연산: + - * / %
 *  	- 비교연산: >(greater than, 초과) <(less than, 미만) >= (greater equal, 이상) <= (less equal, 이하) 
 *  				== (equal, 동일) != (not equal, 같지 않다)
 *  	- 논리연산: && || ! (단항연산)
 *  
 *  		(할인은) 65세 이상, 8세 미만 
 *  		 정상가  8 ~ 65
 *   
 */
public class OperatorTest1 {

	public static void main(String[] args) {
		// 15세 이상은 청소년, 미만은 어린이라고 출력하시오 
		
		int age = 15;
		
		if(age >= 15) System.out.println("청소년");
		else		  System.out.println("어린이");
		
		// -------- 논리연산 : 할인은 65세 이상, 8세 미만
		int fee = 35000;
		
		if ( age >= 8  &&  age < 65 ) System.out.println("입장료: " + fee);
		else 						  System.out.println("입장료: " + (int)(fee * 0.2));
		
		if (!(age < 8  || age >= 65)) 
			System.out.println("입장료: " + fee);
		else 						  
			System.out.println("입장료: " + (int)(fee * 0.2));
			
		
	}

}

