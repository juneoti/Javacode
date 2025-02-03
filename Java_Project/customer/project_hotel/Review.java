package project_hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Review extends JDialog {
    private JTextArea reviewTextArea;
    private JComboBox<String> ratingComboBox;
    public static ReviewDAO redao;
    private JTextField textfield;
    
    public Review(String customerId) {
        redao = ReviewDAOImple.getInstance();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());
        
        textfield = new JTextField();
		textfield.setFont(new Font("굴림", Font.PLAIN, 16));

        // 별점 선택
        String[] ratings = {"1", "2", "3", "4", "5"};
        ratingComboBox = new JComboBox<>(ratings);
  
        // 리뷰 입력
        reviewTextArea = new JTextArea(5, 30);
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setWrapStyleWord(true);
        JScrollPane reviewScrollPane = new JScrollPane(reviewTextArea);
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        
        //GridBagLayout 사용해 리뷰의 GUI를 좀 더 디테일하게 설정
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; 
        inputPanel.add(new JLabel("별점 선택:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ratingComboBox.setPreferredSize(new Dimension(100, 25)); 
        inputPanel.add(ratingComboBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(new JLabel("리뷰:"), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH; 
        reviewTextArea.setPreferredSize(new Dimension(300, 100));
        inputPanel.add(reviewScrollPane, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; 
        gbc.anchor = GridBagConstraints.WEST; 
        inputPanel.add(new JLabel("객실:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        textfield.setPreferredSize(new Dimension(100, 25)); 
        inputPanel.add(textfield, gbc);
        
        add(inputPanel, BorderLayout.CENTER);

        // 저장 버튼
        JButton saveButton = new JButton("리뷰 저장");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield.getText() == null || textfield.getText().trim().isEmpty()) {
                	JOptionPane.showMessageDialog(Review.this, "리뷰하실 객실을 입력해주세요.");
                    return; // 리뷰 저장을 중단
                }
                try {
                	int rating = Integer.parseInt((String) ratingComboBox.getSelectedItem());
                	String review = reviewTextArea.getText();
                    int roomId = Integer.parseInt(textfield.getText());  // String을 int로 변환
                // 리뷰를 데이터베이스에 저장
                    if (!isValidRoomId(roomId)) {
                        JOptionPane.showMessageDialog(Review.this, "없는 객실입니다.");
                        return; 
                    }
            	ReviewVO revo = new ReviewVO(0, rating, review, customerId, roomId);
    			redao.addReview(revo);

                JOptionPane.showMessageDialog(Review.this, "리뷰가 저장되었습니다!");
                dispose();
                    
                } catch (NumberFormatException e1) {
                	// 만약 입력이 숫자가 아니면 예외 처리
                	JOptionPane.showMessageDialog(Review.this, "리뷰하실 객실을 제대로 입력해주세요.");
                	return; 
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    //객실 번호가 올바른지 확인
    private boolean isValidRoomId(int roomId) {
        return (roomId >= 201 && roomId <= 206) ||
               (roomId >= 301 && roomId <= 306) ||
               (roomId >= 401 && roomId <= 406);
    }

}
