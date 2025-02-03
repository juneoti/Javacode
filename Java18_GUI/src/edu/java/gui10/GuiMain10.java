package edu.java.gui10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GuiMain10 {

    // JFrame: 프로그램의 메인 윈도우를 나타내는 변수입니다.
    private JFrame frame;

    /**
     * 애플리케이션을 실행하는 메서드입니다.
     */
    public static void main(String[] args) {
        // EventQueue.invokeLater: GUI 관련 코드를 별도의 이벤트 디스패치 스레드에서 실행합니다.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // GuiMain10 객체를 생성하고 창을 보여줍니다.
                    GuiMain10 window = new GuiMain10();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(); // 오류 발생 시 스택 트레이스를 출력합니다.
                }
            }
        });
    }

    /**
     * 애플리케이션을 생성하는 생성자입니다.
     */
    public GuiMain10() {
        initialize(); // GUI 컴포넌트 초기화 메서드를 호출합니다.
    }

    /**
     * 프레임의 내용을 초기화하는 메서드입니다.
     */
    private void initialize() {
        // JFrame 생성 및 설정: 창의 크기와 종료 시 동작을 설정합니다.
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        // "File" 메뉴 생성
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        // "Open" 메뉴 아이템 생성 및 액션 리스너 추가
        JMenuItem mntmOpen = new JMenuItem("Open");
        mntmOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JFileChooser: 파일 선택 대화상자를 생성하여 팝업으로 띄웁니다.
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(null);
                
                // 파일이 선택된 경우
                if (result == JFileChooser.APPROVE_OPTION) {
                    System.out.println("파일 선택");
                    File selected = chooser.getSelectedFile();
                    // 선택한 파일의 절대 경로를 출력합니다.
                    System.out.println(selected.getAbsolutePath());
                } else { // 취소 버튼을 클릭한 경우
                    System.out.println("취소");
                }
            }
        });
        mnFile.add(mntmOpen); // "File" 메뉴에 "Open" 항목 추가
        
        // "Save" 메뉴 아이템 추가 (동작은 아직 구현되지 않음)
        JMenuItem mntmSave = new JMenuItem("Save");
        mnFile.add(mntmSave);
        
        // 메뉴 아이템 사이에 구분선을 추가합니다.
        JSeparator separator = new JSeparator();
        mnFile.add(separator);
        
        // "Exit" 메뉴 아이템 생성 및 액션 리스너 추가
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JOptionPane의 ConfirmDialog: Yes, No, Cancel 버튼을 가진 대화상자
                int result = JOptionPane.showConfirmDialog(frame.getContentPane(), "종료하시겠습니까?");
                
                // 선택 결과 출력
                System.out.println("선택 결과 : " + result);
                
                // 사용자가 "Yes"를 클릭한 경우 프로그램 종료
                if (result == JOptionPane.YES_OPTION) {
                    // System.exit(0): 정상 종료
                    System.exit(0);
                } else {
                    System.out.println("취소");
                }
            }
        });
        mnFile.add(mntmExit); // "File" 메뉴에 "Exit" 항목 추가
        
        // "Help" 메뉴 생성
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        // "About" 메뉴 아이템 생성 및 액션 리스너 추가
        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JOptionPane의 MessageDialog: 단순한 메시지 대화상자
                JOptionPane.showMessageDialog(frame, "버전 1.0");
            }
        });
        mnHelp.add(mntmAbout); // "Help" 메뉴에 "About" 항목 추가
    }

}
