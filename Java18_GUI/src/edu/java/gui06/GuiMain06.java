package edu.java.gui06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GuiMain06 {

   private JFrame frame;
   private final ButtonGroup buttonGroup = new ButtonGroup();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain06 window = new GuiMain06();
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
   public GuiMain06() {
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

      JTextArea textArea = new JTextArea();
      textArea.setBounds(8, 63, 414, 188);
      frame.getContentPane().add(textArea);
      
      JRadioButton rdbtnMale = new JRadioButton("남자");
      
      buttonGroup.add(rdbtnMale);
      rdbtnMale.setSelected(true);
      rdbtnMale.setBounds(8, 6, 121, 23);
      frame.getContentPane().add(rdbtnMale);
      
      JRadioButton rdbtnFemale = new JRadioButton("여자");
      
      buttonGroup.add(rdbtnFemale);
      rdbtnFemale.setBounds(181, 6, 121, 23);
      frame.getContentPane().add(rdbtnFemale);
      
      JButton btnCheck = new JButton("확인");
      btnCheck.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // 남자 선택인 경우 -> 확인버튼 클릭 -> textArea에 "성별 : 남자" 출력
            // 여자 선택인 경우 -> 확인버튼 클릭 -> textArea에 "성별 : 여자" 출력
            if(rdbtnMale.isSelected()) {
               textArea.setText("성별 : 남자");
            } else {
               textArea.setText("성별 : 여자");
            }
         }
      });
      btnCheck.setBounds(8, 30, 97, 23);
      frame.getContentPane().add(btnCheck);
      
   }
}
