package edu.java.gui03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiMain03 {

   private JFrame frame;
   private JTextField txtName;
   private JTextField txtPhone;
   private JTextField txtEmail;
   private JButton btnInsert;
   private JTextField txtOutput;
   private JTextArea textArea;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain03 window = new GuiMain03();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public GuiMain03() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 500, 650);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null); // Absolute layout
      
      int lblWidth = 245; // 레이블 넓이
      int lblHeight = 76; // 레이블 높이
      Font lblFont = new Font("굴림", Font.BOLD, 48);
      
      JLabel lblName = new JLabel("이름");
      lblName.setHorizontalAlignment(SwingConstants.CENTER);
      lblName.setBackground(Color.PINK);
      lblName.setOpaque(true); // 배경색 설정을 위한 세팅
      lblName.setBounds(12, 10, lblWidth, lblHeight);
      lblName.setFont(lblFont);
      frame.getContentPane().add(lblName);
      
      JLabel lblPhone = new JLabel("전화번호");
      lblPhone.setOpaque(true);
      lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
      lblPhone.setFont(lblFont);
      lblPhone.setBackground(Color.ORANGE);
      lblPhone.setBounds(12, 96, lblWidth, lblHeight);
      frame.getContentPane().add(lblPhone);
      
      JLabel lblEmail = new JLabel("이메일");
      lblEmail.setOpaque(true);
      lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
      lblEmail.setFont(lblFont);
      lblEmail.setBackground(new Color(30, 144, 255));
      lblEmail.setBounds(12, 182, lblWidth, lblHeight);
      frame.getContentPane().add(lblEmail);
      
      int txtWidth = 203;
      int txtHeight = 76;
      Font txtFont = new Font("굴림", Font.PLAIN, 30);
      
      txtName = new JTextField();
      txtName.setBounds(269, 10, txtWidth, txtHeight);
      txtName.setFont(txtFont);
      frame.getContentPane().add(txtName);
      txtName.setColumns(10);
      
      txtPhone = new JTextField();
      txtPhone.setFont(txtFont);
      txtPhone.setColumns(10);
      txtPhone.setBounds(269, 96, txtWidth, txtHeight);
      frame.getContentPane().add(txtPhone);
      
      txtEmail = new JTextField();
      txtEmail.setFont(txtFont);
      txtEmail.setColumns(10);
      txtEmail.setBounds(269, 182, txtWidth, txtHeight);
      frame.getContentPane().add(txtEmail);
      
      btnInsert = new JButton("정보 출력");
      btnInsert.setFont(txtFont);
      btnInsert.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String name = txtName.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            
            String msg = "이름 : " + name + "\n"
                     + "전화번호 : " + phone + "\n"
                     + "이메일 : " + email + "\n";
            txtOutput.setText(msg);
//            textArea.setText(msg);
            textArea.append(msg); // 문자열을 연결해서 출력
            
         }
      });
      btnInsert.setBounds(12, 268, 460, 76);
      frame.getContentPane().add(btnInsert);
      txtOutput = new JTextField();
      txtOutput.setFont(txtFont);
      txtOutput.setBounds(12, 354, 460, 76);
      frame.getContentPane().add(txtOutput);
      txtOutput.setColumns(10);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(12, 440, 460, 161);
      frame.getContentPane().add(scrollPane);
      
      textArea = new JTextArea();
      scrollPane.setViewportView(textArea);
      
   }
} // end GuiMain03





