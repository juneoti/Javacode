package edu.java.gui12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain12 {

   private JFrame frame;
   private JTextField textField;


   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain12 window = new GuiMain12();
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
   public GuiMain12() {
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
      
      JButton btnNewButton = new JButton("New button");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 String text = textField.getText();
        	 MyFrame myFrame = new MyFrame(text);
        	 myFrame.setVisible(true);
        	 
         }
      });
      
      textField = new JTextField();
      textField.setBounds(136, 21, 153, 49);
      frame.getContentPane().add(textField);
      textField.setColumns(10);
      
      btnNewButton.setBounds(136, 97, 153, 71);
      frame.getContentPane().add(btnNewButton);
   }
}
