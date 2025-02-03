package edu.java.gui02;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain02 {

   private JFrame frame;
   private JTextField txtInput;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain02 window = new GuiMain02();
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
   public GuiMain02() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lblOutput = new JLabel("오늘은 월요일입니다.");
      lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
      lblOutput.setForeground(Color.BLUE);
      lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      lblOutput.setBounds(12, 10, 410, 45);
      frame.getContentPane().add(lblOutput);
      
      txtInput = new JTextField();
      txtInput.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
      txtInput.setBounds(12, 64, 410, 58);
      frame.getContentPane().add(txtInput);
      txtInput.setColumns(10);
      
      JButton btnInput = new JButton("입력");
      btnInput.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            // 버튼을 클릭했을 때 해야할 기능 구현
            // JTextField에 입력된 내용을 읽어서 JLabel에 작성
            String msg = txtInput.getText();
            System.out.println(msg);
            lblOutput.setText(msg);
         }
      });
      btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
      btnInput.setBounds(12, 145, 410, 81);
      frame.getContentPane().add(btnInput);
      
      System.out.println("initialize 메소드 호출 끝");
   }
} // end GuiMain02








