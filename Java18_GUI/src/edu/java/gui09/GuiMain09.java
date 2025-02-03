package edu.java.gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain09 {

   private JFrame frame;
   private JButton btnOutput;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain09 window = new GuiMain09();
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
   public GuiMain09() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 484, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JCheckBox chckbxMusic = new JCheckBox("음악");
      chckbxMusic.setBounds(8, 6, 115, 23);
      frame.getContentPane().add(chckbxMusic);
      
      JCheckBox chckbxMovie = new JCheckBox("영화");
      chckbxMovie.setBounds(127, 6, 104, 23);
      frame.getContentPane().add(chckbxMovie);
      
      JCheckBox chckbxReading = new JCheckBox("독서");
      chckbxReading.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(chckbxReading.isSelected()) { // 독서 체크박스를 선택하면
               btnOutput.setEnabled(false);
            } else {
               btnOutput.setEnabled(true);
            }
         }
      });
      chckbxReading.setBounds(235, 6, 115, 23);
      frame.getContentPane().add(chckbxReading);
      
      JTextArea textArea = new JTextArea();
      textArea.setBounds(8, 50, 448, 201);
      frame.getContentPane().add(textArea);
      
      btnOutput = new JButton("출력");
      btnOutput.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String result = "음악 : " + chckbxMusic.isSelected() + "\n"
                  + "영화 : " + chckbxMovie.isSelected() + "\n"
                  + "독서 : " + chckbxReading.isSelected() + "\n";
            
            textArea.setText(result);
         }
      });
      btnOutput.setBounds(358, 6, 97, 23);
      frame.getContentPane().add(btnOutput);
      
   }
}