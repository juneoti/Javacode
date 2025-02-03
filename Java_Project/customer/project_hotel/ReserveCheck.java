package project_hotel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReserveCheck extends JFrame {
    private JTextArea textArea;
    private JTextField txtReserveId; // 예약 ID 입력 필드
    private JButton btnCancel; // 예약 취소 버튼
    public static ReserveDAO rdao;
    
    // 예약 확인 메소드
    public ReserveCheck(String customerId) {
        rdao = ReserveDAOImple.getInstance();
        setTitle("예약 확인");
        setSize(400, 400); // 크기 조정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // FlowLayout 사용
        add(panel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // 예약 ID 입력 필드와 버튼 추가
        txtReserveId = new JTextField(10);
        panel.add(new JLabel("예약 ID:")); // 레이블 추가
        panel.add(txtReserveId);
        txtReserveId.setFont(new Font("굴림", Font.PLAIN, 14));
        
        btnCancel = new JButton("예약 취소");
        panel.add(btnCancel);
        btnCancel.setFont(new Font("굴림", Font.PLAIN, 14));

        // 예약 취소 버튼 클릭 이벤트 처리
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelReservation(customerId);
            }
        });

        // 예약 정보 불러오기
        loadReservations(customerId);

        setVisible(true);
    }
    
    //예약 정보 불러오는 메소드 
    private void loadReservations(String customerId) {
        List<ReserveVO> reservations = rdao.selectAllByCustomerId(customerId);

        if (!reservations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ReserveVO reservation : reservations) {
                sb.append("예약 번호: ").append(reservation.getReserveId()).append("\n")
                  .append("체크인 날짜: ").append(reservation.getCheckInDate()).append("\n")
                  .append("체크아웃 날짜: ").append(reservation.getCheckOutDate()).append("\n")
                  .append("고객 ID: ").append(reservation.getCustomerId()).append("\n")
                  .append("객실 ID: ").append(reservation.getRoomId()).append("\n")
                  .append("총 가격: ").append(reservation.getTotalPrice()).append("원\n\n");
            }
            textArea.setText(sb.toString());
        } else {
            textArea.setText("해당 고객에 대한 예약 정보가 없습니다.");
        }
    }
    
    // 등록 된 예약을 취소시키는 메소드
    private void cancelReservation(String customerId) {
        try {
            int reserveId = Integer.parseInt(txtReserveId.getText());
            int CheckId = ((ReserveDAOImple) rdao).checkId(reserveId);
            
            if (reserveId >= 0 && CheckId == 1) {
                rdao.cancel(reserveId);
                StringBuilder sb = new StringBuilder();
                sb.append("예약 취소 완료!\n\n");
                loadReservations(customerId);

                
                sb.append(textArea.getText());
                textArea.setText(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("해당하는 예약 번호가 없습니다.\n\n"); 
                loadReservations(customerId); 
                
                sb.append(textArea.getText());
                textArea.setText(sb.toString());
            }
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("[에러] 숫자를 입력하세요\n\n");
            loadReservations(customerId); 
            
            sb.append(textArea.getText());
            textArea.setText(sb.toString());
        }
    }

}
