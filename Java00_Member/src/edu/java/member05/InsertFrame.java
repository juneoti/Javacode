package edu.java.member05;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InsertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPw;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtInterest;
	private JFrame frame;
	private DefaultTableModel tableModel;

	private MemberDAO dao;
	
	public InsertFrame() {
		frame = this;
		dao = MemberDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(125, 10, 144, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setBounds(125, 53, 144, 33);
		contentPane.add(txtPw);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(125, 96, 144, 33);
		contentPane.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(125, 139, 144, 33);
		contentPane.add(txtEmail);
		
		txtInterest = new JTextField();
		txtInterest.setColumns(10);
		txtInterest.setBounds(125, 182, 144, 33);
		contentPane.add(txtInterest);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 14, 101, 24);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(12, 53, 101, 24);
		contentPane.add(lblPw);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 96, 101, 24);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(12, 139, 101, 24);
		contentPane.add(lblEmail);
		
		JLabel lblInterest = new JLabel("취미");
		lblInterest.setBounds(12, 182, 101, 24);
		contentPane.add(lblInterest);
		
		JButton btnInsert = new JButton("회원 등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String pw = txtPw.getText();
				String name = txtName.getText();
				String email = txtEmail.getText();
				String interest = txtInterest.getText();
				Date regDate = new Date();
				
				MemberVO vo = new MemberVO(id, pw, name, email, interest, regDate);
				
				int result = dao.insert(vo);
				if(result == 1) {
					JOptionPane.showMessageDialog(frame, "등록 완료");
					frame.setVisible(false);
				}
				
			}
		});
		btnInsert.setBounds(55, 257, 170, 53);
		contentPane.add(btnInsert);
	}
	
}






