package edu.java.gui11;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiMain11 {

   private JFrame frame;

   // 메인 메소드 : 메인 쓰레드에서 실행
   public static void main(String[] args) {
	   // UI 쓰레드 : UI 관련 객체를 관리
      EventQueue.invokeLater(new Runnable() {
         public void run() { // UI 쓰레드가 실행해야 하는 코드
            try {
               GuiMain11 window = new GuiMain11();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   public GuiMain11() {
	   initialize();
   }
   
   private void initialize() {
	   frame = new JFrame();
	   frame.setBounds(300, 300, 450, 300);
	   frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   frame.getContentPane().setLayout(null);
	   
	   JButton btn1 = new JButton("New Frame");
	   btn1.addActionListener(new ActionListener() {
		   
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// 새로운 프레임 생성
//			JFrame myFrame = new JFrame();
//			myFrame.setBounds(10, 10, 400, 400);
//			myFrame.setVisible(true); // 프레임이 보이게 설정

			// 일반적으로 새로운 프레임이나, 다이얼로그를 생성할 때는
			// 각 클래스들을 상속받는 자식 클래스를 만들어 사용하는 것이
			// 가독성 및 유지보수 측면에서 더 좋음
			
			MyFrame myFrame = new MyFrame();
			myFrame.setVisible(true);
			frame.setVisible(false);
		}
	});
	   btn1.setFont(new Font("굴림", Font.BOLD, 30));
	   btn1.setBounds(12, 38, 410, 62);
	   frame.getContentPane().add(btn1);
	   // JFrame에는 contentPane이 포함되어 있다.
	   // 버튼과 텍스트 등 Component는 contentPane에 add해야 한다.
   }
}
