import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class ParisTime extends JFrame{
   private JLabel first = new JLabel();
   private JLabel second = new JLabel();

   public ParisTime() {
      // TODO 자동 생성된 생성자 스텁
      set();
      setlabel();
      timeget();
   }
   public void timeget() {//시간관련
      String sday=null;//정수형으로 받은 요일을 문자로 변경
      while(true) {//무조건 실행
          TimeZone time;
          Date date = new Date();
          time = TimeZone.getTimeZone("Europe/Paris");
          DateFormat one = new SimpleDateFormat("yyyy . MM . dd E",  Locale.ENGLISH);
          DateFormat two = new SimpleDateFormat("HH : mm : ss", Locale.ENGLISH);
          one.setTimeZone(time);
          two.setTimeZone(time);
         
         first.setText(one.format(date));//first의 내용을 one(string)으로 설정한다
         second.setText(two.format(date));//second의 내용을 two(string)으로 설정한다.
         add(first);//first를 프레임에 추가한다.
         add(second);//second를 프레임에 추가한다.
         try { //트라이 
            Thread.sleep(1000);//1초
            repaint();
          } catch(Exception e) {} //예외처리
      }//while문 끝
   }//gettime()끝
   public void setlabel() {//시간라벨 설정,알람 설명 라벨
      Font font1 = new Font("DS-Digital", Font.BOLD, 70);//font설정1(적용이 필요함)
      Font font2 = new Font("DS-Digital", Font.BOLD, 80);//font설정1(적용이 필요함)
      first.setFont(font1);//mfont를 적용한다.
      first.setOpaque(true);//라벨을 불투명하게 설정
      first.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
      first.setBounds(380,250,1000,50);//위치와 크기를 설정한다.
      first.setForeground(Color.black);//
      second.setFont(font2);//mfont를 적용한다.
      second.setOpaque(true);//라벨을 불투명하게 설정
      second.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
      second.setBounds(440,320,1000,50);//위치와 크기를 설정한다.
      second.setForeground(Color.black);   
      
   }
   public void set() {
      setTitle("Y_Clock ParisTime"); // 타이틀
      setSize(1280, 720); // 메인에서 가로 세로 크기 가져옴
      setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
      setResizable(false);//정해진사이즈에서 변경불가
      setLayout(null);//레이아웃 설정가능
      setVisible(true); // 보이게
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 jframe이 종료되게 해줌
      
   }
   public static void main(String[] args) { 
      new ParisTime();
   }
}