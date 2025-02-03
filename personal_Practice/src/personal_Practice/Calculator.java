package personal_Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder currentInput = new StringBuilder();
    private String operator;
    private double firstOperand;

    public Calculator() {
        // 설정
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 디스플레이
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 48));
        add(display, BorderLayout.NORTH);

        // 버튼 패널
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        // 버튼 추가
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "C":
                currentInput.setLength(0);
                display.setText("");
                break;
            case "=":
                calculateResult();
                break;
            default:
                if ("0123456789".contains(command)) {
                    currentInput.append(command);
                    display.setText(currentInput.toString());
                } else {
                    if (currentInput.length() > 0) {
                        firstOperand = Double.parseDouble(currentInput.toString());
                        operator = command;
                        currentInput.setLength(0);
                    }
                }
                break;
        }
    }

    private void calculateResult() {
        if (operator != null && currentInput.length() > 0) {
            double secondOperand = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    result = firstOperand / secondOperand;
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput.setLength(0);
            operator = null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
