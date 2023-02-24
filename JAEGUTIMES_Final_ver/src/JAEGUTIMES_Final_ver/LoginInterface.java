package JAEGUTIMES_Final_ver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class LoginInterface extends JFrame {

	private JButton korBtn, usBtn, ukBtn, franBtn, ausBtn, basicBtn, darkBtn,
   smallBtn, mediumBtn, largeBtn, uSubmit;
   
   private JPanel paneUserName, panePassWord, paneCountry, paneDarkMode, paneFont, paneSubmit, 
   unameBox, pwBox, countryBox, darkBox, fontBox, submitBox  ;
   private JLabel userName, passWord, counTry, darkMode, fontSize;
   private JTextField uName, uPw;
   
   private Font font = new Font("DS-Digital", Font.BOLD, 30); // label font ����
   private Font cnBtnFont = new Font("DS-Digital", Font.BOLD,15); // button font
   private Font mdBtnFont = new Font("DS-Digital", Font.BOLD,25); // button font
   private Font szBtnFont = new Font("DS-Digital", Font.BOLD,30); // button font
   Dimension cntSize = new Dimension(40,40);
   Dimension mdSize = new Dimension(90, 40);
   Dimension szSize = new Dimension(40,40);

   public LoginInterface() {
      // ���� ǥ���� ����
      this.setTitle("Login");

      // ���� ��ư �⺻ ���
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      this.getContentPane().setLayout(new GridLayout(6,1));
      this.getContentPane().add(getPaneUserName());
      this.getContentPane().add(getPanePassWord());
      this.getContentPane().add(getPaneCountry());
      this.getContentPane().add(getPaneDarkMode());
      this.getContentPane().add(getPaneFont());
      this.getContentPane().add(getPaneSubmit());      
      

      // JFrame ũ��
      this.setSize(400, 600);
      this.setResizable(false);

      // JWindow�� ȭ�� �߾����� ����
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      Point centerPoint = ge.getCenterPoint();
      int leftTopX = centerPoint.x - this.getWidth() / 2;
      int leftTopY = centerPoint.y = this.getHeight() / 2;
      this.setLocation(leftTopX, leftTopY);
      this.setVisible(true);
   }

   // UserName�г�
   public JPanel getPaneUserName() {
      if (paneUserName == null) {
         paneUserName = new JPanel();
         paneUserName.setBackground(new Color(255, 241, 169));
         paneUserName.setLayout(new GridLayout(1,2));
         paneUserName.add(getUserName());
         paneUserName.add(getunameBox());
      }
      return paneUserName;
   }
   
   // UserName
   public JLabel getUserName() {
      if (userName == null) {
         userName = new JLabel("USERNAME");
         // Label �� ���� Center ����
         userName.setHorizontalAlignment(JLabel.CENTER);
         userName.setFont(font);
      }
      return userName;
   };
   
   // UserName�г�
   public JPanel getunameBox() {
      if (unameBox == null) {
         unameBox = new JPanel();
         unameBox.setBackground(new Color(255, 241, 169));
//         unameBox.setLayout(new FlowLayout());
         unameBox.setLayout(new GridBagLayout());
         unameBox.add(getuName());
      }
      return unameBox;
   }

   // uName �Է�
   public JTextField getuName() {
      if (uName == null) {
         uName = new JTextField(10);
         uName.setLocation(20, 20);
         uName.setFont(new Font("DS-Digital", Font.PLAIN,20));
         
      }
      return uName;
   };
   


   
   
   
   // panePassWord�г�
   public JPanel getPanePassWord() {
      if (panePassWord == null) {
         panePassWord = new JPanel();
         panePassWord.setBackground(new Color(255, 241, 169));
         panePassWord.setLayout(new GridLayout(1,2));
         // paneUserName.add(getPaneUserName(), BorderLayout.NORTH);
         panePassWord.add(getPassword());
         panePassWord.add(getPwBox());

      }
      return panePassWord;
   }
   
   // Password
   public JLabel getPassword() {
      if (passWord == null) {
         passWord = new JLabel("PASSWORD");
         passWord.setFont(font);
         passWord.setHorizontalAlignment(JLabel.CENTER);

      }
      return passWord;
   };
   
   // userPw �г�
   public JPanel getPwBox() {
      if (pwBox == null) {
         pwBox = new JPanel();
//         pwBox.setSize(120, 120);
         pwBox.setBackground(new Color(255, 241, 169));
         pwBox.setLayout(new GridBagLayout());
         pwBox.add(getuPw());
      }
      return pwBox;
   }
   

   // uPw �Է�
   public JTextField getuPw() {
      if (uPw == null) {
         uPw = new JTextField(10);
//         uPw.setPreferredSize(new Dimension(100, 50));
         uPw.setFont(new Font("DS-Digital", Font.PLAIN, 20));
      }
      return uPw;
   };
   

   
   
   
   
   
   
   
   
   
   // paneCountry�г�
   public JPanel getPaneCountry() {
      if (paneCountry == null) {
         paneCountry = new JPanel();
         paneCountry.setBackground(new Color(255, 241, 169));
         paneCountry.setLayout(new GridLayout(1,2));
         // paneUserName.add(getPaneUserName(), BorderLayout.NORTH);
         paneCountry.add(getCountry());
         paneCountry.add(getCountryBox());
      }
      return paneCountry;
   }
   
   // Country ��
   public JLabel getCountry() {
      if (counTry == null) {
         counTry = new JLabel("COUNTRY");
         counTry.setHorizontalAlignment(JLabel.CENTER);
         counTry.setFont(font);
      }
      return counTry;
   };
   

   // paneCountry �г�
   public JPanel getCountryBox() {
      if (countryBox == null) {
         countryBox = new JPanel();
         

         countryBox.setBackground(new Color(255, 241, 169));
         countryBox.setLayout(new FlowLayout(FlowLayout.LEFT));
         countryBox.setLayout(new GridBagLayout());

         
         countryBox.add(getkorBtn());
         countryBox.add(getusBtn());
         countryBox.add(getukBtn());
         countryBox.add(getfranBtn());
         countryBox.add(getausBtn());
      }
      return countryBox;
   }

   // kor ��ư
   public JButton getkorBtn() {
      if (korBtn == null) {
         korBtn = new JButton("KOR");
         korBtn.setFont(cnBtnFont);
         korBtn.setPreferredSize(cntSize);
         korBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return korBtn;
   };
   
   // us ��ư
   public JButton getusBtn() {
      if (usBtn == null) {
         usBtn = new JButton("USA");
         usBtn.setPreferredSize(cntSize);
         usBtn.setFont(cnBtnFont);

         usBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return usBtn;
   };
   
   // UK ��ư
   public JButton getukBtn() {
      if (ukBtn == null) {
         ukBtn = new JButton("UK");
         ukBtn.setPreferredSize(cntSize);
         ukBtn.setFont(cnBtnFont);

         ukBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return ukBtn;
   };
   
   // FRANCE ��ư
   public JButton getfranBtn() {
      if (franBtn == null) {
         franBtn = new JButton("FRA");
         franBtn.setPreferredSize(cntSize);
         franBtn.setFont(cnBtnFont);

         franBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return franBtn;
   };
   
   // AUST ��ư
   public JButton getausBtn() {
      if (ausBtn == null) {
         ausBtn = new JButton("AUS");
         ausBtn.setPreferredSize(cntSize);
         ausBtn.setFont(cnBtnFont);

         ausBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return ausBtn;
   };
   
   
   
   
   
   
   
   
   
   
   
   
   
   // paneDarkMode�г�
   public JPanel getPaneDarkMode() {
      if (paneDarkMode == null) {
         paneDarkMode = new JPanel();
         paneDarkMode.setBackground(new Color(255, 241, 169));
         paneDarkMode.setLayout(new GridLayout(1,2));
         paneDarkMode.add(getDarkmode());
         paneDarkMode.add(getdarkBox());
      }
      return paneDarkMode;
   }
   
   // darkmod ��
   public JLabel getDarkmode() {
      if (darkMode == null) {
         darkMode = new JLabel("MODE");
         darkMode.setFont(font);
         darkMode.setHorizontalAlignment(JLabel.CENTER);
      }
      return darkMode;
   };
   

   // darkmod �г�
   public JPanel getdarkBox() {
      if (darkBox == null) {
         darkBox = new JPanel();
         darkBox.setBackground(new Color(255, 241, 169));
         darkBox.setLayout(new FlowLayout(FlowLayout.LEFT));
         darkBox.setLayout(new GridBagLayout());
         
         darkBox.add(getbasicBtn());
         darkBox.add(getdarkBtn());
      }
      return darkBox;
   }

   // basic ��ư
   public JButton getbasicBtn() {
      if (basicBtn == null) {
         basicBtn = new JButton("BASIC");
         basicBtn.setFont(mdBtnFont);
         basicBtn.setPreferredSize(mdSize);
//         uDark.setPreferredSize(new Dimension(100, 50));
         basicBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return basicBtn;
   };
   
   
   // dark ��ư
   public JButton getdarkBtn() {
      if (darkBtn == null) {
         darkBtn = new JButton("DARK");
         darkBtn.setFont(mdBtnFont);
         darkBtn.setPreferredSize(mdSize);

//         uDark.setPreferredSize(new Dimension(100, 50));
         darkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return darkBtn;
   };
   
   
   
   
   
   
   
   
   // fontSize�г�
   public JPanel getPaneFont() {
      if (paneFont == null) {
         paneFont = new JPanel();
         paneFont.setBackground(new Color(255, 241, 169));
         paneFont.setLayout(new GridLayout(1,2));
         // paneUserName.add(getPaneUserName(), BorderLayout.NORTH);
         paneFont.add(getFontSize());
         paneFont.add(getFontBox());
      }
      return paneFont;
   }
   
   // font ��
   public JLabel getFontSize() {
      if (fontSize == null) {
         fontSize = new JLabel("FONT");
         fontSize.setFont(font);
         fontSize.setHorizontalAlignment(JLabel.CENTER);
      }
      return fontSize;
   };
   

   // font �г�
   public JPanel getFontBox() {
      if (fontBox == null) {
         fontBox = new JPanel();
         fontBox.setBackground(new Color(255, 241, 169));
         fontBox.setLayout(new FlowLayout(FlowLayout.LEFT));
         fontBox.setLayout(new GridBagLayout());
         fontBox.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));

         fontBox.add(getSmallBtn());
         fontBox.add(getMediumBtn());
         fontBox.add(getLargeBtn());
      }
      return fontBox;
   }

   // basic ��ư
   public JButton getSmallBtn() {
      if (smallBtn == null) {
         smallBtn = new JButton("S");
         smallBtn.setPreferredSize(cntSize);
         smallBtn.setFont(szBtnFont);

         smallBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return smallBtn;
   };
   
   
   // smallBtn ��ư
   public JButton getMediumBtn() {
      if (mediumBtn == null) {
         mediumBtn = new JButton("M");
         mediumBtn.setPreferredSize(cntSize);
         mediumBtn.setFont(szBtnFont);

//         uDark.setPreferredSize(new Dimension(100, 50));
         mediumBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return mediumBtn;
   };
   
   // mediumBtn ��ư
   public JButton getLargeBtn() {
      if (largeBtn == null) {
         largeBtn = new JButton("L");
         largeBtn.setPreferredSize(cntSize);
         largeBtn.setFont(szBtnFont);

//         uDark.setPreferredSize(new Dimension(100, 50));
         largeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
            }
         });
      }
      return largeBtn;
   };
   
   
   
   
   

   
   // paneSubmit�г�
   public JPanel getPaneSubmit() {
      if (paneSubmit == null) {
         paneSubmit = new JPanel();
         paneSubmit.setBackground(new Color(255, 241, 169));
         paneSubmit.setLayout(new GridLayout(1,2));
         paneSubmit.add(getSubmitBox());
      }
      return paneSubmit;
   }
   
   // submitCenter�� ���߱� ���� box
   public JPanel getSubmitBox() {
      if (submitBox == null) {
         submitBox = new JPanel();
         submitBox.setBackground(new Color(255, 241, 169));
         submitBox.setLayout(new GridBagLayout());
         submitBox.add(getuSubmit());
      }
      return submitBox;
   }


   // submit ��ư
   public JButton getuSubmit() {
      if (uSubmit == null) {
         uSubmit = new JButton("SUBMIT");
         uSubmit.setFont(font);
//         uDark.setPreferredSize(new Dimension(100, 50));
         uSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Ŭ���� ������ ����
               System.exit(0);
            }
         });
      }
      return uSubmit;
   };
   
   
   
   public static void main(String[] args) {
            
      new LoginInterface();
   }
}