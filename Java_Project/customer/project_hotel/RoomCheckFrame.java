package project_hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoomCheckFrame extends JFrame {
    private JTextArea textArea;
    private JPanel buttonPanel;
    private RoomDAO roomDAO;
    
    // 객실 정보 확인 GUI
    public RoomCheckFrame() {
    	super("객실 확인");
        roomDAO = new RoomDAOImple();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        textArea.setText("\n객실 구성 : 각 층별로 6개씩 구성 \n홀수 객실은 싱글룸 짝수 객실은 더블룸\n2층은 스탠다드 3층은 슈페리어, 4층은 디럭스\n객실 종류 : 싱글룸 / 더블룸 \n객실 등급: 스탠다드 / 슈페리어 / 디럭스 \n객실 요금 : 스탠다드 싱글(80,000원) / 스탠다드 더블(100,000원)\n객실 등급 업그레이드 시(슈페리어 +20000원, 디럭스 +40000원)\n\n각 객실에 대한 자세한 정보는 아래 객실 번호를 클릭해 확인해주세요.");
        textArea.setFont(new Font("굴림", Font.PLAIN, 16));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 3, 10, 10)); 

        loadRoomButtons();

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    	// 각 객실들의 버튼
    private void loadRoomButtons() {
        ArrayList<RoomVO> rooms = roomDAO.loadRooms();
        for (RoomVO room : rooms) {
            JButton roomButton = new JButton("객실 " + room.getRoomId());
            roomButton.setFont(new Font("굴림", Font.PLAIN, 14));
            
            roomButton.addActionListener(new RoomButtonListener(room));
            buttonPanel.add(roomButton);
        }
    }

    private class RoomButtonListener implements ActionListener {
        private RoomVO room;

        public RoomButtonListener(RoomVO room) {
            this.room = room;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new RoomDetailsDialog(RoomCheckFrame.this, room);
        }
    }
    
    // 각 객실 버튼 클릭시 나오는 정보
    private class RoomDetailsDialog extends JDialog {
        public RoomDetailsDialog(JFrame parent, RoomVO room) {
            super(parent, "객실 상세 정보", true);
            setLayout(new BorderLayout());
            setSize(400, 300);  // 사이즈 변경
            setLocationRelativeTo(parent);

            // 객실 정보 표시
            JTextArea detailsArea = new JTextArea();
            detailsArea.setEditable(false);
            detailsArea.setFont(new Font("굴림", Font.PLAIN, 14));
            detailsArea.setText("객실 번호: " + room.getRoomId() + "\n" +
                                "객실 타입: " + room.getRoomType() + "\n" +
                                "객실 가격: " + room.getRoomPrice() + "원\n" +
                                "예약 상태: " + room.getRoomAvailability());
            add(new JScrollPane(detailsArea), BorderLayout.NORTH);

            // 해당 객실의 리뷰 불러오기
            RoomDAO roomDAO = new RoomDAOImple();
            ArrayList<ReviewVO> reviews = roomDAO.loadReviewsByRoomId(room.getRoomId());

            // 리뷰 출력
            JTextArea reviewArea = new JTextArea();
            reviewArea.setEditable(false);
            reviewArea.setFont(new Font("굴림", Font.PLAIN, 14));

            // 리뷰가 존재하는 경우
            if (reviews.isEmpty()) {
                reviewArea.setText("이 객실에 대한 리뷰가 없습니다.");
            } else {
                StringBuilder reviewsText = new StringBuilder();
                for (ReviewVO review : reviews) {
                    String stars = generateStars(review.getReviewRating());
                    reviewsText.append("\n별점: ").append(stars)
                    		   .append("\n유저: ").append(review.getCustomerId())
                               .append("\n리뷰: ").append(review.getReviewDetail())
                               .append("\n\n");
                }
                reviewArea.setText(reviewsText.toString());
            }

            // 리뷰 표시 영역 추가
            JScrollPane reviewScrollPane = new JScrollPane(reviewArea);
            add(reviewScrollPane, BorderLayout.CENTER);

            // 닫기 버튼
            JButton closeButton = new JButton("닫기");
            closeButton.addActionListener(e -> dispose());
            add(closeButton, BorderLayout.SOUTH);

            setVisible(true);
        }

        // 별점 숫자를 *로 변환하는 기능
        private String generateStars(int rating) {
            StringBuilder stars = new StringBuilder();
            for (int i = 0; i < rating; i++) {
                stars.append("*");
            }
            return stars.toString();
        }
    }
}