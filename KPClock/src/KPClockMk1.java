import java.util.*;

public class KPClockMk1 {

	public static void main(String[] args) {
	
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Calendar now = Calendar.getInstance();
				
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH) + 1;
				int day = now.get(Calendar.DAY_OF_MONTH);
				int week = now.get(Calendar.DAY_OF_WEEK);
				
				
				int hour 		= now.get(Calendar.HOUR);
				int minute 		= now.get(Calendar.MINUTE);
				int second		= now.get(Calendar.SECOND);
				
				String strWeek = null;
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
				
				System.out.print(year + "년 ");
				System.out.print(month + "월 ");
				System.out.print(day + "일 ");
				System.out.println(strWeek + "요일");
				System.out.print(strAmPm + " ");
				System.out.print(hour + "시 ");
				System.out.print(minute + "분 ");
				System.out.println(second + "초");
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}