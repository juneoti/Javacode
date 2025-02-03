package edu.java.contact06;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField textName;
	private JTextField textIndex;
	private JTextField textPhone;
	private JTextField textEmail;
	JTextArea textArea;
	JTextArea textArea_1;

	private ContactDAO dao;

	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private JTable table;
	private String[] colNames = { "ID", "이름", "전화번호", "이메일" };
	// 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length];
	// 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel model; // 테이블 형태를 만들 모델 변수

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dao = ContactDAOImple.getInstance();
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("연락처 프로그램");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 599, 50);
		frame.getContentPane().add(lblTitle);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.BOLD, 30));
		lblName.setBounds(33, 69, 128, 50);
		frame.getContentPane().add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.BOLD, 30));
		lblPhone.setBounds(33, 127, 128, 50);
		frame.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.BOLD, 30));
		lblEmail.setBounds(33, 187, 128, 50);
		frame.getContentPane().add(lblEmail);

		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 20));
		textName.setBounds(173, 69, 206, 50);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(173, 127, 206, 50);
		frame.getContentPane().add(textPhone);

		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(173, 187, 206, 50);
		frame.getContentPane().add(textEmail);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnInsert.setBounds(33, 247, 97, 40);
		frame.getContentPane().add(btnInsert);

		textIndex = new JTextField();
		textIndex.setBounds(142, 247, 97, 40);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(33, 297, 97, 40);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(141, 297, 97, 40);
		frame.getContentPane().add(btnDelete);

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
				selectAllContactTable();
			}
		});
		btnAllSearch.setBounds(245, 297, 97, 40);
		frame.getContentPane().add(btnAllSearch);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectById();
			}
		});
		btnSearch.setBounds(245, 247, 97, 40);
		frame.getContentPane().add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 350, 309, 69);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 429, 309, 69);
		frame.getContentPane().add(scrollPane_1);

		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(354, 247, 257, 251);
		frame.getContentPane().add(scrollPane_2);

		// 테이블 초기화

		model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}

		};

		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane_2.setViewportView(table);
		selectAllContactTable();

	}

	private void insert() {
		textArea.setText("");
		textArea_1.setText("");

		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();

		if (name.equals("") || phone.equals("") || email.equals("")) {
			textArea_1.setText("모두 입력 해주세요.");
		} else {
			ContactVO vo = new ContactVO();
			vo.setName(name);
			vo.setPhone(phone);
			vo.setEmail(email);
			int result = dao.insert(vo);
			if (result == 1) {
				textArea_1.setText("연락처가 등록 되었습니다.");
			}
		}
	}

	private void update() {
		textArea.setText("");
		textArea_1.setText("");

		if (!textIndex.getText().equals("")) {
			int contactId = Integer.parseInt(textIndex.getText());
			int result = ((ContactDAOImple) dao).checkId(contactId);
			if (result == 1) {
				String name = textName.getText();
				String phone = textPhone.getText();
				String email = textEmail.getText();
				if (name.equals("") || phone.equals("") || email.equals("")) {
					textArea_1.setText("모두 입력 해주세요.");
				} else {
					ContactVO vo = new ContactVO(contactId, name, phone, email);
					result = dao.update(contactId, vo);
					if (result == 1) {
						textArea_1.setText(contactId + "번 ID의 연락처가 수정 되었습니다.");

					}
				}
			} else {
				System.out.println("ID를 확인 해주세요.");
			}
		} else {
			textArea_1.setText("ID를 확인 해주세요.");
		}

	}
	private void selectAll() {
		textArea.setText("");
		textArea_1.setText("");
		ArrayList<ContactVO> list = dao.select();
		for (int i = 0; i < list.size(); i++) {
			textArea.append(list.get(i).toString() + "\n");
		}
	}
	private void selectById() {
		textArea.setText("");
		textArea_1.setText("");
		if (!textIndex.getText().equals("")) {
			int contactId = Integer.parseInt(textIndex.getText());
			int result = ((ContactDAOImple) dao).checkId(contactId);
			if (result == 1) {
				ContactVO vo = dao.select(contactId);
				textArea.setText(vo.toString());
			} else {
				textArea_1.setText("ID를 확인 해주세요.");
			}

		} else {
			textArea_1.setText("ID를 확인 해주세요.");
		}
	}
	private void delete() {
		textArea.setText("");
		textArea_1.setText("");
		if (!textIndex.getText().equals("")) {
			int contactId = Integer.parseInt(textIndex.getText());
			int result = ((ContactDAOImple) dao).checkId(contactId);
			if (result == 1) {
				result = dao.delete(contactId);
				if (result == 1) {
					textArea_1.setText(contactId + "번 ID의 연락처가 삭제 되었습니다.");

				}
			} else {
				textArea_1.setText("ID를 확인 해주세요.");
			}
		} else {
			textArea_1.setText("ID를 확인 해주세요.");
		}
	}

	private void selectAllContactTable() {

		ArrayList<ContactVO> list = dao.select();
		model.setNumRows(0);

		for (int i = 0; i < list.size(); i++) {
			records[0] = list.get(i).getContactId();
			records[1] = list.get(i).getName();
			records[2] = list.get(i).getPhone();
			records[3] = list.get(i).getEmail();
			model.addRow(records);
		}

	}
}