package project_hotel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class HotelMain {
   private JFrame frame;
   private JTextField Id;
   public static CustomerDAO dao; 
   public static ReserveDAO rdao;
   public static ReviewDAO redao;

   public static void main(String[] args) {
	   dao = CustomerDAOImple.getInstance();
	   rdao = ReserveDAOImple.getInstance();
	   redao = ReviewDAOImple.getInstance();
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               HotelMain window = new HotelMain();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public HotelMain() {
      
	   initialize(); // 시작 화면
      }
   
   //시작 화면 구축
   private void initialize() { 
      frame = new JFrame("호텔 예약 관리 프로그램");
      frame.setBounds (450, 50, 800, 800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      frame.getContentPane().setBackground(Color.white);
      JLabel lblTitle = new JLabel("호텔 예약 관리 프로그램");
      lblTitle.setFont(new Font("굴림", Font.PLAIN, 42));
      JLabel Label = new JLabel("객실을 예약하실려면 먼저 회원가입 후 로그인해주세요");
      Label.setFont(new Font("굴림", Font.PLAIN, 22));
      lblTitle.setBounds(10, 10, 740, 70);
      JButton Login = new JButton("로그인");
      Login.setFont(new Font("굴림", Font.PLAIN, 16));
      JButton CreateAc = new JButton("회원 가입");
      CreateAc.setFont(new Font("굴림", Font.PLAIN, 16));
      JButton CustomerIndex = new JButton("전체 회원 정보 확인");
      CustomerIndex.setFont(new Font("굴림", Font.PLAIN, 16));
      JButton Room = new JButton("호텔 객실 정보 확인");
      Room.setFont(new Font("굴림", Font.PLAIN, 16));
      JLabel introduce = new JLabel("<html><body style='text-align:center;'>   ===================== 호텔 소개 ===================<br>호텔명 : 프로젝트 호텔<br>호텔 위치 :<br>호텔 전화번호 :<br>카운터 영업시간 :<br>객실 구성 : 각 층별로 6개씩 구성 <br>홀수 객실은 싱글룸 짝수 객실은 더블룸<br>2층은 스탠다드 3층은 슈페리어, 4층은 디럭스<br>객실 종류 : 싱글룸 / 더블룸 <br>객실 등급: 스탠다드 / 슈페리어 / 디럭스<br>객실 최대 수용 인원 : 싱글(2인) / 더블(4인)<br>객실 요금 : 스탠다드 싱글(80,000원) / 스탠다드 더블(100,000원)<br>객실 등급 업그레이드 시(슈페리어 +20000원, 디럭스 +40000원)</body></html>");
      introduce.setFont(new Font("굴림", Font.PLAIN, 14));
      // 프레임 세부 설정 및 기능 구현
      frame.getContentPane().add(lblTitle);
      
      // 아이디 입력 칸 구현
      Id = new JTextField(20);
      Id.setBounds(200, 270, 200, 45);
      frame.getContentPane().add(Id);
      Id.setColumns(20);
      
      // 패스워드 입력 칸 구현
      JPasswordField Password = new JPasswordField(20);
      Password.setBounds(200, 320, 200, 45);
      frame.getContentPane().add(Password);
      Password.setColumns(20);
      
      // 설명 구현
      Label.setBounds(130, 175, 550, 80);
      frame.getContentPane().add(Label);
      
      introduce.setBounds(180, 205, 750, 680);
      frame.getContentPane().add(introduce);
      // 로그인 버튼 구현
      Login.setBounds(420, 275, 150, 80);
      frame.getContentPane().add(Login);
      // 회원가입 버튼 구현
      CreateAc.setBounds(300, 380, 200, 45);
      frame.getContentPane().add(CreateAc);

      // 방 정보 버튼 구현
      Room.setBounds(300, 120, 200, 45);
      frame.getContentPane().add(Room);
      // 전체 회원 정보 버튼 구현
      CustomerIndex.setBounds(300, 680, 200, 45);
      frame.getContentPane().add(CustomerIndex);
      
      // 방 정보 버튼의 기능 구현
      Room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomCheckFrame room = new RoomCheckFrame();
				room.setVisible(true);
			}
		});
      
      //회원가입 버튼의 기능 구현
		CreateAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerNewFrame createAcFrame = new CustomerNewFrame();
				createAcFrame.setVisible(true);
			}
		});
		
		//회원 정보 버튼의 기능 구현
		CustomerIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerIndex cindex = new CustomerIndex();
				cindex.setVisible(true);
			}
		});
		
		// 로그인 버튼 기능 구현
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   	ArrayList<CustomerVO> list = dao.select();
			   	boolean b = false;
		    	int i = 0;
			   	String id = Id.getText();
		    	String pw = String.valueOf(Password.getPassword()); // 비밀번호 안보이게
		    	if(id.equals("") || pw.equals("")) {
		    		JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		    	}else if(id != null && pw != null) {
		    		while(list.size()> i) {
		    			String checkid = list.get(i).getCustomerID();
		    			String checkpw = list.get(i).getCustomerPW();
		    			if(id.equals(checkid) && pw.equals(checkpw)) { // CUSTOMERS 테이블에 등록된 아이디 및 비번과 같은지 확인하기
		    				b = true;
		    				break;
		    			}else {
		    				i++;
		    		}
					}
		    		if(b == true) {
		    			JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
		    			openLoginMenu(id);
		    		}else {
		    			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		    		}
			}
			}
			});
   }
   			// 로그인 후의 화면 구성(로그인 시 사용한 customerId 값을 가지고있음)
		  private void openLoginMenu(String customerId) {
			  CustomerVO vo = dao.select(customerId);
			  
			  // 새로운 JFrame 생성
		        JFrame loginFrame = new JFrame(vo.getCustomerName() + " 님의 화면");
		        // 로그인 화면 프레임 생성
		        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        loginFrame.setBounds(550, 150, 800, 800);
		        loginFrame.getContentPane().setLayout(null);
		        loginFrame.getContentPane().setBackground(Color.white);
		        
		        JLabel welcomeLabel = new JLabel("환영합니다, " + vo.getCustomerName() + " 회원님!");
		        welcomeLabel.setFont(new Font("굴림", Font.PLAIN, 34));
		        welcomeLabel.setBounds(20, 20, 600, 50);
		        loginFrame.add(welcomeLabel);
		        
		        JLabel roomExplain = new JLabel("<html><body style='text-align:center;'> 객실은 각 층별로 6개의 객실이 준비되어있습니다. <br>홀수 객실은 싱글룸 짝수 객실은 더블룸이니 예약 전 확인해주세요.<br>2층은 스탠다드 3층은 슈페리어, 4층은 디럭스입니다.<br>객실 요금은 1박 기준 스탠다드 싱글(80,000원) / 스탠다드 더블(100,000원) 이며<br>스탠다드 (기본 객실 요금), 슈페리어 (+ 20000원), 디럭스 (+ 40000원) 추가됩니다.<br> 예약 및 관리를 원하시면 위 버튼을 눌러 이용해주세요.</body></html>");
		        roomExplain.setFont(new Font("굴림", Font.PLAIN, 16));
		        roomExplain.setBounds(140, 420, 500, 250);
		        loginFrame.getContentPane().add(roomExplain);
		        
		        ImageIcon img1 = new ImageIcon("img/OIP.png");
		        JLabel rsimg = new JLabel(img1);
		        if (img1.getIconWidth() == -1) {
		            System.out.println("이미지를 로드할 수 없습니다.");
		        }
		        rsimg.setBounds(120, 85, 550, 280);
		        loginFrame.add(rsimg);
		        
		        Font buttonFont = new Font("굴림", Font.PLAIN, 16);
		        
		        // 객실 예약 버튼
		        JButton reserveButton = new JButton("객실 확인 및 예약");
		        reserveButton.setBounds(120, 390, 210, 45);
		        reserveButton.setFont(buttonFont);
		        loginFrame.getContentPane().add(reserveButton);
		        reserveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new RoomCheckBooking(customerId);
					}});
		        
		        // 로그인한 손님의 예약 확인 버튼
		        JButton reserveCheckButton = new JButton("예약 확인 및 취소");
		        reserveCheckButton.setBounds(460,390, 210, 45);
		        reserveCheckButton.setFont(buttonFont);
		        loginFrame.getContentPane().add(reserveCheckButton);
		        reserveCheckButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ReserveCheck(customerId);
					}});
		        
		        JButton reviewButton = new JButton("리뷰 등록");
		        reviewButton.setBounds(330, 700, 110, 45);
		        reviewButton.setFont(buttonFont);
		        loginFrame.getContentPane().add(reviewButton);
		        reviewButton.addActionListener(e -> {
					Review review = new Review(customerId);
					review.setVisible(true);
		        });
		        
		        // 회원 정보 변경 버튼
		        JButton updateInfoButton = new JButton("정보 변경");
		        updateInfoButton.setBounds(530, 20, 110, 45);
		        updateInfoButton.setFont(buttonFont);
		        loginFrame.getContentPane().add(updateInfoButton);
		        updateInfoButton.addActionListener(e -> {
					CustomerUpdateFrame updateAcFrame = new CustomerUpdateFrame(customerId);
					updateAcFrame.setVisible(true);
		        });
		        
		     // 회원 탈퇴
		        JButton deleteInfoButton = new JButton("회원 탈퇴");
		        deleteInfoButton.setBounds(650, 700, 110, 45);
		        deleteInfoButton.setFont(buttonFont);
		        loginFrame.getContentPane().add(deleteInfoButton);
		        deleteInfoButton.addActionListener(e -> {
		            // 확인 다이얼로그 표시
		            int confirm = JOptionPane.showConfirmDialog(
		                loginFrame,
		                "정말로 회원 정보를 삭제하시겠습니까?",
		                "회원 "
		                + "탈퇴 확인",
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.WARNING_MESSAGE
		            );

		            // 확인을 클릭한 경우
		            if (confirm == JOptionPane.YES_OPTION) {
		                rdao.delete(customerId);
		                redao.deleteReview(customerId);
		                JOptionPane.showMessageDialog(null, "회원 정보가 삭제되었습니다");
		                dao.delete(customerId);
		                loginFrame.dispose();
		            }
		        });
		        
		        // 로그아웃 버튼
		        JButton logoutButton = new JButton("로그아웃");
		        logoutButton.setBounds(650, 20, 110, 45);
		        logoutButton.setFont(buttonFont);
		        loginFrame.getContentPane().add(logoutButton);
		        logoutButton.addActionListener(e -> {
		            loginFrame.dispose();
		        });
		        loginFrame.add(logoutButton);

		        loginFrame.setVisible(true);
		        
			  
   }
		  
}