package personal_Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BOX_SIZE = 20;
    private final LinkedList<Point> snake;
    private Point food;
    private char direction;
    private boolean gameOver;
    private final Timer timer;

    public SnakeGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: if (direction != 'S') direction = 'W'; break;
                    case KeyEvent.VK_DOWN: if (direction != 'W') direction = 'S'; break;
                    case KeyEvent.VK_LEFT: if (direction != 'D') direction = 'A'; break;
                    case KeyEvent.VK_RIGHT: if (direction != 'A') direction = 'D'; break;
                }
            }
        });

        snake = new LinkedList<>();
        snake.add(new Point(5, 5));
        direction = 'D'; // Start moving right
        spawnFood();

        timer = new Timer(100, this);
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        food = new Point(rand.nextInt(WIDTH / BOX_SIZE), rand.nextInt(HEIGHT / BOX_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", WIDTH / 2 - 75, HEIGHT / 2);
            return;
        }

        // Draw the snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * BOX_SIZE, p.y * BOX_SIZE, BOX_SIZE, BOX_SIZE);
        }

        // Draw the food
        g.setColor(Color.RED);
        g.fillRect(food.x * BOX_SIZE, food.y * BOX_SIZE, BOX_SIZE, BOX_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        Point head = snake.getFirst();
        Point newHead = new Point(head.x, head.y);

        switch (direction) {
            case 'W': newHead.y--; break;
            case 'S': newHead.y++; break;
            case 'A': newHead.x--; break;
            case 'D': newHead.x++; break;
        }

        // Check for collisions
        if (newHead.x < 0 || newHead.x >= WIDTH / BOX_SIZE || newHead.y < 0 || newHead.y >= HEIGHT / BOX_SIZE || snake.contains(newHead)) {
            gameOver = true;
            repaint();
            return;
        }

        snake.addFirst(newHead);

        // Check if food is eaten
        if (newHead.equals(food)) {
            spawnFood();
        } else {
            snake.removeLast(); // Remove tail
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame snakeGame = new SnakeGame();
        frame.add(snakeGame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
