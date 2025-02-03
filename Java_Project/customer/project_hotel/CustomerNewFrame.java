package project_hotel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CustomerNewFrame extends JFrame {
    private JPanel contentPane;
    private JTextField txtId;
    private JPasswordField txtPw;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private String selectedDate;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JFrame frame;
    public static CustomerDAO dao;
    
    // 각 월별 최대 일수를 저장한 배열 (2월은 윤년을 고려하지 않은 28일로 설정)
    private static final int[] daysInMonth = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    // 프레임의 GUI 구현
    public CustomerNewFrame() {
        super("회원 가입");
        dao = CustomerDAOImple.getInstance();
        frame = this;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 200, 397, 465);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        txtId = new JTextField();
        txtId.setBounds(125, 14, 194, 33);
        contentPane.add(txtId);
        txtId.setColumns(10);
        
        txtPw = new JPasswordField();
        txtPw.setColumns(10);
        txtPw.setBounds(125, 53, 194, 33);
        contentPane.add(txtPw);
        
        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(125, 96, 194, 33);
        contentPane.add(txtName);
        
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(125, 139, 194, 33);
        contentPane.add(txtPhone);
        
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(125, 182, 194, 33);
        contentPane.add(txtEmail);
        
        String[] years = new String[101];
        for (int i = 0; i <= 100; i++) {
            years[i] = String.valueOf(2023 - i); // 현재 연도를 기준으로 생성
        }
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setBounds(125, 225, 66, 33);
        contentPane.add(yearBox);
        
        // 월 선택
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setBounds(195, 225, 66, 33);
        contentPane.add(monthBox);
        
        // 일 선택
        final JComboBox<String> dayBox = new JComboBox<>();
        dayBox.setBounds(265, 225, 66, 33);
        contentPane.add(dayBox);

        // 최초 초기화: 1월에 맞는 일 수로 설정
        updateDaysForMonth(0, dayBox); // 0은 1월을 의미 (배열에서 0부터 시작)

        // 월이 바뀔 때마다 일수를 업데이트
        monthBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedMonth = monthBox.getSelectedIndex(); // 0부터 11까지
                updateDaysForMonth(selectedMonth, dayBox);
            }
        });
        
        // 성별 선택
        maleButton = new JRadioButton("M");
        femaleButton = new JRadioButton("F");
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleButton);
        sexGroup.add(femaleButton);
        contentPane.add(maleButton);
        maleButton.setBounds(125, 268, 53, 33);
        contentPane.add(femaleButton);
        femaleButton.setBounds(185, 268, 53, 33);
        
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
        
        JButton CreateAc = new JButton("회원 등록");
        CreateAc.setBounds(105, 357, 170, 53);
        CreateAc.setFont(new Font("굴림", Font.PLAIN, 16));
        contentPane.add(CreateAc);
        CreateAc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // 등록 메소드와 연결
                selectedDate = yearBox.getSelectedItem() + "-" +
                        monthBox.getSelectedItem() + "-" +
                        dayBox.getSelectedItem();
                CreateAccount();
            }
        });
    }

    // 월별로 일 수를 업데이트하는 메소드
    private void updateDaysForMonth(int monthIndex, JComboBox<String> dayBox) {
        // 해당 월의 일 수를 가져온다.
        int days = daysInMonth[monthIndex];
        
        // 2월일 경우 윤년 체크
        if (monthIndex == 1) {  // 2월 (배열에서 1번 인덱스)
            int year = Integer.parseInt(((JComboBox<String>) contentPane.getComponent(6)).getSelectedItem().toString());
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days = 29;  // 윤년
            }
        }
        
        // 일 수 갱신
        dayBox.removeAllItems();
        for (int i = 1; i <= days; i++) {
            dayBox.addItem(String.format("%02d", i));  // 두 자리 형식
        }
    }

    // 회원 가입 메소드
    public void CreateAccount() {
        // 아이디 입력
        String id = txtId.getText();
        // 비밀번호 입력
        String pw = String.valueOf(txtPw.getPassword());
        // 이름 입력
        String name = txtName.getText();
        // 전화번호 입력
        String phone = txtPhone.getText(); 
        // 이메일 입력
        String email = txtEmail.getText();
        // 생일 입력
        String birth = selectedDate;
        // 성별 입력
        String gender = "";
        if(maleButton.isSelected()) {
            gender = maleButton.getText();
        } else if(femaleButton.isSelected()) {
            gender = femaleButton.getText();
        }
        
        if (id.isEmpty() || pw.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "빈칸을 채워주세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        CustomerVO vo = new CustomerVO(id, pw, name, phone, email, birth, gender);
        if(dao.checkId(id)) {
            JOptionPane.showMessageDialog(frame, "중복된 아이디입니다","가입 실패", JOptionPane.ERROR_MESSAGE);
        } else {
            dao.insert(vo);
            JOptionPane.showMessageDialog(frame, "등록 완료");
            frame.setVisible(false);
        }
    }
}
