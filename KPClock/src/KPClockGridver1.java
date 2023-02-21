import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class KPClockGridver1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("AM/PM or 24hours?(24hours = 1 , AM/PM = 2)");
		String choice = sc.nextLine();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Date today = new Date();
				
				SimpleDateFormat sdfYtoD = new SimpleDateFormat("yyyy-MM-dd E", Locale.ENGLISH);
				SimpleDateFormat sdfHtoS = new SimpleDateFormat("HH:mm:ss");
				DateFormat sdfhtoS = new SimpleDateFormat("hh:mm:ss");
				int year = Integer.parseInt(sdfYtoD.format(today).toString().substring(0,4));
				int month = Integer.parseInt(sdfYtoD.format(today).toString().substring(5,7));
				int day = Integer.parseInt(sdfYtoD.format(today).toString().substring(8,10));
//				dow = dayoftheWeek : 요일
				String dow = sdfYtoD.format(today).toString().substring(11,14);
				
				int hour = Integer.parseInt(sdfHtoS.format(today).toString().substring(0,2));
				int minute = Integer.parseInt(sdfHtoS.format(today).toString().substring(3,5));
				int second = Integer.parseInt(sdfHtoS.format(today).toString().substring(6,8));

				if(choice.equals("2")) {	// AM/PM을 선택했을 경우
					// AM : 00 <= num <=11 // PM = 12 <= num <= 23
					System.out.println(year + " " + month + " "+ day +" " + dow);
					if( hour >= 12) {
						System.out.print("PM ");
						System.out.println((hour-12) +" "+ minute +" "+ second);

					} else {
						System.out.print("AM ");
						System.out.println(hour +" "+ minute +" "+ second);
					}

				} else {
					System.out.println(hour +" "+ minute +" "+ second);

				}
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}