import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTest_01 {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);
		
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		
		LocalDateTime dt = LocalDateTime.of(1945, 8, 15, 10, 20, 30);
		System.out.printf("광복된 날: %s\n", dt);

	}

}
