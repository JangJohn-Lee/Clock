import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JPClockGridver2 {
	// 기존 타임존을 사용을 사용한 기본 페이지
	// Seoul을 테스트
	public static void main(String[] args) {
		while(true) {
		TimeZone time;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd\nHH:mm:ss (z Z)");
		int num = Integer.parseInt(df.format(date).toString().substring(11,13));

		time = TimeZone.getTimeZone("Asia/Seoul");
		df.setTimeZone(time);
		System.out.format("%s%n%s%n%n", time.getDisplayName(),
				df.format(date));
		
		try {
			Thread.sleep(1000);		// 1초마다 실행
		}catch(Exception e) {}
		}
	}
}