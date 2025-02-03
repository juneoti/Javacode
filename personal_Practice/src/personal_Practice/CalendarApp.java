package personal_Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarApp extends JFrame {
    private static final int DAYS_IN_WEEK = 7;
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private int currentMonth;
    private int currentYear;

    // 날짜 정보 배열
    private String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    public CalendarApp() {
        setTitle("달력");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 현재 날짜로 초기화
        Calendar now = Calendar.getInstance();
        currentMonth = now.get(Calendar.MONTH); // 현재 월 (0부터 시작)
        currentYear = now.get(Calendar.YEAR); // 현재 년도

        // 상단 월/년 표시
        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        updateMonthLabel();
        add(monthLabel, BorderLayout.NORTH);

        // 이전/다음 월 버튼
        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeMonth(-1); // 이전 달로
            }
        });
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeMonth(1); // 다음 달로
            }
        });
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 달력 표시 패널
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0, DAYS_IN_WEEK)); // 7일을 가로로 배치
        add(calendarPanel, BorderLayout.CENTER);

        // 달력 초기화
        drawCalendar();
    }

    // 월/년 레이블 업데이트
    private void updateMonthLabel() {
        String[] months = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        };
        monthLabel.setText(months[currentMonth] + " " + currentYear);
    }

    // 달력 그리기
    private void drawCalendar() {
        calendarPanel.removeAll();

        // 요일 헤더 추가
        for (String day : daysOfWeek) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setFont(new Font("Arial", Font.BOLD, 14));
            calendarPanel.add(dayLabel);
        }

        // 해당 월의 첫 날이 무슨 요일인지 계산
        Calendar cal = Calendar.getInstance();
        cal.set(currentYear, currentMonth, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1~7 (Sunday = 1, Saturday = 7)

        // 해당 월의 마지막 날이 몇 일인지 계산
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 첫 번째 날짜 전의 공백 추가
        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel("")); // 공백
        }

        // 날짜 버튼 추가
        for (int day = 1; day <= lastDayOfMonth; day++) {
        	final int dayfinal = day;
            JButton dayButton = new JButton(String.valueOf(day));
            dayButton.setFont(new Font("Arial", Font.PLAIN, 14));

            // 버튼 클릭 시 날짜 출력
            dayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "선택한 날짜: " + dayfinal);
                }
            });
            calendarPanel.add(dayButton);
        }

        // 화면 갱신
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    // 월 변경
    private void changeMonth(int change) {
        currentMonth += change;

        // 월 범위 조정
        if (currentMonth < 0) {
            currentMonth = 11;
            currentYear--;
        } else if (currentMonth > 11) {
            currentMonth = 0;
            currentYear++;
        }

        // 월/년 레이블 업데이트 및 달력 새로 그리기
        updateMonthLabel();
        drawCalendar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarApp().setVisible(true);
            }
        });
    }
}
