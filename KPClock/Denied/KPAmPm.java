import java.util.Calendar;

public class KPAmPm {
	
	Calendar now = Calendar.getInstance();
	
	int year 	= now.get(Calendar.YEAR);
	int month 	= now.get(Calendar.MONTH) + 1;
	int day 	= now.get(Calendar.DAY_OF_MONTH);
	int week 	= now.get(Calendar.DAY_OF_WEEK);
	
	int hour 	= now.get(Calendar.HOUR);
	int minute = now.get(Calendar.MINUTE);
	int second	= now.get(Calendar.SECOND);
	
	String strWeek = null;
	public void AmFm() {
		switch(week) {
		case Calendar.MONDAY: 		strWeek = "월"; break;
		case Calendar.TUESDAY:	 	strWeek = "화"; break;
		case Calendar.WEDNESDAY: 	strWeek = "수"; break;
		case Calendar.THURSDAY: 	strWeek = "목"; break;
		case Calendar.FRIDAY: 		strWeek = "금"; break;
		case Calendar.SATURDAY: 	strWeek = "토"; break;
		default: 					strWeek = "일";
	}
	
		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "AM";
		} else {
			strAmPm = "PM";
		}
	}
}