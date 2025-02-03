package edu.java.contact06;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ContactMain06 {
   
   private JFrame frame; // 메인 프레임
   // 이름, 전화번호, 이메일, 인덱스를 입력받는 textField
   
   private JTextField txtName, txtPhone, txtEmail, txtIndex;
   // 연락처 정보, 로그 정보를 출력하는 textArea
   private JTextArea txtAreaInfo, txtAreaLog;
   
   /* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
   private JTable table;
   // 테이블 헤더에 들어갈 이름들
   private String[] colNames = {"No", "이름", "전화번호", "이메일"};
   // 테이블 데이터를 저장할 배열 객체
   private Object[] records = new Object[colNames.length];
   private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수
   public static ContactDAO dao; 
   
   public static void main(String[] args) {
	   dao = ContactDAOImple.getInstance();
	   EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ContactMain06 window = new ContactMain06();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   public ContactMain06() {
      initialize();
      selectAllContactTable();
   }

   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 786, 662);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      // JLabel 변수 선언, 인스턴스 생성 및 font, bounds 설정. 4개
      
      // JLabel에서 사용할 폰트 및 bounds의 width, height 값 설정
      Font lblFont = new Font("굴림", Font.PLAIN, 42);
		int lblWidth = 180;
		int lblHeight = 55;
		
	  // JLabel 타이틀 설정
      JLabel lblTitle = new JLabel("연락처 프로그램 Version 0.6");
      lblTitle.setFont(lblFont);
      lblTitle.setBounds(10, 10, 740, 70);
      frame.getContentPane().add(lblTitle);
      
      // JLabel 이름 설정
      JLabel lblName = new JLabel("이름");
      lblName.setFont(lblFont);
	  lblName.setBounds(10, 90, lblWidth, lblHeight);
	  frame.getContentPane().add(lblName);
	  
	  // JLabel 전화번호 설정
      JLabel lblPhone = new JLabel("전화번호");
      lblPhone.setFont(lblFont);
	  lblPhone.setBounds(10, 150, lblWidth, lblHeight);
	  frame.getContentPane().add(lblPhone);
	  
	  // JLabel 이메일 설정
      JLabel lblEmail = new JLabel("이메일");
      lblEmail.setFont(lblFont);
	  lblEmail.setBounds(10, 210, lblWidth, lblHeight);
	  frame.getContentPane().add(lblEmail);
	  
      // JTextField 인스턴스 생성 및 font, bounds 설정. 4개
	  
	  // JTextField 에서 사용할 폰트 및 bound의 width, height 값 설정
	  Font txtFont = new Font("굴림", Font.PLAIN, 42);
		int txtWidth = 330;
		int txtHeight = 55;
	  
	  // JTextField 이름 설정
	  txtName = new JTextField();
	  txtName.setFont(txtFont);
	  txtName.setBounds(200, 90, txtWidth, txtHeight);
	  frame.getContentPane().add(txtName);
	  
	  // JTextField 전화번호 설정
	  txtPhone = new JTextField();
	  txtPhone.setFont(txtFont);
	  txtPhone.setBounds(200, 150, txtWidth, txtHeight);
	  frame.getContentPane().add(txtPhone);
	  
	  // JTextField 이메일 설정
	  txtEmail = new JTextField();
	  txtEmail.setFont(txtFont);
	  txtEmail.setBounds(200, 210, txtWidth, txtHeight);
	  frame.getContentPane().add(txtEmail);
	  
	  // JTextField 인덱스 설정
	  txtIndex = new JTextField();
		txtIndex.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtIndex.setText("");
			}
		});
	  txtIndex.setText("번호입력");
	  txtIndex.setHorizontalAlignment(JTextField.CENTER);
	  txtIndex.setFont(new Font("굴림", Font.PLAIN, 24));
	  txtIndex.setBounds(150, 270, 120, 50);
	  frame.getContentPane().add(txtIndex);
	  txtIndex.setColumns(5);
      
	  // JButton 변수 선언, 인스턴스 생성 및 font, bounds
      // addAciontListener 및 메소드 오버라이드 설정. 5개
	  
	  // JButton 기본 폰트 설정
	  Font btnFont = new Font("굴림", Font.PLAIN, 24);

	  // JButton 등록 설정
	  JButton btnInsert = new JButton("등록");
	  btnInsert.addActionListener(new ActionListener() {// 등록 버튼 클릭시 액션 설정
		
		@Override
		public void actionPerformed(ActionEvent e) { // 등록 메소드와 연결
			// TODO Auto-generated method stub
			insertContact();
		}
	});
	  btnInsert.setFont(btnFont);
	  btnInsert.setBounds(20, 270, 120, 50);
	  frame.getContentPane().add(btnInsert); // 프레임에 등록 버튼 추가
	  
	  // JButton 검색 설정
	  JButton btnSelect = new JButton("검색");
	  btnSelect.addActionListener(new ActionListener() {// 검색 버튼 클릭시 액션 설정
		
		@Override
		public void actionPerformed(ActionEvent e) { // 검색 메소드와 연결
			// TODO Auto-generated method stub
			selectContact();
		}
	});
	  btnSelect.setFont(btnFont);
	  btnSelect.setBounds(280, 270, 120, 50);
	  frame.getContentPane().add(btnSelect); // 프레임에 검색 버튼 추가
	  
	  // JButton 전체검색 설정
	  JButton btnSelectAll = new JButton("전체검색");
	  btnSelectAll.addActionListener(new ActionListener() {// 전체검색 버튼 클릭시 액션 설정
		
		@Override
		public void actionPerformed(ActionEvent e) { // 전체검색 메소드와 연결
			// TODO Auto-generated method stub
			selectAllContact();
			selectAllContactTable();
		}
	});
	  btnSelectAll.setFont(btnFont);
	  btnSelectAll.setBounds(280, 330, 190, 50);
	  frame.getContentPane().add(btnSelectAll); // 프레임에 전체검색 버튼 추가
	  
	  // JButton 수정 설정
	  JButton btnUpdate = new JButton("수정");
	  btnUpdate.addActionListener(new ActionListener() {// 수정 버튼 클릭시 액션 설정
		
		@Override
		public void actionPerformed(ActionEvent e) { // 수정 메소드와 연결
			// TODO Auto-generated method stub
			updateContact();
		}
	});
	  btnUpdate.setFont(btnFont);
	  btnUpdate.setBounds(20, 330, 120, 50);
	  frame.getContentPane().add(btnUpdate); // 프레임에 수정 버튼 추가
	  
	  // JButton 삭제 설정
	  JButton btnDelete = new JButton("삭제");
	  btnDelete.addActionListener(new ActionListener() {// 삭제 버튼 클릭시 액션 설정
		
		@Override
		public void actionPerformed(ActionEvent e) { // 삭제 메소드와 연결
			// TODO Auto-generated method stub
			deleteContact();
		}
	});
	  btnDelete.setFont(btnFont);
	  btnDelete.setBounds(150, 330, 120, 50);
	  frame.getContentPane().add(btnDelete); // 프레임에 삭제 버튼 추가
	  
	  
      // JScrollPane 변수 선언, 인스턴스 생성 및 설정. 3개
      JScrollPane scrollPane1 = new JScrollPane();
      scrollPane1.setBounds(12, 393, 480, 95);
      frame.getContentPane().add(scrollPane1);
      
      txtAreaInfo = new JTextArea();
      // TODO: txtAreaInfo font 설정 추가
      txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
      scrollPane1.setViewportView(txtAreaInfo);
      
      JScrollPane scrollPane2 = new JScrollPane();
      scrollPane2.setBounds(12, 498, 480, 95);
      frame.getContentPane().add(scrollPane2);
      
      txtAreaLog = new JTextArea();
      // TODO : txtAreaLog font 설정 추가
      txtAreaLog.setFont(new Font("굴림", Font.PLAIN, 16));
      scrollPane2.setViewportView(txtAreaLog);
      
      
      JScrollPane scrollPane3 = new JScrollPane();
      scrollPane3.setBounds(504, 271, 254, 322);
      frame.getContentPane().add(scrollPane3);
      
      // 테이블 설정
      tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
      };
      table = new JTable(tableModel);
      table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // table 누르면 창 뜨게 하는거 (결과 값 만뜸)
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}		
      });
      table.setFont(new Font("굴림", Font.PLAIN, 12));
      scrollPane3.setViewportView(table);
      table.getTableHeader().setReorderingAllowed(false); // 테이블 헤더 고정
   }

   // 등록 메소드 설정
   private void insertContact() {
		// 이름 입력
		String name = txtName.getText(); 
		// 전화번호 입력
		String phone = txtPhone.getText();
		// 이메일 입력
		String email = txtEmail.getText();
		if(name.trim().length() == 0 || phone.trim().length() == 0 || email.trim().length() == 0) {
			txtAreaLog.setText("이름, 전화번호, 이메일을 전부 입력해주세요.");
		}else {
		ContactVO vo = new ContactVO(0, name, phone, email);
		int result = dao.insert(vo);
		if(result == 1) {
			txtAreaLog.setText("등록된 연락처 개수 : " + dao.select().size() + "\n" + "연락처 등록 완료");
			selectAllContactTable();
		}
		}
   }
   
   // 검색 메소드 설정
   private void selectContact() {
	   try {
	   int contactId = Integer.parseInt(txtIndex.getText());
	   int checkId = ((ContactDAOImple) dao).checkId(contactId);
	   if (contactId >= 0 && checkId == 1) {
		   ContactVO vo = dao.select(contactId);
		   txtAreaLog.setText(contactId + "번 인덱스 연락처 정보");
		   txtAreaInfo.setText(vo.toString());
	   }else {
		   txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
	   }
	   }catch(NumberFormatException e){
		// TODO: handle exception
		   txtAreaLog.setText("[에러] 숫자를 입력하세요");
   }
   }
   
   // 전체검색 메소드 설정
   private void selectAllContact() {
	   ArrayList<ContactVO> list = dao.select();
	   StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < dao.select().size(); i++) {
			buffer.append("연락처[" + i + "] \n" + list.get(i) + "\n");
			}
		txtAreaInfo.setText(buffer.toString());
		selectAllContactTable();
   }
   
   // 수정 메소드 설정
   private void updateContact() {
	   try {
	   int contactId = Integer.parseInt(txtIndex.getText());
	   int checkId = ((ContactDAOImple) dao).checkId(contactId);
	   if (contactId >= 0 && checkId == 1) {
			// 이름 입력
			String name = txtName.getText(); 
			// 전화번호 입력
			String phone = txtPhone.getText();
			// 이메일 입력
			String email = txtEmail.getText();
			if(name.trim().length() == 0 || phone.trim().length() == 0 || email.trim().length() == 0) {
				txtAreaLog.setText("이름, 전화번호, 이메일을 전부 입력해주세요.");
				return;
			}else {
			ContactVO vo = new ContactVO(contactId, name, phone, email);
			int result = dao.update(contactId, vo);
			if(result == 1) {
				txtAreaLog.setText("연락처 수정 완료!");
				selectAllContactTable();
			}
			}
	   }
		else {
			txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
			}
	   }catch (NumberFormatException e) {
		// TODO: handle exception
		   txtAreaLog.setText("[에러] 숫자를 입력하세요");
	}
   }
   
   // 삭제 메소드 설정
   private void deleteContact() {
	   try {
	   int contactId = Integer.parseInt(txtIndex.getText());
	   int CheckId = ((ContactDAOImple) dao).checkId(contactId);
	   if (contactId >= 0 && CheckId == 1) {
		   dao.delete(contactId);
			txtAreaLog.setText("연락처 삭제 완료!");
			selectAllContactTable();
		} else {
			txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
		}

	   }catch (NumberFormatException e) {
		// TODO: handle exception
		   txtAreaLog.setText("[에러] 숫자를 입력하세요");
	}
   }
   
   // 저장된 연락처 배열을 테이블에 표시
   private void selectAllContactTable() {
		ArrayList<ContactVO> list = dao.select();
		tableModel.setRowCount(0);
		
   for(int i = 0; i < list.size(); i++) {
		records[0] = list.get(i).getContactId();
		records[1] = list.get(i).getName();
		records[2] = list.get(i).getPhone();
		records[3] = list.get(i).getEmail();
		tableModel.addRow(records);
		}
   }
   
   


}



