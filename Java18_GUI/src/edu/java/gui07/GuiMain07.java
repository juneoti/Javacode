package edu.java.gui07;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain07 {

   private JFrame frame;
   private static final String[] STRINGS = {
      "강동우", 
      "길현우",
      "김민섭",
      "김상호", 
      "김찬우",
      "김푸름", 
      "김형수",
      "김희승",
      "박재민",
      "박정빈",
      "배인서",
      "송하주",
      "임주찬",
      "장태영",
      "정민호",
      "정병은",
      "정하연",
      "최준우"
   };
   
   private int index = 0;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain07 window = new GuiMain07();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public GuiMain07() {
      initialize();
   }

   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 324, 402);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lblOutput = new JLabel();
      lblOutput.setText(STRINGS[0]);
      lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
      lblOutput.setBounds(12, 10, 216, 88);
      frame.getContentPane().add(lblOutput);
      
      
      JButton btnPrev = new JButton("이전");
      btnPrev.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if(index > 0) {
        	 index--;
        	 }else {
        		 index = STRINGS.length - 1;
        	 }
        	 lblOutput.setText(STRINGS[index]);
         }
      });
      btnPrev.setBounds(12, 160, 134, 137);
      btnPrev.setFont(new Font("굴림", Font.BOLD, 42));
      frame.getContentPane().add(btnPrev);
      
      JButton btnNext = new JButton("다음");
      btnNext.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (index < STRINGS.length - 1) {
        		 index++;        		 
        	 }else {
        		 index = 0;
        	 }
            lblOutput.setText(STRINGS[index]);
         }
      });
      btnNext.setFont(new Font("굴림", Font.BOLD, 42));
      btnNext.setBounds(162, 160, 134, 137);
      frame.getContentPane().add(btnNext);
   }
   
} // end GuiMain07
