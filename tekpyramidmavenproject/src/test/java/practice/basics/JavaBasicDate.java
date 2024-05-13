package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasicDate {

	public static void main(String[] args) {
		Date dateObj = new Date();
		//System.out.println(dateObj.toString());
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	     String actualDate	 = sim.format(dateObj);
	     System.out.println(actualDate);
	     
	     Calendar cal = sim.getCalendar();
	     cal.add(Calendar.DAY_OF_MONTH, 30);
	     String dateRequires= sim.format(cal.getTime());
	     System.out.println(dateRequires);

	}

}
