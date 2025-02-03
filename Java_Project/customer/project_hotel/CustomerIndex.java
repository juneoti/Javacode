package project_hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerIndex extends JFrame {
    private JTextArea txtAreaInfo;
    private JFrame frame; 
    private JTextField select;
    private String[] colNames = {"아이디", "이름", "전화번호", "이메일", "생년월일", "성별"}; // 테이블의 컬럼명
    private Object[] records = new Object[colNames.length]; 
    private JTable table;
    private DefaultTableModel tableModel;
    public static CustomerDAO dao; 
    
    public CustomerIndex() {
    	dao = CustomerDAOImple.getInstance();
    	setTitle("호텔 회원 정보");
    	frame = this;
	      frame.setBounds(100, 100, 786, 662);
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      
	      // JLabel 변수 선언, 인스턴스 생성 및 font, bounds 설정. 4개
	      
	      // JLabel에서 사용할 폰트 및 bounds의 width, height 값 설정
			
		  // JLabel 타이틀 설정
	      JLabel lblTitle = new JLabel("전체 회원 정보 열람");
	      lblTitle.setFont(new Font("굴림", Font.PLAIN, 42));
	      lblTitle.setBounds(10, 10, 740, 70);
	      frame.getContentPane().add(lblTitle);
	      
	      JLabel lblName = new JLabel("아이디");
	      lblName.setFont(new Font("굴림", Font.PLAIN, 16));
		  lblName.setBounds(420, 20, 200, 50);
		  frame.getContentPane().add(lblName);
		  
	      JLabel lblselect = new JLabel("상세 검색 결과");
	      lblselect.setFont(new Font("굴림", Font.PLAIN, 16));
		  lblselect.setBounds(320, 400, 200, 50);
		  frame.getContentPane().add(lblselect);
		  
		  // 상세 검색에 쓸 입력값 구현
		  select = new JTextField();
		  select.setFont(new Font("굴림", Font.PLAIN, 16));
		  select.setBounds(475, 20, 150, 50);
		  frame.getContentPane().add(select);
		  
		  // 상세 검색 버튼 설정
		  JButton btnSelect = new JButton("검색");
		  btnSelect.addActionListener(new ActionListener() {// 검색 버튼 클릭시 액션 설정
			
			@Override
			public void actionPerformed(ActionEvent e) { // 검색 메소드와 연결
				// TODO Auto-generated method stub
				selectCustomer();
			}
		});
		  btnSelect.setFont(new Font("굴림", Font.PLAIN, 16));
		  btnSelect.setBounds(630, 20, 120, 50);
		  frame.getContentPane().add(btnSelect); // 프레임에 검색 버튼 추가
        
        // 전체 회원 데이터 테이블 모델
        tableModel = new DefaultTableModel(colNames, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // 모든 셀을 편집 불가능하게 설정
        }
        };
        table = new JTable(tableModel);
        
	      JScrollPane scrollPane = new JScrollPane(txtAreaInfo);
	      scrollPane.setBounds(7, 453, 754, 95);
	      frame.getContentPane().add(scrollPane);
	      
	      // 상세 검색시 결과값 출력란
	      txtAreaInfo = new JTextArea();
	      txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
	      scrollPane.setViewportView(txtAreaInfo);
	      
	      // 테이블 스크롤 팬 구현 및 프레임에 출력
	      JScrollPane scrollPane1 = new JScrollPane(table);
	      scrollPane1.setBounds(7, 80, 754, 322);
	      frame.getContentPane().add(scrollPane1);
        // Fetch data from the database
        selectAllContactTable();
    }

    // 전체 검색 테이블 메소드
    private void selectAllContactTable() {
 		ArrayList<CustomerVO> list = dao.select();
 		tableModel.setRowCount(0);
 		
    for(int i = 0; i < list.size(); i++) {
 		records[0] = list.get(i).getCustomerID();
 		records[1] = list.get(i).getCustomerName();
 		records[2] = list.get(i).getCustomerPhone();
 		records[3] = list.get(i).getCustomerEmail();
 		records[4] = list.get(i).getCustomerBirth();
 		records[5] = list.get(i).getCustomerGender();
 		tableModel.addRow(records);
 		}
    }
    
    // 회원 상세 검색 메소드 
    private void selectCustomer() {
    	ArrayList<CustomerVO> list = dao.select();
    	String id = select.getText();
    	CustomerVO vo = dao.select(id);
    	int i = 0;
        while(list.size() > i) {
     		records[0] = list.get(i).getCustomerID();
     		if(records[0].equals(id)) {
     			txtAreaInfo.setText(vo.toString());
     			break;
     		}else
     		i++;
        }
}
    /*
    private void fetchDataFromDatabase() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Change to your database URL
        String username = "scott"; // Change to your database username
        String password = "tiger"; // Change to your database password

        String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_PHONE, CUSTOMER_EMAIL, CUSTOMER_BIRTH, CUSTOMER_GENDER FROM CUSTOMERS";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            // Clear the existing rows in the table model
            tableModel.setRowCount(0);
            
            // Populate the table model with data from the ResultSet
            while (rs.next()) {
                Object[] row = {
                    rs.getString("CUSTOMER_ID"),
                    rs.getString("CUSTOMER_NAME"),
                    rs.getString("CUSTOMER_PHONE"),
                    rs.getString("CUSTOMER_EMAIL"),
                    rs.getString("CUSTOMER_BIRTH"),
                    rs.getString("CUSTOMER_GENDER")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
*/

}
