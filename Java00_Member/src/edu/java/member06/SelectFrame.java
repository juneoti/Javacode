package edu.java.member06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SelectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPw;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtInterest;
	private JFrame frame;

	private MemberDAO dao;
	private JLabel lblRegDate;
	private JTextField txtRegDate;
	private JButton btnDelete;

	public SelectFrame(int index) {
		
		frame = this;
		dao = MemberDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MemberVO vo = dao.select(index);
		
		txtId = new JTextField(vo.getId());
		txtId.setEditable(false);
		txtId.setBounds(125, 10, 144, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField(vo.getPw());
		txtPw.setColumns(10);
		txtPw.setBounds(125, 53, 144, 33);
		contentPane.add(txtPw);
		
		txtName = new JTextField(vo.getName());
		txtName.setColumns(10);
		txtName.setBounds(125, 96, 144, 33);
		contentPane.add(txtName);
		
		txtEmail = new JTextField(vo.getEmail());
		txtEmail.setColumns(10);
		txtEmail.setBounds(125, 139, 144, 33);
		contentPane.add(txtEmail);
		
		txtInterest = new JTextField(vo.getInterest());
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
		
		JButton btnUpdate = new JButton("회원 수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = txtPw.getText();
				String name = txtName.getText();
				String email = txtEmail.getText();
				String interest = txtInterest.getText();
				
				
				MemberVO vo = new MemberVO("", pw, name, email, interest, null);
				
				int result = dao.update(index, vo);
				if(result == 1) {
					JOptionPane.showMessageDialog(frame, "수정 완료");
					frame.setVisible(false);
				}
				
			}
		});
		btnUpdate.setBounds(12, 300, 107, 53);
		contentPane.add(btnUpdate);
		
		lblRegDate = new JLabel("가입일");
		lblRegDate.setBounds(12, 225, 101, 24);
		contentPane.add(lblRegDate);
		
		txtRegDate = new JTextField(vo.getRegDate().toString());
		txtRegDate.setEditable(false);
		txtRegDate.setColumns(10);
		txtRegDate.setBounds(125, 225, 144, 33);
		contentPane.add(txtRegDate);
		
		btnDelete = new JButton("회원 삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = dao.delete();
				if(result == 1) {
					JOptionPane.showMessageDialog(frame, "삭제 완료");
					frame.setVisible(false);
				}
			}
		});
		btnDelete.setBounds(162, 300, 107, 53);
		contentPane.add(btnDelete);
	}

}




