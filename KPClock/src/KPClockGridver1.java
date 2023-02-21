import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.Scanner;
import java.util.TimerTask;

public class KPClockGridver1 {

	public static void main(String[] args) {
		// AM/PM 삭제, 24시
		Scanner sc = new Scanner(System.in);
		System.out.print("AM/PM or 24hours?(24hours = 1 , AM/PM = 2)");
		String choice = sc.nextLine();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Date today = new Date();
				
				TimeZone time;
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd E", Locale.ENGLISH);
				
				time = TimeZone.getTimeZone("");
				df.setTimeZone(time);
				System.out.format("%s%n%s%n%n", time.getDisplayName(), df.format(date));

			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}