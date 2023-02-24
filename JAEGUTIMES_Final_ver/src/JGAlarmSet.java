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
   
//   ���������� �ʵ� frame
  // JAUGUTIMES te;
   String yearN, monthN, dayN, dowN, hourN, minuteN;
   JTextField year, month, day, dow, hour, minute;
   JButton button, delBtn;
   String str;
   JPanel ap, setAlarmPanel;   // �˶��гΰ� ����, �˶��гλ���
   JLabel timeSet;   // �ð���� ���̺�
   
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
      
      JFrame frame = new JFrame("�˶�����");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(400,300));
      frame.setLocation(500,500);
//      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
      
      
      button = new JButton("ADD");
      button.addActionListener(this);
      
      delBtn = new JButton("DELETE");
      delBtn.addActionListener(this);
      
      // ���� ����
      year = new JTextField();
      year.setPreferredSize(new Dimension(50   ,30));
      year.setFont(new Font("consolas", Font.PLAIN,20));
      
      // �� ����
      month = new JTextField();
      month.setPreferredSize(new Dimension(50   ,30));
      month.setFont(new Font("consolas", Font.PLAIN,20));
      
      // �� ����
      day = new JTextField();
      day.setPreferredSize(new Dimension(50, 30));
      day.setFont(new Font("consolas", Font.PLAIN,20));
      
      // ���� ����
      dow = new JTextField();
      dow.setPreferredSize(new Dimension(50, 30));
      dow.setFont(new Font("consolas", Font.PLAIN,20));
      
      // �ð� ����
      hour = new JTextField();
      hour.setPreferredSize(new Dimension(50   ,30));
      hour.setFont(new Font("consolas", Font.PLAIN,20));
      
      // �� ����
      minute = new JTextField();
      minute.setPreferredSize(new Dimension(50 ,30));
      minute.setFont(new Font("consolas", Font.PLAIN,20));
      
      //Ÿ�� ��� ���̺�
      timeSet = new JLabel(str);
//      textField.setForeground(new Color(0x00FF00));  //���ڻ�
//      textField.setBackground(Color.black);   //�ؽ�Ʈ ���
//      textField.setCaretColor(Color.white);
      
      JLabel lblYear = new JLabel("YEAR"); 
      JLabel lblMonth = new JLabel("MONTH"); 
      JLabel lblDay = new JLabel("DAY"); 
      JLabel lbldoW = new JLabel("DoW(����)"); 
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
//         yearN, monthN, dayN, hourN, minuteN : DB�� �ֱ����� ��
         yearN = year.getText();
         monthN = month.getText();
         dayN = day.getText();
         hourN = hour.getText();
         minuteN = minute.getText();
                  
         
         //�����Ǵ� �г�
         
         //�г�1 ����
         //���̺� ����
         //��ư ���� -> �׼� �����ʵ� -> 
         //�г�1.add���̺�
         //�г�1.add��ư
         //ap.add�г�1
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