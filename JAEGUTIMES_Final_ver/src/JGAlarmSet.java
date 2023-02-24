package JAEGUTIMES_Final_ver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JGAlarmSet extends JFrame implements ActionListener {
   
//   메인프레임 필드 frame
  // JAUGUTIMES te;
   String yearN, monthN, dayN, dowN, hourN, minuteN;
   JTextField year, month, day, dow, hour, minute;
   JButton button, delBtn;
   String str;
   JPanel ap, setAlarmPanel;   // 알람패널과 연동, 알람패널생성
   JLabel timeSet;   // 시간출력 레이블
   
   public JPanel getAp() {
      return ap;
   }
   
   public void setAp(JPanel ap) {
      this.ap = ap;
   }
   
   public JPanel setAlarmPanel() {
      if(setAlarmPanel == null) {
         setAlarmPanel = new JPanel();
         setAlarmPanel.setBackground(Color.WHITE);
         
//         setAlarmPanel.add(getDelBtn());
      }
      return setAlarmPanel;
   }
   
   public JGAlarmSet(){ 
      
      JFrame frame = new JFrame("알람설정");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(400,300));
      frame.setLocation(500,500);
//      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
      
      
      button = new JButton("ADD");
      button.addActionListener(this);
      
      delBtn = new JButton("DELETE");
      delBtn.addActionListener(this);
      
      // 연도 선택
      year = new JTextField();
      year.setPreferredSize(new Dimension(50   ,30));
      year.setFont(new Font("consolas", Font.PLAIN,20));
      
      // 월 선택
      month = new JTextField();
      month.setPreferredSize(new Dimension(50   ,30));
      month.setFont(new Font("consolas", Font.PLAIN,20));
      
      // 일 선택
      day = new JTextField();
      day.setPreferredSize(new Dimension(50, 30));
      day.setFont(new Font("consolas", Font.PLAIN,20));
      
      // 요일 선택
      dow = new JTextField();
      dow.setPreferredSize(new Dimension(50, 30));
      dow.setFont(new Font("consolas", Font.PLAIN,20));
      
      // 시간 선택
      hour = new JTextField();
      hour.setPreferredSize(new Dimension(50   ,30));
      hour.setFont(new Font("consolas", Font.PLAIN,20));
      
      // 분 선택
      minute = new JTextField();
      minute.setPreferredSize(new Dimension(50 ,30));
      minute.setFont(new Font("consolas", Font.PLAIN,20));
      
      //타임 출력 레이블
      timeSet = new JLabel(str);
//      textField.setForeground(new Color(0x00FF00));  //글자색
//      textField.setBackground(Color.black);   //텍스트 배경
//      textField.setCaretColor(Color.white);
      
      JLabel lblYear = new JLabel("YEAR"); 
      JLabel lblMonth = new JLabel("MONTH"); 
      JLabel lblDay = new JLabel("DAY"); 
      JLabel lbldoW = new JLabel("DoW(요일)"); 
      JLabel lblHour = new JLabel("HOUR"); 
      JLabel lblMinute = new JLabel("MINUTE"); 

      this.add(year);
      this.add(lblYear);
      this.add(month);
      this.add(lblMonth);
      this.add(day);
      this.add(lblDay);
      this.add(dow);
      this.add(lbldoW);
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
//         yearN, monthN, dayN, hourN, minuteN : DB에 넣기위한 값
         yearN = year.getText();
         monthN = month.getText();
         dayN = day.getText();
         hourN = hour.getText();
         minuteN = minute.getText();
                  
         
         //생성되는 패널
         
         //패널1 생성
         //레이블 생성
         //버튼 생성 -> 액션 리스너도 -> 
         //패널1.add레이블
         //패널1.add버튼
         //ap.add패널1
         //ap.add(new JLabel(str));
         
      }
   }
    
   public static void main(String[] args) {

      JGAlarmSet alarm = new JGAlarmSet();
      
   }
   
//   public String getStr() {
//      return str;
//      
//   }

}