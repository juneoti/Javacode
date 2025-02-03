package edu.java.gui01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class GuiMain01 {

   private JFrame frame;


   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain01 window = new GuiMain01();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public GuiMain01() {
      initialize();
   }


   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new BorderLayout(0, 0));
      
      JLabel northlbl = new JLabel("North");
      frame.getContentPane().add(northlbl, BorderLayout.NORTH);
      
      JLabel westlbl = new JLabel("West");
      frame.getContentPane().add(westlbl, BorderLayout.WEST);
      
      JLabel centertlbl = new JLabel("Center");
      frame.getContentPane().add(centertlbl, BorderLayout.CENTER);
      
      JLabel eastlbl = new JLabel("East");
      frame.getContentPane().add(eastlbl, BorderLayout.EAST);
      
      JLabel southlbl = new JLabel("South");
      frame.getContentPane().add(southlbl, BorderLayout.SOUTH);
   } // end main()

} // end GuiMain01






