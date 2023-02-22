import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JGAlarmSet extends JFrame implements ActionListener {
	
	JLabel yearN, monthN, dayN, hourN, minuteN;
	JButton button;
	JTextField year;
	JTextField month;
	JTextField day;
	JTextField hour;
	JTextField minute;
	
	JGAlarmSet(){
		JFrame frame = new JFrame("알람설정");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400,300));
		frame.setLocation(500,500);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
		
		button = new JButton("추가하기");
		button.addActionListener(this);
		
		// 연도 선택
		year = new JTextField();
		year.setPreferredSize(new Dimension(50	,30));
		year.setFont(new Font("consolas", Font.PLAIN,20));
		
		// 연도 선택
		month = new JTextField();
		month.setPreferredSize(new Dimension(50	,30));
		month.setFont(new Font("consolas", Font.PLAIN,20));
		
		// 연도 선택
		day = new JTextField();
		day.setPreferredSize(new Dimension(50, 30));
		day.setFont(new Font("consolas", Font.PLAIN,20));
		
		// 연도 선택
		hour = new JTextField();
		hour.setPreferredSize(new Dimension(50	,30));
		hour.setFont(new Font("consolas", Font.PLAIN,20));
		
		// 연도 선택
		minute = new JTextField();
		minute.setPreferredSize(new Dimension(50 ,30));
		minute.setFont(new Font("consolas", Font.PLAIN,20));
//		textField.setForeground(new Color(0x00FF00));  //글자색
//		textField.setBackground(Color.black);	//텍스트 배경
//		textField.setCaretColor(Color.white);
		
		JLabel lblYear = new JLabel("년"); 
		JLabel lblMonth = new JLabel("월"); 
		JLabel lblDay = new JLabel("일"); 
		JLabel lblHour = new JLabel("시"); 
		JLabel lblMinute = new JLabel("분"); 

		this.add(year);
		this.add(lblYear);
		this.add(month);
		this.add(lblMonth);
		this.add(day);
		this.add(lblDay);
		this.add(hour);
		this.add(lblHour);
		this.add(minute);
		this.add(lblMinute);
		
		this.add(button);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println(year.getText()+month.getText()+day.getText()+hour.getText()+minute.getText());
		}
	}
	
	public static void main(String[] args) {

		JGAlarmSet alarm = new JGAlarmSet();
		
	}
}