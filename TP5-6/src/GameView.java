import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class GameView extends JPanel {
    private SnakeModel model;
    private GameStatus status;

    public GameView(SnakeModel model, GameStatus status) {
        this.model = model;
        this.status = status;
    }

    public void update(SnakeModel model, GameStatus status) {
        // Mettre à jour le modèle et le statut
        this.model = model;
        this.status = status;

        // Demander la réactualisation de l'affichage
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // couleur du serpent
        g.setColor(Color.GREEN);

        // points du corps du serpent
        List<Point> snakeBody = model.getSnakeBody();

        // Dessiner le corps du serpent
        for (int i = 0; i < snakeBody.size() - 1; i++) {
            Point current = snakeBody.get(i);
            Point next = snakeBody.get(i + 1);
            g.drawLine(current.x * 10, current.y * 10, next.x * 10, next.y * 10);
        }

        // Dessiner la tête du serpent
        if (!snakeBody.isEmpty()) {
            Point head = snakeBody.get(0);
            g.setColor(Color.RED); // Couleur différente pour la tête
            g.fillOval(head.x * 10, head.y * 10, 10, 10);
        }
    }

    // Autres méthodes...
}
