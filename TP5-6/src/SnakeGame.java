/*
 * Author: Grégoire MAHON
 * TP 5-6
 * SNAKE GAME
 */

import java.awt.*; 
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class SnakeGame {
    private SnakeModel snakeModel;
    private ArrayList<Apple> apples;
    private GameView gameView;
    private int score = 0;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 

    // width will store the width of the screen 
    int width = (int)size.getWidth(); 

    // height will store the height of the screen 
    int height = (int)size.getHeight(); 
    private int windowWidth = width; 
    private int windowHeight = height; 
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

    public boolean checkCollisionWithWalls(){
        ArrayList<Point> snakeBody = snakeModel.getSnakeBody();
        Point snakeHead = snakeBody.get(0);
        if (snakeHead.x < 0 || snakeHead.x*10 >= this.windowWidth || snakeHead.y < 0 || snakeHead.y*10 > this.windowHeight) return true;
        return false;
    }


    private void setupAndShowGUI() {
        JFrame frame = new JFrame("Jeu snake GM");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(this.windowWidth, this.windowHeight)); 
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

    private void resetGame() {
        snakeModel = new SnakeModel();
        apples.clear();
        generateApple();
        score = 0;
        setupAndShowGUI();
        gameView.update(snakeModel); 
        gameLoop();
    }

    public void gameLoop() {
        while (!gameLost) {
            if(!gameIsInPause){
            boolean collisionWithApple = snakeModel.checkCollisionWithApple(apples);
            if(collisionWithApple) {
                snakeModel.grow();
                this.score++;
                System.out.println("Score : " + this.score);
                generateApple();
                generateApple();
                collisionWithApple = false;
            }
            snakeModel.move();
            boolean gameLost = snakeModel.checkSelfCollision();
            boolean gameLostDueToWallCollision = this.checkCollisionWithWalls();
            if (gameLost || gameLostDueToWallCollision) {
                System.out.println("Collision, perdu !");
                System.out.println("Votre score : " + this.score);
                //gameView.gameOver();
                resetGame();
            }
            gameView.update(snakeModel); // Mettre à jour la vue après chaque mouvement
        }
            try {
                Thread.sleep(40);
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
