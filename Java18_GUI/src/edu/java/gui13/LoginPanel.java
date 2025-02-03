package edu.java.gui13;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class LoginPanel extends JPanel{
   public LoginPanel() {
      setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel lblNewLabel = new JLabel("로그인 되었습니다");
      lblNewLabel.setBounds(103, 98, 225, 60);
      add(lblNewLabel);
      
   }
}