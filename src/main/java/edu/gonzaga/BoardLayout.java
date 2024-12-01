package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class BoardLayout extends JFrame {
    private Board board;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private ArrayList<JLabel> tiles;
    private int timeElapsed;
    private boolean gameUpdates;

    public BoardLayout(Board board, Display display) throws IOException {
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char direction;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                    direction = 'u';
                    break;
                    case KeyEvent.VK_A:
                    direction = 'l';
                    break;
                    case KeyEvent.VK_S:
                    direction = 'd';
                    break;
                    case KeyEvent.VK_D:
                    direction = 'r';
                    break;
                    default:
                    direction = ' ';
                }
                if (direction != ' ' && !gameUpdates) {
                    board.turnSnake(direction);
                }
            }
        });
        setFocusable(true);
        requestFocusInWindow();
        
        this.board = board;
        this.timeElapsed = 0;
        this.gameUpdates = false;
        // Set up the JFrame
        setTitle("Brawl Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(17 * 50, 15 * 50 + 50);
        setResizable(false);

        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BorderLayout());

        scoreLabel = new JLabel("Score: " + board.getScore());
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        borderPanel.add(scoreLabel, BorderLayout.WEST);

        timerLabel = new JLabel("Time: " + timeElapsed, JLabel.RIGHT);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        borderPanel.add(timerLabel, BorderLayout.EAST);
        
        add(borderPanel, BorderLayout.NORTH);

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(15, 17));
        panel.setBackground(display.getBackgroundColor());

        // Create text labels for the rest of the grid
        tiles = new ArrayList<>();
        for (int i = 0; i < 15 * 17; i++) {
            JLabel label = new JLabel();
            label.setOpaque(false);
            label.setPreferredSize(new Dimension(50, 50));
            tiles.add(label);
            panel.add(label);
        }

        add(panel, BorderLayout.CENTER);

        // Make the JFrame visible
        setVisible(true);
        setLocationRelativeTo(null);

        // Set up timer
        new Timer(1000, e -> updateGame()).start();
    }

    public void updateGame() {
        // clear previous tile colors
        if (gameUpdates) return;
        gameUpdates = true;

        setEnabled(false);

        for (int i = 0; i < 15*17; i ++) {
            tiles.get(i).setIcon(null);
        }

        // draw the food
        tiles.get(board.getFood().getY() * 17 + board.getFood().getX()).setIcon(new ImageIcon("assets/" + board.getFood().texturePath));

        // draw the obstacles
        for (Obstacle obstacle : board.getObstacles()) {
            tiles.get(obstacle.getY() * 17 + obstacle.getX()).setIcon(new ImageIcon("assets/obstacle.png"));
        }

        // draw the snake
        for (SnakeSegment segment : board.getSnake().getSegments()) {
            tiles.get(segment.getY() * 17 + segment.getX()).setIcon(new ImageIcon("assets/" + segment.getRotAsStr()+".png"));
        }

        tiles.get(board.getSnake().getY() * 17 + board.getSnake().getX()).setIcon(new ImageIcon("assets/" + board.getSnake().getFacing()+".png"));
        // try {
        //     tiles.set(board.getSnake().getY() * 17 + board.getSnake().getX(), new JLabel(new ImageIcon(ImageIO.read(new File("./hr.png")))));
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

       // Update score and timer
       scoreLabel.setText("Score: " + board.getScore());
       timeElapsed++;
       timerLabel.setText("Time: " + timeElapsed);

       setEnabled(true);

       gameUpdates = false;
    }
    

    public static void main(String[] args) throws IOException {
        Board board = new Board(5);
        Display display = new Display();
        new BoardLayout(board, display);
    }
}
