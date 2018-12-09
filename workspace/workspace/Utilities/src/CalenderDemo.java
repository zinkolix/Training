import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalenderDemo {

	public static void main(String[] args) {
//		String[] zones = TimeZone.getAvailableIDs();
//		for (String zone : zones) {
//			System.out.println(zone);
//			
//		}
//		System.out.println("Total Zones: " + zones.length);
		
		TimeZone zone = TimeZone.getTimeZone("GMT");
		Calendar cal = new GregorianCalendar(zone);
		
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.ERA));
		System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
		
		Date dt = new Date();
		System.out.println(dt);

	}

}
