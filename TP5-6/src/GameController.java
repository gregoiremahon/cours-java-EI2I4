import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController extends KeyAdapter {
    private SnakeModel model;
    private SnakeGame gameManager;
    private boolean pauseFlag = false;

    public GameController(SnakeModel model, SnakeGame gameManager) {
        this.model = model;
        this.gameManager = gameManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Met à jour la direction du modèle en fonction de la touche pressée
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                model.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                model.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                model.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                model.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                gameManager.pause();
                pauseFlag = true;
                break;
            case KeyEvent.VK_ENTER:
                if (pauseFlag) {
                    gameManager.resume();
                    pauseFlag = false;
                }
                break;
        }
    }
}
