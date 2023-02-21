import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class London {
	public static void main(String[] args) {
		while(true) {
		TimeZone time;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd\nHH:mm:ss");
		time = TimeZone.getTimeZone("Europe/London");
		df.setTimeZone(time);
		System.out.format("%s%n", df.format(date));
			
		try {
			Thread.sleep(1000);		// 1초마다 실행
		}catch(Exception e) {}
		}
	}
}
