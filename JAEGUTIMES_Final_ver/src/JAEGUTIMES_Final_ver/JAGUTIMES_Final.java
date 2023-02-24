package JAEGUTIMES_Final_ver;

//import java.awt.event.MouseMotionAdapter;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.*;

public class JAGUTIMES_Final extends JFrame {

   static JGAlarmSet alarmSet;

   private JPanel menuBoxPane, closeBoxPane, userNamePane, passwordPane, darkModePane, darkModeBoxPane, alarmPane, alarmSetPane,themePane, fontSizePane,
         timeDisplayPane, timesPane, timePane, btnBgPane, submitPane, submitConfirmPane;
   
   private JFrame controlPane;

   private JButton btnTZ1, btnTZ2, btnTZ3, btnTZ4, btnTZ5; // �ð� ���� ��ư

   private JButton btnBg1, btnBg2, btnBg3, btnBg4, btnBg5; // ��� ���� ��ư
   private JButton btnFS1, btnFS2, btnFS3; // ��Ʈ ������ ���� ��ư
   private JButton btnTS1, btnTS2, btnTS3; // �׸� ���� ��ư
   private JButton btnAS1, btnAS2; // �˶� ���� ��ư

   private JLabel calendarShowPane, timeShowPane, teamNameShowPane, submitText;

   private String TimeZoneData = "Asia/Seoul";

   private Font Smallfont1 = new Font("DS-Digital", Font.BOLD, 30); // font����1(������ �ʿ���) // small
   private Font Smallfont2 = new Font("DS-Digital", Font.BOLD, 80); // font����2(������ �ʿ���)
   private Font Smallfont3 = new Font("DS-Digital", Font.BOLD, 20); // font����2(������ �ʿ���)

   private Font Mediumfont1 = new Font("DS-Digital", Font.BOLD, 40); // font����1(������ �ʿ���) // medium
   private Font Mediumfont2 = new Font("DS-Digital", Font.BOLD, 120); // font����2(������ �ʿ���)
   private Font Mediumfont3 = new Font("DS-Digital", Font.BOLD, 30); // font����2(������ �ʿ���)

   private Font Largefont1 = new Font("DS-Digital", Font.BOLD, 50); // font����1(������ �ʿ���) // Large
   private Font Largefont2 = new Font("DS-Digital", Font.BOLD, 160); // font����2(������ �ʿ���)
   private Font Largefont3 = new Font("DS-Digital", Font.BOLD, 50); // font����2(������ �ʿ���)

   Color SimpleMode = new Color(255, 255, 255);
   Color BasicMode = new Color(255, 241, 169);
   Color DarkMode = new Color(62, 78, 98);

//   JButton SimpleModecloseBtn = new JButton(new ImageIcon(getClass().getResource("Mode_off_on.png")));
   JButton BasicModecloseBtn = new JButton(new ImageIcon(getClass().getResource("Mode_off_on.png")));
//   JButton DarkModecloseBtn = new JButton(new ImageIcon(getClass().getResource("Dark_Mode_off_on.png")));
//   JButton SimpleModeuserBtn = new JButton(new ImageIcon(getClass().getResource("User.png")));
   JButton BasicModeuserBtn = new JButton(new ImageIcon(getClass().getResource("User.png")));
//   JButton DarkModeuserBtn = new JButton(new ImageIcon(getClass().getResource("Dark_User.png")));
//   JButton SimpleModesettingBtn = new JButton(new ImageIcon(getClass().getResource("Setting.png")));
   JButton BasicModesettingBtn = new JButton(new ImageIcon(getClass().getResource("Setting.png")));
//   JButton DarkModesettingBtn = new JButton(new ImageIcon(getClass().getResource("Dark_Setting.png")));
//   JButton SimpleModealarmBtn = new JButton(new ImageIcon(getClass().getResource("Alarm.png")));
   JButton BasicModealarmBtn = new JButton(new ImageIcon(getClass().getResource("Alarm.png")));
//   JButton DarkModealarmBtn = new JButton(new ImageIcon(getClass().getResource("Dark_Alarm.png")));
//   JButton SimpleModehelpBtn = new JButton(new ImageIcon(getClass().getResource("Info.png")));
   JButton BasicModehelpBtn = new JButton(new ImageIcon(getClass().getResource("Info.png")));
//   JButton DarkModehelpBtn = new JButton(new ImageIcon(getClass().getResource("Dark_Info.png")));   

   TimeDataSetting timeT = new TimeDataSetting();

//   

   
//   static JPanel page1 = new JPanel() {
//      Image background = new ImageIcon(JAGUTIMES_Final_bata.class.getResource("dd1361217.jpg")).getImage();
//      public void paint(Graphics g) {//�׸��� �Լ�
//            g.drawImage(background, 0, 0, null);//background�� �׷���      
//      }
//   };
//   
//   public void homeframe() {
//      setVisible(true);//â�� ���̰�   
//      page1.setLayout(null);
//      page1.setBounds(0, 0, 1280, 720);
//      add(page1);
//   }   
//   
   

   // LoginInterface loginInterface = new LoginInterface();
   
   
   
   // ���� ������ ����
   public JAGUTIMES_Final() {
	   
      this.setTitle("JaeGuTimes.ver 4.0 - �����г�");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���������� jframe�� ����ǰ� ����
      
      ImageIcon img = new ImageIcon(getClass().getResource("jaegutimes_logo_simple.jpg"));
      this.setIconImage(img.getImage());
      

      // �������� Ÿ��Ʋ�� ����
      this.setUndecorated(true); // �������� Ÿ��Ʋ�ٸ� ����
      this.addMouseListener(new moveWindows()); // ������ �̵��ϱ� ���� ����
      this.addMouseMotionListener(new moveWindows()); // ������ �̵��ϱ� ���� ����
      this.getContentPane().add(getClosePane(), BorderLayout.NORTH); // ��� �г�
      
//      this.getContentPane().setLayout(new FlowLayout());
      this.getContentPane().add(getTimeDisplayPane()); // Ÿ���� ���÷��� �г�
      this.getContentPane().add(getDarkModePane(), BorderLayout.SOUTH);
      
      timeT.start();
      

      this.setSize(1280, 720); // ���ο��� ���� ���� ũ�� ������
      this.setResizable(false); // ������������� ����Ұ�
      this.setVisible(true); // ���̰�

   

      // JWindow�� ȭ�� �߾����� ����
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      Point centerPoint = ge.getCenterPoint();

      int leftTopX = centerPoint.x - this.getWidth() / 2;
      int leftTopY = centerPoint.y - this.getHeight() / 2;
      this.setLocation(leftTopX, leftTopY);

   }
   


// /////////////////////////////////////////////////////////////

   private JButton closeBtn, userBtn, settingBtn, alarmBtn, helpBtn;
   private JToggleButton darkModeBtn;

   JToggleButton SimpleModedarkModeBtn = new JToggleButton(new ImageIcon(getClass().getResource("Sun.png")));
   JToggleButton BasicModedarkModeBtn = new JToggleButton(new ImageIcon(getClass().getResource("Sun.png")));
   JToggleButton DarkModedarkModeBtn = new JToggleButton(new ImageIcon(getClass().getResource("Moon.png")));

   // ���� �г�
   private JPanel closePane;

   public JPanel getClosePane() {
      if (closePane == null) {
         closePane = new JPanel();
         closePane.setBackground(BasicMode); // �Ϲ� ���
//         closePane.setBackground(new Color(62, 78, 98)); // ��ũ ���
         closePane.setOpaque(true);// ���� �������ϰ� ����
         closePane.setLayout(new BorderLayout());
//         closePane.setBorder(new TitledBorder("��� �г�"));   
         closePane.add(getMenuBoxPane(), BorderLayout.WEST);
         closePane.add(getCloseBoxPane(), BorderLayout.EAST);

//         closePane.setPreferredSize(new java.awt.Dimension(1280, 50));
      }
      return closePane;
   }

   // �޴� �����ܵ�
   public JPanel getCloseBoxPane() {
      if (closeBoxPane == null) {
         closeBoxPane = new JPanel();
         closeBoxPane.setBackground(BasicMode);
//         closeBoxPane.setBackground(new Color(62, 78, 98));
         closeBoxPane.setOpaque(true);// ���� �������ϰ� ����
//            closePane.setLayout(new BorderLayout());
//            closePane.setBorder(new TitledBorder("��� �г�"));

         closeBoxPane.add(getCloseBtn(), BorderLayout.EAST);
//            closePane.setPreferredSize(new java.awt.Dimension(1280, 50));
      }
      return closeBoxPane;
   }

   // ���� ��ư�� ������ �� �ý��� ����
   public JButton getCloseBtn() {
      if (closeBtn == null) {
//         closeBtn = new JButton(new ImageIcon(getClass().getResource("Mode_off_on.png")));
         closeBtn = BasicModecloseBtn;
//         closeBtn.setBackground(new Color(255, 241, 169));
         closeBtn.setBackground(BasicMode);
         closeBtn.setBorderPainted(false);

         closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
         });
         closeBtn.setPreferredSize(new java.awt.Dimension(50, 50));
      }
      return closeBtn;
   }

// /////////////////////////////////////////////////////////////   

   // �޴� �����ܵ�
   public JPanel getMenuBoxPane() {
      if (menuBoxPane == null) {
         menuBoxPane = new JPanel();
//         menuBoxPane.setBackground(new Color(255, 241, 169));
         menuBoxPane.setBackground(BasicMode);
         menuBoxPane.setOpaque(true);// ���� �������ϰ� ����
//            closePane.setLayout(new BorderLayout());
//            closePane.setBorder(new TitledBorder("��� �г�"));

         menuBoxPane.add(getUserBtn());
         menuBoxPane.add(getSettingBtn());
         menuBoxPane.add(getAlarmBtn());
         menuBoxPane.add(getHelpBtn());
//            closePane.setPreferredSize(new java.awt.Dimension(1280, 50));
      }
      return menuBoxPane;
   }

   public JButton getUserBtn() {
      if (userBtn == null) {
         userBtn = BasicModeuserBtn;
//        userBtn.setBackground(new Color(255, 241, 169));
         userBtn.setBackground(BasicMode);
         userBtn.setBorderPainted(false);
         userBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               getControlPane();
               controlPane.setVisible(true);
            }
         });
         userBtn.setPreferredSize(new java.awt.Dimension(50, 50));
      }
      return userBtn;
   }

   public JButton getSettingBtn() {
      if (settingBtn == null) {
         settingBtn = BasicModesettingBtn;
//        settingBtn.setBackground(new Color(255, 241, 169));
         settingBtn.setBackground(BasicMode);
         settingBtn.setBorderPainted(false);
         settingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               getControlPane();
               controlPane.setVisible(true);
            }
         });
         settingBtn.setPreferredSize(new java.awt.Dimension(50, 50));
      }
      return settingBtn;
   }

   public JButton getAlarmBtn() {
      if (alarmBtn == null) {
         alarmBtn = BasicModealarmBtn;
//        alarmBtn.setBackground(new Color(255, 241, 169));
         alarmBtn.setBackground(BasicMode);
         alarmBtn.setBorderPainted(false);
         alarmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               getControlPane();
               controlPane.setVisible(true);
            }
         });
         alarmBtn.setPreferredSize(new java.awt.Dimension(50, 50));
      }
      return alarmBtn;
   }

   public JButton getHelpBtn() {
      if (helpBtn == null) {
         helpBtn = BasicModehelpBtn;
//        helpBtn.setBackground(new Color(255, 241, 169));
         helpBtn.setBackground(BasicMode);
         helpBtn.setBorderPainted(false);
         helpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               getControlPane();
               controlPane.setVisible(true);
            }
         });
         helpBtn.setPreferredSize(new java.awt.Dimension(50, 50));
      }
      return helpBtn;
   }

// /////////////////////////////////////////////////////////////
   // ���콺�� ȭ�� �̵� ����
   private Point initialClick;

   class moveWindows extends MouseAdapter {
      public void mousePressed(MouseEvent e) {
         initialClick = e.getPoint();
         getComponentAt(initialClick);
      }

      public void mouseDragged(MouseEvent e) {
         JFrame jf = (JFrame) e.getSource();

         int thisX = jf.getLocation().x;
         int thisY = jf.getLocation().y;

         int xMoved = e.getX() - initialClick.x;
         int yMoved = e.getY() - initialClick.y;

         int X = thisX + xMoved;
         int Y = thisY + yMoved;

         /* 10�� */
         jf.setLocation(X, Y); // jf�� ��ġ ����
      }
   }

   //////////////////////////////////////////////////////////////
   // �ð� ���÷��� �г�
   public JPanel getTimeDisplayPane() {
      if (timeDisplayPane == null) {
         timeDisplayPane = new JPanel();
//         timeDisplayPane.setBackground(new Color(255, 241, 169));
         timeDisplayPane.setBackground(BasicMode);
         timeDisplayPane.setOpaque(true);// ���� �������ϰ� ����
         timeDisplayPane.setLayout(new GridBagLayout());
//         timeDisplayPane.setBorder(new TitledBorder("�ð� ���÷��� �г�"));
         timeDisplayPane.add(getTimesPane());
         
         timeDisplayPane.setPreferredSize(new java.awt.Dimension(1280, 720));
      }
      return timeDisplayPane;
   }

   // �ð� ���� �г�
   public JPanel getTimesPane() {
      if (timesPane == null) {
         timesPane = new JPanel();
         timesPane.setBackground(Color.WHITE);
//         timesPane.setLayout(new GridLayout(2, 1));
         timesPane.setLayout(new BorderLayout());
//       timesPane.setBorder(new TitledBorder("�ð� ��¥ �ð�"));
//         timesPane.setBackground(new Color(255, 241, 169));
         timesPane.setBackground(BasicMode);
         timesPane.add(getCalendarShowPane(), BorderLayout.NORTH);
         timesPane.add(getTimeShowPane(), BorderLayout.CENTER);
         timesPane.add(getTeamNameShowPane(), BorderLayout.SOUTH);
         timesPane.setPreferredSize(new java.awt.Dimension(380, 130)); // small
//         timesPane.setPreferredSize(new java.awt.Dimension(520, 180));      // medium
//         timesPane.setPreferredSize(new java.awt.Dimension(700, 250));      // large
         
         // homeframe();

      }
      return timesPane;
   }

   // �޷� �г�
   public JLabel getCalendarShowPane() {
      if (calendarShowPane == null) {
         calendarShowPane = new JLabel("");
//         calendarShowPane.setBackground(Color.WHITE);
//         calendarShowPane.setBorder(new TitledBorder("�޷�"));
//         calendarShowPane.setBackground(new Color(255, 241, 169));
         calendarShowPane.setBackground(BasicMode);
         calendarShowPane.setFont(Smallfont1);
         calendarShowPane.setHorizontalAlignment(JLabel.CENTER);
         calendarShowPane.setForeground(Color.BLACK);

         timeT.setFirstMain(calendarShowPane);

      }
      return calendarShowPane;
   }

   // �ð� �г�
   public JLabel getTimeShowPane() {
      if (timeShowPane == null) {
         timeShowPane = new JLabel("");
//         timeShowPane.setBackground(Color.WHITE);
//         timeShowPane.setBackground(new Color(255, 241, 169));
         timeShowPane.setBackground(BasicMode);
//            timeShowPane.setBorder(new TitledBorder("�ð�"));
         timeShowPane.setFont(Smallfont2);
         timeShowPane.setHorizontalAlignment(JLabel.CENTER);
         timeShowPane.setForeground(Color.BLACK);

         timeT.setSecondMain(timeShowPane);

      }
      return timeShowPane;
   }

   // ���� �г�
   public JLabel getTeamNameShowPane() {
      if (teamNameShowPane == null) {
         teamNameShowPane = new JLabel("");
//         teamNameShowPane.setBackground(Color.WHITE);
//         teamNameShowPane.setBackground(new Color(255, 241, 169));
         teamNameShowPane.setBackground(BasicMode);
//         timeShowPane.setBorder(new TitledBorder("�ð�"));
         teamNameShowPane.setFont(Smallfont3);
         teamNameShowPane.setHorizontalAlignment(JLabel.CENTER);
         teamNameShowPane.setForeground(Color.BLACK);

         timeT.setThirdMain(teamNameShowPane);
         
         // homeframe();

      }
      return teamNameShowPane;
   }

   //////////////////////////////////////////////////////////////

//   this.getContentPane().add(getControlPane(), BorderLayout.SOUTH); // ��Ʈ�� �г�
//   
//   JFrame

   // ��Ʈ�� �г�
   public JFrame getControlPane() {
      if (controlPane == null) {
         controlPane = new JFrame();
         controlPane.setTitle("JaeGuTimes.ver 4.0 - ȯ�漳���г�");

         ImageIcon img = new ImageIcon(getClass().getResource("jaegutimes_logo_dark.jpg"));
         controlPane.setIconImage(img.getImage());
         
       
         
         
         controlPane.setLayout(new GridLayout(9, 1));
//         controlPane.setBorder(new TitledBorder("��Ʈ�� �г�"));
         controlPane.add(getUserNamePane());
         controlPane.add(getPasswordPane());
         controlPane.add(getAlarmPane());
         controlPane.add(getThemePane());
         controlPane.add(getFontSizePane());
         controlPane.add(getTimeZonePane());
         controlPane.add(getBtnBgPane());
         controlPane.add(getSubmitPane());  
         controlPane.add(getSubmitConfirmPane());  
         
                  
         
         controlPane.setSize(950, 600); // ���ο��� ���� ���� ũ�� ������
         controlPane.setResizable(false); // ������������� ����Ұ�
         controlPane.setVisible(false); // ���̰�

         // JWindow�� ȭ�� �߾����� ����
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         Point centerPoint = ge.getCenterPoint();

         int leftTopX = centerPoint.x - controlPane.getWidth() / 2;
         int leftTopY = centerPoint.y - controlPane.getHeight() / 2;
         controlPane.setLocation(leftTopX, leftTopY);  
         

      }
      return controlPane;
   }

   //////////////////////////////////////////////////////////////
   // ����� �̸�
   public JPanel getUserNamePane() {
	      if (userNamePane == null) {
	    	  userNamePane = new JPanel();
	    	  userNamePane.setBorder(new TitledBorder("����� �̸� �г�"));
	    	  userNamePane.setBackground(Color.WHITE);
	    	  userNamePane.add(getAlarmSetPane());
//	         alarmPane.add(getBtnAS1());
//	         alarmPane.add(getBtnAS2());
	    	  
	    	  JLabel userName = new JLabel("����� �̸� : "); 
	    	  
	    	  JTextField  userNameText = new JTextField();
	    	  userNameText.setPreferredSize(new Dimension(300 ,30));
	    	  userNameText.setFont(new Font("����", Font.PLAIN,20));
	    	  
	    	  JButton userNameBtn = new JButton("�Է�");   	      
	    	  
	    	  
	    	  
    	      userNamePane.add(userName);
    	      userNamePane.add(userNameText);
    	      userNamePane.add(userNameBtn);
    	      
    	      
    	      
    	      userNameBtn.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
    	            @Override
    	            public void mousePressed(MouseEvent e) { // ���콺 ��������
    	            	JGDBUser.UserName = userNameText.getText();
    	            	
    	            	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

    	            	System.out.println(JGDBUser.UserName);
    	            }
    	         });	    	  
    	      
    	      
	      }
	      return userNamePane;
	   }
	   

   
   
   // ��й�ȣ
   public JPanel getPasswordPane() {
	      if (passwordPane == null) {
	    	  passwordPane = new JPanel();
	    	  passwordPane.setBorder(new TitledBorder("��й�ȣ �г�"));
	    	  passwordPane.setBackground(Color.WHITE);
	    	  
	    	  JLabel password = new JLabel("��й�ȣ : "); 
	    	  
	    	  JTextField  passwordText = new JTextField();
	    	  passwordText.setPreferredSize(new Dimension(300 ,30));
	    	  passwordText.setFont(new Font("����", Font.PLAIN,20));
	    	  
	    	  JButton passwordBtn = new JButton("�Է�");
    	      
	    	  
	    	  
	    	  passwordPane.add(password);
	    	  passwordPane.add(passwordText);
	    	  passwordPane.add(passwordBtn);
    	      
	    	  
	    	  
	    	  passwordBtn.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
  	            @Override
  	            public void mousePressed(MouseEvent e) { // ���콺 ��������
  	            	JGDBUser.Password = passwordText.getText();
  	          	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

  	            }
  	         });	    	  
  	      
	    	  
	      }
	      return passwordPane;
	   }
	   
   
   
   
   
   //////////////////////////////////////////////////////////////
   
   
   
   
   
   
   
   
   // ��ũ��� �г�
   public JPanel getDarkModePane() {
      if (darkModePane == null) {
         darkModePane = new JPanel();
         darkModePane.setBackground(BasicMode);
         darkModePane.setOpaque(true);// ���� �������ϰ� ����
         darkModePane.setLayout(new BorderLayout());
//         closePane.setBorder(new TitledBorder("��� �г�"));   
         darkModePane.add(getDarkModeBoxPane(), BorderLayout.EAST);

//         darkModePane.setPreferredSize(new java.awt.Dimension(1280, 100));

      }
      return darkModePane;
   }

   public JPanel getDarkModeBoxPane() {
      if (darkModeBoxPane == null) {
         darkModeBoxPane = new JPanel();
         darkModeBoxPane.setBackground(BasicMode);
         darkModeBoxPane.setOpaque(true);// ���� �������ϰ� ����
//         darkModeBoxPane.setLayout(new BorderLayout());
//         closePane.setBorder(new TitledBorder("��� �г�"));   
         darkModeBoxPane.add(getDarkModeBtn());

//         darkModePane.setPreferredSize(new java.awt.Dimension(1280, 100));

      }
      return darkModeBoxPane;
   }

   // ��ũ��� ��ư
   public JToggleButton getDarkModeBtn() {
      if (darkModeBtn == null) {
         darkModeBtn = BasicModedarkModeBtn;
         darkModeBtn.setBackground(BasicMode);
         darkModeBtn.setOpaque(true);
         darkModeBtn.setBorderPainted(false);

         darkModeBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               if (e.getStateChange() == ItemEvent.SELECTED) {
                  closePane.setBackground(DarkMode); // ��ũ ���
                  closeBoxPane.setBackground(DarkMode);
                  closeBtn.setBackground(DarkMode);
                  menuBoxPane.setBackground(DarkMode);
                  userBtn.setBackground(DarkMode);
                  settingBtn.setBackground(DarkMode);
                  alarmBtn.setBackground(DarkMode);
                  helpBtn.setBackground(DarkMode);
                  timeDisplayPane.setBackground(DarkMode);
                  timesPane.setBackground(DarkMode);
                  calendarShowPane.setBackground(DarkMode);
                  timeShowPane.setBackground(DarkMode);
                  teamNameShowPane.setBackground(DarkMode);
                  darkModePane.setBackground(DarkMode);
                  darkModeBoxPane.setBackground(DarkMode);         
                  darkModeBtn.setBackground(DarkMode);

                  BasicModecloseBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Mode_off_on.png")));
                  BasicModeuserBtn.setIcon(new ImageIcon(getClass().getResource("Dark_User.png")));
                  BasicModesettingBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Setting.png")));
                  BasicModealarmBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Alarm.png")));
                  BasicModehelpBtn.setIcon(new ImageIcon(getClass().getResource("Dark_info.png")));
                  BasicModedarkModeBtn.setIcon(new ImageIcon(getClass().getResource("Moon.png")));

                  calendarShowPane.setForeground(Color.WHITE);
                  timeShowPane.setForeground(Color.WHITE);
                  teamNameShowPane.setForeground(Color.WHITE);

               } else {
                  closePane.setBackground(BasicMode); // �Ϲ� ���
                  closeBoxPane.setBackground(BasicMode);
                  closeBtn.setBackground(BasicMode);
                  menuBoxPane.setBackground(BasicMode);
                  userBtn.setBackground(BasicMode);
                  settingBtn.setBackground(BasicMode);
                  alarmBtn.setBackground(BasicMode);
                  helpBtn.setBackground(BasicMode);
                  timeDisplayPane.setBackground(BasicMode);
                  timesPane.setBackground(BasicMode);
                  calendarShowPane.setBackground(BasicMode);
                  timeShowPane.setBackground(BasicMode);
                  teamNameShowPane.setBackground(BasicMode);
                  darkModePane.setBackground(BasicMode);
                  darkModeBoxPane.setBackground(BasicMode);
                  darkModeBtn.setBackground(BasicMode);

                  BasicModecloseBtn.setIcon(new ImageIcon(getClass().getResource("Mode_off_on.png")));
                  BasicModeuserBtn.setIcon(new ImageIcon(getClass().getResource("User.png")));
                  BasicModesettingBtn.setIcon(new ImageIcon(getClass().getResource("Setting.png")));
                  BasicModealarmBtn.setIcon(new ImageIcon(getClass().getResource("Alarm.png")));
                  BasicModehelpBtn.setIcon(new ImageIcon(getClass().getResource("info.png")));
                  BasicModedarkModeBtn.setIcon(new ImageIcon(getClass().getResource("Sun.png")));

                  calendarShowPane.setForeground(Color.BLACK);
                  timeShowPane.setForeground(Color.BLACK);
                  teamNameShowPane.setForeground(Color.BLACK);

               }
            }
         });      

         darkModeBtn.setPreferredSize(new java.awt.Dimension(50, 50));
      }
      return darkModeBtn;
   }

   //////////////////////////////////////////////////////////////

   public JPanel getAlarmPane() {
      if (alarmPane == null) {
         alarmPane = new JPanel();
         alarmPane.setBorder(new TitledBorder("�˶� �г�"));
         alarmPane.setBackground(Color.WHITE);
         alarmPane.add(getAlarmSetPane());
//         alarmPane.add(getBtnAS1());
//         alarmPane.add(getBtnAS2());
      }
      return alarmPane;
   }
   
   public JPanel getAlarmSetPane() {
	      if (alarmSetPane == null) {
	    	  alarmSetPane = new JPanel();
//	    	  alarmSetPane.setBorder(new TitledBorder("�˶� �г�"));
	    	  alarmSetPane.setBackground(Color.WHITE);
	    	  alarmSetPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    	  
	    	  alarmSetPane.setPreferredSize(new java.awt.Dimension(900, 60)); // small
	    	 
	    	  
	    	   String yearN, monthN, dayN, dowN, hourN, minuteN;
	    	   JTextField year, month, day, dow, hour, minute;
	    	   JButton button, delBtn;
	    	   String str;
	    	   JPanel ap, setAlarmPanel;   // �˶��гΰ� ����, �˶��гλ���
	    	   JLabel timeSet;   // �ð���� ���̺�
	    	  
	    	   button = new JButton("�߰�");
	    	     // button.addActionListener(this);
	    	      
	    	      delBtn = new JButton("DELETE");
	    	      //delBtn.addActionListener(this);	    	    
	    	      
	    	      // ���� ����
	    	      year = new JTextField();
	    	      year.setPreferredSize(new Dimension(100 ,30));
	    	      year.setFont(new Font("����", Font.PLAIN,20));
	    	      
	    	      // �� ����
	    	      month = new JTextField();
	    	      month.setPreferredSize(new Dimension(40 ,30));
	    	      month.setFont(new Font("����", Font.PLAIN,20)); 
	    	      
	    	      // �� ����
	    	      day = new JTextField();
	    	      day.setPreferredSize(new Dimension(40, 30));
	    	      day.setFont(new Font("����", Font.PLAIN,20));
	    	      
	    	      // ���� ����
	    	      dow = new JTextField();
	    	      dow.setPreferredSize(new Dimension(40, 30));
	    	      dow.setFont(new Font("����", Font.PLAIN,20));
	    	      
	    	      // �ð� ����
	    	      hour = new JTextField();
	    	      hour.setPreferredSize(new Dimension(40   ,30));
	    	      hour.setFont(new Font("����", Font.PLAIN,20));
	    	      
	    	      // �� ����
	    	      minute = new JTextField();
	    	      minute.setPreferredSize(new Dimension(40 ,30));
	    	      minute.setFont(new Font("����", Font.PLAIN,20));
	    	      
	    	      
	    	      
	    	      JLabel lblYear = new JLabel("��"); 
	    	      JLabel lblMonth = new JLabel("��"); 
	    	      JLabel lblDay = new JLabel("��      "); 
	    	      JLabel lbldoW = new JLabel("����      "); 
	    	      JLabel lblHour = new JLabel("��"); 
	    	      JLabel lblMinute = new JLabel("��      "); 

	    	      alarmSetPane.add(year);
	    	      alarmSetPane.add(lblYear);
	    	      alarmSetPane.add(month);
	    	      alarmSetPane.add(lblMonth);
	    	      alarmSetPane.add(day);
	    	      alarmSetPane.add(lblDay);
	    	      alarmSetPane.add(dow);
	    	      alarmSetPane.add(lbldoW);
	    	      alarmSetPane.add(hour);
	    	      alarmSetPane.add(lblHour);
	    	      alarmSetPane.add(minute);
	    	      alarmSetPane.add(lblMinute);	    	      
	    	      alarmSetPane.add(button);  	
	    	      
	    	      alarmSetPane.add(getBtnAS2());
	    	  
	    	  
	      }
	      return alarmSetPane;
	   }
   
   
  
   
   

   private JButton getBtnAS1() {
      if (btnAS1 == null) {
         btnAS1 = new JButton();
         btnAS1.setText("�˶�����");
         btnAS1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new JGAlarmSet();
            }
         });
      }
      return btnAS1;
   }

   private JButton getBtnAS2() {
      if (btnAS2 == null) {
         btnAS2 = new JButton();
         btnAS2.setText("�˶�����");
//         btnAS1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               JFileChooser jFileChooser = new JFileChooser();
//               jFileChooser.showOpenDialog(JButtonExample.this);
//            }
//         });
      }
      return btnAS2;
   }

   // �׸� �г�
   public JPanel getThemePane() {
      if (themePane == null) {
         themePane = new JPanel();
         themePane.setBorder(new TitledBorder("�׸� �г�"));
         themePane.setBackground(Color.WHITE);
         themePane.add(getBtnTS1());
         themePane.add(getBtnTS2());
         themePane.add(getBtnTS3());
      }
      return themePane;
   }

   // ���ø�� ��ư
   private JButton getBtnTS1() {
      if (btnTS1 == null) {
         btnTS1 = new JButton();
         btnTS1.setText("���ø��");

         btnTS1.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               closePane.setBackground(SimpleMode); // �Ϲ� ���
               closeBoxPane.setBackground(SimpleMode);
               closeBtn.setBackground(SimpleMode);
               menuBoxPane.setBackground(SimpleMode);
               userBtn.setBackground(SimpleMode);
               settingBtn.setBackground(SimpleMode);
               alarmBtn.setBackground(SimpleMode);
               helpBtn.setBackground(SimpleMode);
               timeDisplayPane.setBackground(SimpleMode);
               timesPane.setBackground(SimpleMode);
               calendarShowPane.setBackground(SimpleMode);
               timeShowPane.setBackground(SimpleMode);
               teamNameShowPane.setBackground(SimpleMode);
               darkModePane.setBackground(SimpleMode);
               darkModeBoxPane.setBackground(SimpleMode);
               darkModeBtn.setBackground(SimpleMode);

               BasicModecloseBtn.setIcon(new ImageIcon(getClass().getResource("Mode_off_on.png")));
               BasicModeuserBtn.setIcon(new ImageIcon(getClass().getResource("User.png")));
               BasicModesettingBtn.setIcon(new ImageIcon(getClass().getResource("Setting.png")));
               BasicModealarmBtn.setIcon(new ImageIcon(getClass().getResource("Alarm.png")));
               BasicModehelpBtn.setIcon(new ImageIcon(getClass().getResource("info.png")));
               BasicModedarkModeBtn.setIcon(new ImageIcon(getClass().getResource("Sun.png")));

               calendarShowPane.setForeground(Color.BLACK);
               timeShowPane.setForeground(Color.BLACK);
               teamNameShowPane.setForeground(Color.BLACK);
               
               
               JGDBUser.DarkMode = "���ø��";
               
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });
      }
      return btnTS1;
   }

   // ������ ��� ��ư
   private JButton getBtnTS2() {
      if (btnTS2 == null) {
         btnTS2 = new JButton();
         btnTS2.setText("���������");

         btnTS2.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               closePane.setBackground(BasicMode); // �Ϲ� ���
               closeBoxPane.setBackground(BasicMode);
               closeBtn.setBackground(BasicMode);
               menuBoxPane.setBackground(BasicMode);
               userBtn.setBackground(BasicMode);
               settingBtn.setBackground(BasicMode);
               alarmBtn.setBackground(BasicMode);
               helpBtn.setBackground(BasicMode);
               timeDisplayPane.setBackground(BasicMode);
               timesPane.setBackground(BasicMode);
               calendarShowPane.setBackground(BasicMode);
               timeShowPane.setBackground(BasicMode);
               teamNameShowPane.setBackground(BasicMode);
               darkModePane.setBackground(BasicMode);   
               darkModeBoxPane.setBackground(BasicMode);
               darkModeBtn.setBackground(BasicMode);

               BasicModecloseBtn.setIcon(new ImageIcon(getClass().getResource("Mode_off_on.png")));
               BasicModeuserBtn.setIcon(new ImageIcon(getClass().getResource("User.png")));
               BasicModesettingBtn.setIcon(new ImageIcon(getClass().getResource("Setting.png")));
               BasicModealarmBtn.setIcon(new ImageIcon(getClass().getResource("Alarm.png")));
               BasicModehelpBtn.setIcon(new ImageIcon(getClass().getResource("info.png")));
               BasicModedarkModeBtn.setIcon(new ImageIcon(getClass().getResource("Sun.png")));

               calendarShowPane.setForeground(Color.BLACK);
               timeShowPane.setForeground(Color.BLACK);
               teamNameShowPane.setForeground(Color.BLACK);
               
               JGDBUser.DarkMode = "���������";
               
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");


            }
         });

      }
      return btnTS2;
   }

   // ��ũ��� ��ư
   private JButton getBtnTS3() {
      if (btnTS3 == null) {
         btnTS3 = new JButton();
         btnTS3.setText("��ũ���");

         btnTS3.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               closePane.setBackground(DarkMode); // ��ũ ���
               closeBoxPane.setBackground(DarkMode);
               closeBtn.setBackground(DarkMode);
               menuBoxPane.setBackground(DarkMode);
               userBtn.setBackground(DarkMode);
               settingBtn.setBackground(DarkMode);
               alarmBtn.setBackground(DarkMode);
               helpBtn.setBackground(DarkMode);
               timeDisplayPane.setBackground(DarkMode);
               timesPane.setBackground(DarkMode);
               calendarShowPane.setBackground(DarkMode);
               timeShowPane.setBackground(DarkMode);
               teamNameShowPane.setBackground(DarkMode);
               darkModePane.setBackground(DarkMode);
               darkModeBoxPane.setBackground(DarkMode);
               darkModeBtn.setBackground(DarkMode);

               BasicModecloseBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Mode_off_on.png")));
               BasicModeuserBtn.setIcon(new ImageIcon(getClass().getResource("Dark_User.png")));
               BasicModesettingBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Setting.png")));
               BasicModealarmBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Alarm.png")));
               BasicModehelpBtn.setIcon(new ImageIcon(getClass().getResource("Dark_info.png")));
               BasicModedarkModeBtn.setIcon(new ImageIcon(getClass().getResource("Moon.png")));

               calendarShowPane.setForeground(Color.WHITE);
               timeShowPane.setForeground(Color.WHITE);
               teamNameShowPane.setForeground(Color.WHITE);
               
               JGDBUser.DarkMode = "��ũ���";
               
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });

      }
      return btnTS3;
   }

   // ��Ʈ ������ �г�
   public JPanel getFontSizePane() {
      if (fontSizePane == null) {
         fontSizePane = new JPanel();
         fontSizePane.setBorder(new TitledBorder("��Ʈ ������ �г�"));
         fontSizePane.setBackground(Color.WHITE);
         fontSizePane.add(getBtnFS1());
         fontSizePane.add(getBtnFS2());
         fontSizePane.add(getBtnFS3());
      }
      return fontSizePane;
   }

   // ��Ʈ �г� ��ư
   private JButton getBtnFS1() {
      if (btnFS1 == null) {
         btnFS1 = new JButton();
         btnFS1.setText("��");

         btnFS1.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               calendarShowPane.setFont(Smallfont1);
               timeShowPane.setFont(Smallfont2);
               teamNameShowPane.setFont(Smallfont3);

               timesPane.setPreferredSize(new java.awt.Dimension(360, 140)); // small
               
	            	JGDBUser.FontSize = "��";
	            	
	            	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");


            }
         });

      }
      return btnFS1;
   }

   private JButton getBtnFS2() {
      if (btnFS2 == null) {
         btnFS2 = new JButton();
         btnFS2.setText("��");

         btnFS2.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               calendarShowPane.setFont(Mediumfont1);
               timeShowPane.setFont(Mediumfont2);
               teamNameShowPane.setFont(Mediumfont3);

               timesPane.setPreferredSize(new java.awt.Dimension(535, 170)); // medium
               
            	JGDBUser.FontSize = "��";
            	
            	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });
      }
      return btnFS2;
   }

   private JButton getBtnFS3() {
      if (btnFS3 == null) {
         btnFS3 = new JButton();
         btnFS3.setText("��");

         btnFS3.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               calendarShowPane.setFont(Largefont1);
               timeShowPane.setFont(Largefont2);
               teamNameShowPane.setFont(Largefont3);

               timesPane.setPreferredSize(new java.awt.Dimension(715, 260)); // large
               
            	JGDBUser.FontSize = "��";
            	
            	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });
      }
      return btnFS3;
   }

   // �ð� �г�
   public JPanel getTimeZonePane() {
      if (timePane == null) {
         timePane = new JPanel();
         timePane.setBorder(new TitledBorder("�ð� �г�"));
         timePane.setBackground(Color.WHITE);
         timePane.add(getBtnTZ1());
         timePane.add(getBtnTZ2());
         timePane.add(getBtnTZ3());
         timePane.add(getBtnTZ4());
         timePane.add(getBtnTZ5());
      }
      return timePane;
   }

   // �ð� �г� ��ư
   private JButton getBtnTZ1() {
      if (btnTZ1 == null) {
         btnTZ1 = new JButton();
         btnTZ1.setText("�ѱ�");

         btnTZ1.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               TimeZoneData = "Asia/Seoul";
               System.out.println(TimeZoneData);
               timeT.setTime(TimeZone.getTimeZone(TimeZoneData));
               
               JGDBUser.Country = "�ѱ�/����";
               
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });

      }
      return btnTZ1;
   }

   private JButton getBtnTZ2() {
      if (btnTZ2 == null) {
         btnTZ2 = new JButton();
         btnTZ2.setText("����");

         btnTZ2.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               TimeZoneData = "America/New_York";
               System.out.println(TimeZoneData);
               timeT.setTime(TimeZone.getTimeZone(TimeZoneData));
               
               JGDBUser.Country = "����/�̱�";
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });
      }
      return btnTZ2;
   }

   private JButton getBtnTZ3() {
      if (btnTZ3 == null) {
         btnTZ3 = new JButton();
         btnTZ3.setText("�ĸ�");

         btnTZ3.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               TimeZoneData = "Europe/Paris";
               System.out.println(TimeZoneData);
               timeT.setTime(TimeZone.getTimeZone(TimeZoneData));
               
               JGDBUser.Country = "�ĸ�/������";
               
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });

      }
      return btnTZ3;
   }

   private JButton getBtnTZ4() {
      if (btnTZ4 == null) {
         btnTZ4 = new JButton();
         btnTZ4.setText("����");

         btnTZ4.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               TimeZoneData = "Europe/London";
               System.out.println(TimeZoneData);
               timeT.setTime(TimeZone.getTimeZone(TimeZoneData));
               
               JGDBUser.Country = "����/����";
               
           	submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");

            }
         });
      }
      return btnTZ4;
   }

   private JButton getBtnTZ5() {
      if (btnTZ5 == null) {
         btnTZ5 = new JButton();
         btnTZ5.setText("ĵ����");

         btnTZ5.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               TimeZoneData = "Australia/Canberra";
               System.out.println(TimeZoneData);
               timeT.setTime(TimeZone.getTimeZone(TimeZoneData));
               
               JGDBUser.Country = "ĵ����/ȣ��";
               
               submitText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");
            }
         });
      }
      return btnTZ5;
   }

   // ��� �г�
   private JPanel getBtnBgPane() {
      if (btnBgPane == null) {
         btnBgPane = new JPanel();
         btnBgPane.setBorder(new TitledBorder("��� �г�"));
         btnBgPane.setBackground(Color.WHITE);
         btnBgPane.add(getBtnBg1());
         btnBgPane.add(getBtnBg2());
         btnBgPane.add(getBtnBg3());
         btnBgPane.add(getBtnBg4());
         btnBgPane.add(getBtnBg5());
      }
      return btnBgPane;
   }

   // ��� �г� ��ư
   private JButton getBtnBg1() {
      if (btnBg1 == null) {
         btnBg1 = new JButton();
         btnBg1.setText("���1");

         btnBg1.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
            @Override
            public void mousePressed(MouseEvent e) { // ���콺 ��������
               

//            //closePane.setBackground(null); // ��ũ ���
//            //closeBoxPane.setBackground(null);
//            //closeBtn.setBackground(null);
//            //menuBoxPane.setBackground(null);
//            //userBtn.setBackground(null);
//            //settingBtn.setBackground(null);
//            //alarmBtn.setBackground(null);
//            //helpBtn.setBackground(null);
//            timeDisplayPane.setBackground(null);
//            timesPane.setBackground(null);
//            calendarShowPane.setBackground(null);
//            timeShowPane.setBackground(null);
//            teamNameShowPane.setBackground(null);
//            //darkModePane.setBackground(null);
//            //darkModeBtn.setBackground(null);
//
//            BasicModecloseBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Mode_off_on.png")));
//            BasicModeuserBtn.setIcon(new ImageIcon(getClass().getResource("Dark_User.png")));
//            BasicModesettingBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Setting.png")));
//            BasicModealarmBtn.setIcon(new ImageIcon(getClass().getResource("Dark_Alarm.png")));
//            BasicModehelpBtn.setIcon(new ImageIcon(getClass().getResource("Dark_info.png")));
//            BasicModedarkModeBtn.setIcon(new ImageIcon(getClass().getResource("Moon.png")));
//
//            calendarShowPane.setForeground(Color.WHITE);
//            timeShowPane.setForeground(Color.WHITE);
//            teamNameShowPane.setForeground(Color.WHITE);

            }
         });

      }
      return btnBg1;
   }

   private JButton getBtnBg2() {
      if (btnBg2 == null) {
         btnBg2 = new JButton();
         btnBg2.setText("���2");
      }
      return btnBg2;
   }

   private JButton getBtnBg3() {
      if (btnBg3 == null) {
         btnBg3 = new JButton();
         btnBg3.setText("���3");
      }
      return btnBg3;
   }

   private JButton getBtnBg4() {
      if (btnBg4 == null) {
         btnBg4 = new JButton();
         btnBg4.setText("���4");
      }
      return btnBg4;
   }

   private JButton getBtnBg5() {
      if (btnBg5 == null) {
         btnBg5 = new JButton();
         btnBg5.setText("���5");
      }
      return btnBg5;
   }
   // /////////////////////////////////////////////////////////////
 
   
   // �����ͺ��̽� �����ϱ�
   public JPanel getSubmitPane() {
	      if (submitPane == null) {
	    	  submitPane = new JPanel();
	    	  submitPane.setBorder(new TitledBorder("�����ͺ��̽� ���� �г�"));
	    	  submitPane.setBackground(Color.WHITE);
	    	 
	    	  
	    	  
	    	  String submitTextCheck = "[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ";
	    	  
	    	  submitText = new JLabel(submitTextCheck);	    	  
	    	
 	      
	    	  submitPane.add(submitText);
	    	  
	    	  
	    	  JButton submitBtn = new JButton("�����ϱ�");
 	      
	    	  
	    	  submitPane.add(submitBtn);
	    	  
	    	  submitBtn.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
	  	            @Override
	  	            public void mousePressed(MouseEvent e) { // ���콺 ��������	  	            	
	  	            	new JGDBInsert();	  	            	
	  	            	
	  	            }
	  	         });	
 	      
	      }
	      return submitPane;
	   }
	   
   

   
   // �����ͺ��̽� ���� Ȯ���ϱ�
   public JPanel getSubmitConfirmPane() {
	      if (submitConfirmPane == null) {
	    	  submitConfirmPane = new JPanel();
	    	  submitConfirmPane.setBorder(new TitledBorder("�����ͺ��̽� ����Ȯ�� �г�"));
	    	  submitConfirmPane.setBackground(Color.WHITE);
	    	 
	    	  String submitConfirmTextCheck = "[   �����ͺ��̽� ����Ȯ�� �г�   ]     ";
	    	  
	    	  JLabel submitConfirmText = new JLabel(submitConfirmTextCheck);
	    	  
	    	  JButton submitConfirmBtn = new JButton("��������� Ȯ���ϱ�");
 	      
	    	  submitConfirmPane.add(submitConfirmText);
	    	  submitConfirmPane.add(submitConfirmBtn);
	    	  
	    	  submitConfirmBtn.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ
	  	            @Override
	  	            public void mousePressed(MouseEvent e) { // ���콺 ��������
	  	            	new JGDBUserSelect();
	  	            	submitConfirmText.setText("[   "+ JGDBUser.UserName + " / " + JGDBUser.Password + " / "  + JGDBUser.DarkMode + " / " + JGDBUser.FontSize + " / " +  JGDBUser.Country + "   ]     ");	  	            	
	  	            }
	  	         });	
 	      
	      }
	      return submitConfirmPane;
	   }  
   
   
   
   // /////////////////////////////////////////////////////////////
   // �ð� ���� Ŭ����
   public class TimeDataSetting extends Thread {

      private TimeZone time;

      JLabel firstMain;
      JLabel secondMain;
      JLabel thirdMain;
      DateFormat one;
      DateFormat two;

      public TimeZone getTime() {
         return time;
      }

      public void setTime(TimeZone time) {
         this.time = time;
      }

      public void setFirstMain(JLabel firstMain) {
         this.firstMain = firstMain;
      }

      public void setSecondMain(JLabel secondMain) {
         this.secondMain = secondMain;
      }

      public void setThirdMain(JLabel thirdMain) {
         this.thirdMain = thirdMain;
      }

      public String getTimeZoneData() {
         return TimeZoneData;
      }

      public void setTimeZoneData(String timeZoneData) {
         TimeZoneData = timeZoneData;
      }

      @Override
      public void run() {
         one = new SimpleDateFormat("yyyy . MM . dd  E", Locale.ENGLISH); // z : KST ǥ��
         two = new SimpleDateFormat("HH : mm : ss", Locale.ENGLISH);
         time = TimeZone.getTimeZone(TimeZoneData);
         while (true) {// ������ ����
            Date date = new Date();

            one.setTimeZone(time);
            two.setTimeZone(time);
            try { // Ʈ����
               firstMain.setText(one.format(date));
               secondMain.setText(two.format(date));
               thirdMain.setText("JG Times");
               Thread.sleep(1000);// 1��
            } catch (Exception e) {
            } // ����ó��
         }
      }
   } 
   // /////////////////////////////////////////////////////////////

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JAGUTIMES_Final jFrame = new JAGUTIMES_Final();
            jFrame.setVisible(true);
         }
      });
   }
}