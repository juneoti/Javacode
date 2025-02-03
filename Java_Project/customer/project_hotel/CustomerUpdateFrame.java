package project_hotel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class CustomerUpdateFrame extends JFrame{

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPw;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtBirth;
	private JTextField txtGender;
	private JFrame frame;
	public static CustomerDAO dao; 
	
	// 정보 변경 프레임 GUI 구성
	public CustomerUpdateFrame(String customerId) {
		super("회원 정보 수정");
		dao = CustomerDAOImple.getInstance();
    	String id = customerId;
    	CustomerVO vo = dao.select(id);
		frame = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 397, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField(vo.getCustomerID());
		txtId.setBounds(125, 14, 194, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		txtId.setEditable(false);
		
		txtPw = new JTextField(vo.getCustomerPW());
		txtPw.setColumns(10);
		txtPw.setBounds(125, 53, 194, 33);
		contentPane.add(txtPw);
		
		txtName = new JTextField(vo.getCustomerName());
		txtName.setColumns(10);
		txtName.setBounds(125, 96, 194, 33);
		contentPane.add(txtName);
		
		txtPhone = new JTextField(vo.getCustomerPhone());
		txtPhone.setColumns(10);
		txtPhone.setBounds(125, 139, 194, 33);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField(vo.getCustomerEmail());
		txtEmail.setColumns(10);
		txtEmail.setBounds(125, 182, 194, 33);
		contentPane.add(txtEmail);
		
		txtBirth = new JTextField(vo.getCustomerBirth());
		txtBirth.setColumns(10);
		txtBirth.setBounds(125, 225, 194, 33);
		contentPane.add(txtBirth);
		txtBirth.setEditable(false);
		
		txtGender = new JTextField(vo.getCustomerGender());
		txtGender.setColumns(10);
		txtGender.setBounds(125, 268, 194, 33);
		contentPane.add(txtGender);
		txtGender.setEditable(false);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 14, 101, 33);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(12, 53, 101, 33);
		contentPane.add(lblPw);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 96, 101, 33);
		contentPane.add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(12, 139, 101, 33);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(12, 182, 101, 33);
		contentPane.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("생년월일");
		lblDateOfBirth.setBounds(12, 225, 101, 33);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setBounds(12, 268, 101, 24);
		contentPane.add(lblGender);
		
		JButton UpdateAc = new JButton("정보 수정");
		UpdateAc.setBounds(105, 357, 170, 53);
		contentPane.add(UpdateAc);
		UpdateAc.setFont(new Font("굴림", Font.PLAIN, 16));
		UpdateAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				UpdateAccount(customerId);
				
			}
		});
	}
	
	// 회원 정보 변경 메소드
	public void UpdateAccount(String customerId) {
	    String id = txtId.getText();
	    String pw = txtPw.getText();
	    String name = txtName.getText();
	    String phone = txtPhone.getText(); 
	    String email = txtEmail.getText();
	    String birth = txtBirth.getText();
	    String gender = txtGender.getText();
	    
	    if (id.isEmpty() || pw.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty()) {
	        JOptionPane.showMessageDialog(frame, "빈칸을 채워주세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    CustomerVO vo = new CustomerVO(id, pw, name, phone, email, birth, gender);
	    dao.update(customerId, vo);
	    
	    // 변경 후 정보 다이얼로그 출력
	    StringBuilder message = new StringBuilder();
	    message.append("변경 완료\n\n");
	    message.append("아이디: ").append(vo.getCustomerID()).append("\n");
	    message.append("비밀번호: ").append(vo.getCustomerPW()).append("\n");
	    message.append("이름: ").append(vo.getCustomerName()).append("\n");
	    message.append("전화번호: ").append(vo.getCustomerPhone()).append("\n");
	    message.append("이메일: ").append(vo.getCustomerEmail()).append("\n");
	    message.append("생년월일: ").append(vo.getCustomerBirth()).append("\n");
	    message.append("성별: ").append(vo.getCustomerGender()).append("\n");

	    JOptionPane.showMessageDialog(frame, message.toString(), "변경 완료", JOptionPane.INFORMATION_MESSAGE);
	    frame.setVisible(false);
	}


}






