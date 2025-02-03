package personal_Practice;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TetrisGame extends JPanel implements ActionListener {
    private final int WIDTH = 300; // Width of the game area
    private final int HEIGHT = 600; // Height of the game area
    private final int BOX_SIZE = 30; // Size of each box
    private final int ROWS = HEIGHT / BOX_SIZE; // Number of rows
    private final int COLS = WIDTH / BOX_SIZE; // Number of columns
    private final Color[][] board; // Game board
    private Tetromino currentTetromino; // Current tetromino
    private Timer timer;
    private boolean gameOver;

    public TetrisGame() {
        board = new Color[ROWS][COLS];
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) return;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT: moveTetromino(-1, 0); break;
                    case KeyEvent.VK_RIGHT: moveTetromino(1, 0); break;
                    case KeyEvent.VK_DOWN: moveTetromino(0, 1); break;
                    case KeyEvent.VK_UP: rotateTetromino(); break;
                }
            }
        });

        currentTetromino = Tetromino.getRandomTetromino(this);
        timer = new Timer(500, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] != null) {
                    g.setColor(board[row][col]);
                    g.fillRect(col * BOX_SIZE, row * BOX_SIZE, BOX_SIZE, BOX_SIZE);
                }
            }
        }

        drawTetromino(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", WIDTH / 2 - 75, HEIGHT / 2);
        }
    }

    private void drawTetromino(Graphics g) {
        g.setColor(currentTetromino.color);
        for (Point p : currentTetromino.getCoordinates()) {
            g.fillRect((p.x + currentTetromino.x) * BOX_SIZE,
                    (p.y + currentTetromino.y) * BOX_SIZE,
                    BOX_SIZE, BOX_SIZE);
        }
    }

    private void moveTetromino(int dx, int dy) {
        if (canMove(currentTetromino.x + dx, currentTetromino.y + dy)) {
            currentTetromino.x += dx;
            currentTetromino.y += dy;
            repaint();
        } else if (dy > 0) {
            lockTetromino();
            clearLines();
            currentTetromino = Tetromino.getRandomTetromino(this);
            if (!canMove(currentTetromino.x, currentTetromino.y)) {
                gameOver = true;
            }
        }
    }

    private void rotateTetromino() {
        currentTetromino.rotate();
        if (!canMove(currentTetromino.x, currentTetromino.y)) {
            currentTetromino.undoRotation();
        }
        repaint();
    }

    private boolean canMove(int x, int y) {
        for (Point p : currentTetromino.getCoordinates()) {
            int newX = p.x + x;
            int newY = p.y + y;
            if (newX < 0 || newX >= COLS || newY < 0 || newY >= ROWS || board[newY][newX] != null) {
                return false;
            }
        }
        return true;
    }

    private void lockTetromino() {
        for (Point p : currentTetromino.getCoordinates()) {
            board[p.y + currentTetromino.y][p.x + currentTetromino.x] = currentTetromino.color;
        }
    }

    private void clearLines() {
        for (int row = 0; row < ROWS; row++) {
            boolean fullLine = true;
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == null) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                for (int r = row; r > 0; r--) {
                    System.arraycopy(board[r - 1], 0, board[r], 0, COLS);
                }
                board[0] = new Color[COLS]; // Clear the top line
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            moveTetromino(0, 1);
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Game");
        TetrisGame tetrisGame = new TetrisGame();
        frame.add(tetrisGame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    // Tetromino class
    static class Tetromino {
        Color color;
        Point[] coordinates;
        int x, y;

        Tetromino(Color color, Point[] coordinates, int startX) {
            this.color = color;
            this.coordinates = coordinates;
            this.x = startX; // Use the provided starting X position
            this.y = 0; // Start at the top
        }

        static Tetromino getRandomTetromino(TetrisGame game) {
            Random rand = new Random();
            int startX = game.COLS / 2 - 1; // Access COLS through the game instance
            switch (rand.nextInt(7)) {
                case 0: return new Tetromino(Color.CYAN, new Point[]{new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0)}, startX); // I
                case 1: return new Tetromino(Color.YELLOW, new Point[]{new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)}, startX); // O
                case 2: return new Tetromino(Color.GREEN, new Point[]{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)}, startX); // S
                case 3: return new Tetromino(Color.MAGENTA, new Point[]{new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)}, startX); // Z
                case 4: return new Tetromino(Color.BLUE, new Point[]{new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)}, startX); // T
                case 5: return new Tetromino(Color.ORANGE, new Point[]{new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1)}, startX); // L
                case 6: return new Tetromino(Color.RED, new Point[]{new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)}, startX); // J
                default: return null;
            }
        }

        Point[] getCoordinates() {
            return coordinates;
        }

        void rotate() {
            for (int i = 0; i < coordinates.length; i++) {
                int temp = coordinates[i].x;
                coordinates[i].x = -coordinates[i].y;
                coordinates[i].y = temp;
            }
        }

        void undoRotation() {
            for (int i = 0; i < coordinates.length; i++) {
                int temp = coordinates[i].x;
                coordinates[i].x = coordinates[i].y;
                coordinates[i].y = -temp;
            }
        }
    }
}
