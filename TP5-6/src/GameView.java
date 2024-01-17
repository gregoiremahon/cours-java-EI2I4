import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class GameView extends JPanel {
    private SnakeModel snakeModel;
    private ArrayList<Apple> apples;

    public GameView(SnakeModel snakeModel, ArrayList<Apple> apples) {
        this.snakeModel = snakeModel;
        this.apples = apples;
    }

    public void update(SnakeModel snakeModel) {
        // Met à jour la vue avec les données
        this.snakeModel = snakeModel;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
        drawApples(g);
    }

    private void drawApples(Graphics g) {
        g.setColor(Color.GREEN);
        for (Apple apple : apples) {
            Point applePosition = apple.getPosition();
            g.fillOval(applePosition.x * 10, applePosition.y * 10, 10, 10);
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
}
