package dateTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatTest {

	public static void main(String[] args) {
		// Date 클래스, Calendar 클래스는 프로그램 내에서 직접 사용하는 경우는 드물다.
		// Date 클래스의 메소드들은 대부분 deprecated 되었기 때문에 쓰지 않는 게 좋다. 
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
				
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
		String dateStr = ldt.format(form);
		System.out.println(dateStr);
	}
			
}


