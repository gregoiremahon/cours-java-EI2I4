import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;

public class GameView extends JPanel {
    private SnakeModel snakeModel;
    private ArrayList<Apple> apples;
    private int appleSize = 20;
    private boolean isGameOver = false;

    public GameView(SnakeModel snakeModel, ArrayList<Apple> apples) {
        this.snakeModel = snakeModel;
        this.apples = apples;
    }

    public void update(SnakeModel snakeModel) {
        this.snakeModel = snakeModel;
        repaint();
    }

    public void gameOver() {
        isGameOver = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isGameOver) {
            drawSnake(g);
            drawApples(g);
        } else {
            drawGameOver(g);
        }
    }

    private void drawApples(Graphics g) {
        g.setColor(Color.GREEN);
        for (Apple apple : apples) {
            Point applePosition = apple.getPosition();
            g.fillOval(applePosition.x * 10, applePosition.y * 10, appleSize, appleSize);
        }
    }

    private void drawSnake(Graphics g) {
        // couleur du serpent
        g.setColor(Color.BLACK);
        ArrayList<Point> snakeBody = snakeModel.getSnakeBody();

        for (int i = 0; i < snakeBody.size() - 1; i++) {
            Point current = snakeBody.get(i);
            Point next = snakeBody.get(i + 1);
            g.drawLine(current.x * 10, current.y * 10, next.x * 10, next.y * 10);
        }
    }

    private void drawGameOver(Graphics g) {
        
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        
        int width = getWidth();
        int height = getHeight();

        String gameOverText = "Game Over";
        int textWidth = g.getFontMetrics().stringWidth(gameOverText);
        int textX = (width - textWidth) / 2;
        int textY = height / 2;
        g.drawString(gameOverText, textX, textY);
    }
}
