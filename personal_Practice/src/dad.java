import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dad {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("생년월일 선택");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        
        // 생년월일 라벨
        JLabel label = new JLabel("생년월일 선택:");
        frame.add(label);
        
        // 년도 선택
        String[] years = new String[101];
        for (int i = 0; i <= 100; i++) {
            years[i] = String.valueOf(2023 - i); // 현재 연도를 기준으로 생성
        }
        JComboBox<String> yearBox = new JComboBox<>(years);
        frame.add(yearBox);
        
        // 월 선택
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        JComboBox<String> monthBox = new JComboBox<>(months);
        frame.add(monthBox);
        
        // 일 선택
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.format("%02d", i); // 두 자리 형식
        }
        JComboBox<String> dayBox = new JComboBox<>(days);
        frame.add(dayBox);
        
        // 확인 버튼 추가
        JButton submitButton = new JButton("확인");
        frame.add(submitButton);
        
        // 확인 버튼 클릭 이벤트 처리
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDate = yearBox.getSelectedItem() + "-" +
                                      monthBox.getSelectedItem() + "-" +
                                      dayBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "선택한 생년월일: " + selectedDate);
            }
        });
        
        // 프레임 표시
        frame.setVisible(true);
    }
}
