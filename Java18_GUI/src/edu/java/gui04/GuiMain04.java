package edu.java.gui04;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GuiMain04 {

   private JFrame frame; // 프레임
   private JTextField textNumber1; // 숫자 1 입력 textField
   private JTextField textNumber2; // 숫자 2 입력 textField
   private JTextArea textArea; // 결과 출력 textArea

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GuiMain04 window = new GuiMain04();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public GuiMain04() {
      initialize();
   }

   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 700, 550);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      Font frameFont = new Font("굴림", Font.BOLD | Font.ITALIC, 48);
      JLabel lblNumber1 = new JLabel("Number 1");
      lblNumber1.setBounds(12, 10, 280, 70);
      lblNumber1.setFont(frameFont);
      frame.getContentPane().add(lblNumber1);

      JLabel lblNumber2 = new JLabel("Number 2");
      lblNumber2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 48));
      lblNumber2.setBounds(12, 90, 280, 70);
      frame.getContentPane().add(lblNumber2);

      textNumber1 = new JTextField();
      textNumber1.setBounds(304, 10, 368, 70);
      textNumber1.setFont(frameFont);
      frame.getContentPane().add(textNumber1);
      textNumber1.setColumns(10);

      textNumber2 = new JTextField();
      textNumber2.setColumns(10);
      textNumber2.setFont(frameFont);
      textNumber2.setBounds(304, 90, 368, 70);
      frame.getContentPane().add(textNumber2);

      // + 버튼 : 클릭하면 두 개의 숫자를 더한 결과를 출력
      JButton btnPlus = new JButton("+");
      btnPlus.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
				System.out.println("btnPlus : mouseClicked()");
				String num1 = textNumber1.getText();
				String num2 = textNumber2.getText();
				
				// 문자열을 실수(double)로 변환
				double x = Double.parseDouble(num1);
				double y = Double.parseDouble(num2);
				
				String plus = x + " + " + y + " = " + (x + y) + "\n";
				textArea.append(plus);
         }
      });
      btnPlus.setBounds(12, 170, 100, 100);
      btnPlus.setFont(frameFont);
      frame.getContentPane().add(btnPlus);

      // - 버튼 : 클릭하면 두 개의 숫자를 뺀 값을 출력
      JButton btnMinus = new JButton("-");
      btnMinus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 System.out.println("btnMinus : actionPerformed()");
				String num1 = textNumber1.getText();
				String num2 = textNumber2.getText();
				
				double x = Double.parseDouble(num1);
				double y = Double.parseDouble(num2);
				
				String minus = x + " - " + y + " = " + (x - y) + "\n";
				textArea.append(minus);
         }
      });
      btnMinus.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 48));
      btnMinus.setBounds(192, 170, 100, 100);
      frame.getContentPane().add(btnMinus);

      // * 버튼 : 엔터를 누르면 두 개의 숫자를 곱한 값을 출력
      JButton btnMultiple = new JButton("*");
      btnMultiple.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
				System.out.println("btnMultiple : keyPressed() ");
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { // 사용자가 누른 키의 정보를 받기
					System.out.println("엔터키 입력됨");
						String num1 = textNumber1.getText();
						String num2 = textNumber2.getText();
						
						double x = Double.parseDouble(num1);
						double y = Double.parseDouble(num2);
						
						String multiple = x + " * " + y + " = " + (x * y) + "\n";
						textArea.append(multiple);
				}
         }
      });
      btnMultiple.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 48));
      btnMultiple.setBounds(386, 170, 100, 100);
      frame.getContentPane().add(btnMultiple);

      JButton btnDivide = new JButton("/");
      btnDivide.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 System.out.println("btnDivide : mouseClicked()");
				String num1 = textNumber1.getText();
				String num2 = textNumber2.getText();
				
				double x = Double.parseDouble(num1);
				double y = Double.parseDouble(num2);
				
				String divide = x + " / " + y + " = " + (x / y) + "\n";
				textArea.append(divide);
         }
      });
      
      btnDivide.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
				System.out.println("btnDivide : keyPressed() ");
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_DIVIDE) {
					System.out.println("나누기 키 (/) 입력됨");
						String num1 = textNumber1.getText();
						String num2 = textNumber2.getText();
						
						double x = Double.parseDouble(num1);
						double y = Double.parseDouble(num2);
						
						String divide = x + " / " + y + " = " + (x / y) + "\n";
						textArea.append(divide);
         }
         }
      });
      btnDivide.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 48));
      btnDivide.setBounds(572, 170, 100, 100);
      frame.getContentPane().add(btnDivide);

      // JScrollPane : 표 형식의 데이터 출력을 위한 Pane 클래스
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(12, 280, 660, 221);
      frame.getContentPane().add(scrollPane);

      // JTextArea는 JScrollPane에 포함하여 사용하는 것을 권장
      textArea = new JTextArea();
      textArea.setFont(new Font("Monospaced", Font.PLAIN, 48));
      textArea.setEditable(false); // 편집 불가능
      scrollPane.setViewportView(textArea); // textArea를 scrollPane의 ViewPort에 적용

   }
}
