import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class KP24 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("AM/PM or 24hours?(24hours = 1 , AM/PM = 2)");
		String choice = sc.nextLine();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Date today = new Date();
				Locale currentLocale = new Locale("KOREAN", "KOREA");
				String year = "yyyy";
				String month = "MM";
				String day = "dd";
				String week = "W";	// ~~ 월의 주 차
				String dow = "E";	// 요일
				String hour = "HH";	// 24시간 기준
				String minute = "mm";
				String second = "ss";
				
				// SimpleDateFormat 을 HH 형식으로 받아와서 AM PM을 나눌경우
				// 출력은 그대로 HH 형식으로 나오는 문제발생
				// 비교연산은 HH 형식으로 하되, 출력은 hh 형식으로 출력 하여 문제 해결
				SimpleDateFormat sdfYtoD = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdfHtoS = new SimpleDateFormat("HH:mm:ss");
				if(choice.equals("2")) {	// AM/PM을 선택했을 경우
					// AM : 00 <= num <=11 // PM = 12 <= num <= 23
					DateFormat sdfhtoS = new SimpleDateFormat("hh:mm:ss");
					int num = Integer.parseInt(sdfHtoS.format(today).toString().substring(0,2));
					System.out.printf(sdfYtoD.format(today));
					System.out.println();
					if( num >= 12) {
						System.out.print("PM ");

					} else {
						System.out.print("AM ");
					}
					System.out.printf(sdfhtoS.format(today));
					System.out.println();
				} else {
					System.out.printf(sdfYtoD.format(today));
					System.out.println();
					System.out.printf(sdfHtoS.format(today));
					System.out.println();
				}
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}