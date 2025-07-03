import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest_01 {

	public static void main(String[] args) {
		Date date = new Date();
		int year = date.getYear();
		System.out.println(year);
		
		// Calendar c;  
		Calendar gc = new GregorianCalendar();
		Calendar gc1 = Calendar.getInstance();
		
		System.out.println(gc);
		System.out.println(gc1);
		
		System.out.println(Calendar.HOUR + "시 " + Calendar.MINUTE + "분 " + Calendar.SECOND + "초");
		
	}

}
