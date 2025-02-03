package edu.java.gui12;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	private JPanel contentPane; 
	
	public MyFrame(String text) {
		setBounds(300, 300, 450, 300);
		
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창 종료
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel(); // frame.getContentPane()과 같은 의미
		getContentPane().setLayout(null);
		
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton(text);
		btnNewButton.setBounds(168, 10, 97, 23);
		contentPane.add(btnNewButton);
		
	}
}
