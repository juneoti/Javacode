package personal_Practice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RatingReviewApp {

    private JFrame frame;
    private JTable table;
    private JTextArea reviewTextArea;
    private JComboBox<String> ratingComboBox;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RatingReviewApp().initialize());
    }

    private void initialize() {
        frame = new JFrame("별점 및 리뷰 기능");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // 테이블 모델 설정
        String[] columnNames = {"별점", "리뷰"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // 리뷰 입력 영역
        reviewTextArea = new JTextArea(5, 30);
        reviewTextArea.setWrapStyleWord(true);
        reviewTextArea.setLineWrap(true);
        JScrollPane reviewScrollPane = new JScrollPane(reviewTextArea);

        // 별점 선택 콤보박스
        String[] ratings = {"1", "2", "3", "4", "5"};
        ratingComboBox = new JComboBox<>(ratings);

        // 버튼: 리뷰 추가
        JButton addButton = new JButton("리뷰 추가");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rating = (String) ratingComboBox.getSelectedItem();
                String review = reviewTextArea.getText();
                
                if (review.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "리뷰를 입력해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 테이블에 추가
                tableModel.addRow(new Object[]{rating, review});
                
                // 리뷰 입력란 초기화
                reviewTextArea.setText("");
            }
        });

        // 패널 설정
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("별점:"));
        inputPanel.add(ratingComboBox);
        inputPanel.add(new JLabel("리뷰:"));
        inputPanel.add(reviewScrollPane);
        inputPanel.add(addButton);

        // 윈도우 구성
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
}

