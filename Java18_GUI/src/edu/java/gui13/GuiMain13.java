package edu.java.gui13;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;

public class GuiMain13 {

   private JFrame frame;
   private JPanel topPanel; // 로그인 버튼, 로그아웃 버튼, 아이디 입력 텍스트필드 등을 포함하는 판넬
   private JLabel lblInfo; // 정보 출력 레이블
   private JTextField txtInputId; // 아이디 입력 텍스트 필드
   private JButton btnLogin; // 로그인 버튼
   private JButton btnLogout; // 로그아웃 버튼
   
   private JPanel contentPanel; // 시작할 때 생성할 기본판넬
   private JPanel loginPanel; // 로그인 했을 때 보이는 판넬
   private JPanel logoutPanel; // 로그아웃 했을 때 보이는 판넬
   
   private Component currentComponent; // 현재 가지고 있는 컴퍼넌트 확인 변수 
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain13 window = new GuiMain13();
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
   public GuiMain13() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      topPanel = new JPanel();
      topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      frame.getContentPane().add(topPanel, BorderLayout.NORTH);
      topPanel.setLayout(new GridLayout(1, 0, 0, 0));
      
      lblInfo = new JLabel("안녕하세요");
      topPanel.add(lblInfo);
      
      txtInputId = new JTextField();
      topPanel.add(txtInputId);
      txtInputId.setColumns(10);
      
      btnLogin = new JButton("로그인");
      btnLogin.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            String id = txtInputId.getText();
            // 입력받은 id가 "test"인 경우에만
            if(id.equals("test")) {
               lblInfo.setText(id + "님 환영합니다.");
               btnLogin.setEnabled(false);
               btnLogout.setVisible(true);
               
               // 현재 판넬 제거
               frame.getContentPane().remove(currentComponent);
               frame.revalidate(); // 컴퍼넌트 재검토
               frame.repaint(); // 컴퍼넌트 다시 그림
               
               // 로그인 했을 때 보여줄 판넬 추가
               loginPanel = new LoginPanel();
               
               // 로그인 판넬을 프레임에 연결
               frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
               frame.revalidate();
               frame.repaint();
               
               currentComponent = loginPanel;
               
            }
         }
      });
      topPanel.add(btnLogin);
      
      btnLogout = new JButton("로그아웃");
      btnLogout.setVisible(false);
      btnLogout.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            lblInfo.setText("잘가세요!");
            btnLogin.setEnabled(true);
            btnLogout.setVisible(false);
            
            // 현재 판넬 제거
            frame.getContentPane().remove(currentComponent);
            frame.revalidate();
            frame.repaint();
            
            // 로그아웃 했을 때 보여줄 판넬 추가
            logoutPanel = new JPanel();
            JLabel lblLogout = new JLabel("로그아웃 되었습니다.");
            logoutPanel.add(lblLogout);
            
            // 로그아웃 판넬 연결
            frame.getContentPane().add(logoutPanel, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
            
            // 현재 컴퍼넌트 정보 변경
            currentComponent = logoutPanel;
         }
      });
      topPanel.add(btnLogout);
      
      contentPanel = new JPanel();
      contentPanel.setBackground(Color.PINK);
      frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
      // 현재 컴퍼넌트에 기본 판넬 저장
      currentComponent = contentPanel;
   } 

} // end GuiMain13



