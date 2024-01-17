/*
 * Author: Grégoire MAHON
 * TP 5-6
 * SNAKE GAME
 */

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class SnakeGame {
    private SnakeModel snakeModel;
    private ArrayList<Apple> apples;
    private GameView gameView;
    private int windowWidth = 850; 
    private int windowHeight = 550; 
    private int appleSize = 10; // taille de la pomme en pixels, cercle de diamètre 10
    private boolean gameLost = false;
    private boolean gameIsInPause = false;

    public SnakeGame() {
        snakeModel = new SnakeModel(); 
        apples = new ArrayList<>(); 
        gameView = new GameView(snakeModel, apples);
        setupAndShowGUI();
        generateApple();
        gameLoop();
    }

    public void generateApple() {
        boolean isOnSnake;
        Point newApplePosition;

        do {
            newApplePosition = Apple.generateRandomPosition(windowWidth / appleSize, windowHeight / appleSize);
            Point finalNewApplePosition = newApplePosition; // Variable temporaire final pour utilisation dans l'expression lambda
            isOnSnake = snakeModel.getSnakeBody().stream()
                                          .anyMatch(segment -> segment.equals(finalNewApplePosition));
        } while (isOnSnake); // Générer une nouvelle position si la pomme est sur le serpent

        apples.add(new Apple(newApplePosition));
        gameView.update(snakeModel);
    }

    private void setupAndShowGUI() {
        JFrame frame = new JFrame("Jeu snake GM");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(900, 600)); 
        frame.add(gameView);
        GameController controller = new GameController(snakeModel, SnakeGame.this);
        frame.addKeyListener(controller);
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }

    public void pause() {
        gameIsInPause = true;
    }

    public void resume() {
        gameIsInPause = false;
    }

    public void gameLoop() {
        while (!gameLost) {
            if(!gameIsInPause){
            snakeModel.move();
            boolean gameLost = snakeModel.checkCollision();
            if (gameLost) {
                System.out.println("Collision, perdu !");
                System.exit(0); // si collision, ferme le jeu (à revoir...)
            }
            gameView.update(snakeModel); // Mettre à jour la vue après chaque mouvement
        }
            try {
                Thread.sleep(100); // Pause pour contrôler la vitesse du jeu et éviter que les frames aillent trop vite
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SnakeGame gameManager = new SnakeGame();
        System.out.println("Jeu snake GM");
        System.out.println(gameManager.apples);
    }
}
