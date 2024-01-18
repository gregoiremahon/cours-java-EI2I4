import java.awt.Point;
import java.util.ArrayList;

public class SnakeModel {
    private Point position;
    private Direction direction;
    private Direction nextDirection; 
    private int initialSize;
    private ArrayList<Point> snakeBody;
    private double snakeSpeed = 1;

    public SnakeModel() {
        initialSize = 10; 
        direction = Direction.RIGHT; 
        snakeBody = new ArrayList<>();
        position = new Point(initialSize, 15);


        for (int i = 0; i < initialSize; i++) {
            snakeBody.add(new Point(i, 15)); // Ajoute les points en ligne droite
        }

        nextDirection = direction; // init nextDirection
    }

    public ArrayList<Point> getSnakeBody(){
        return this.snakeBody;
    }

    public void move() {
        if (direction != nextDirection) {
            snakeBody.add(new Point(position));
            direction = nextDirection;
        }
        // Calcule la nouvelle position de la tête en fonction de la direction
        Point newHead = new Point(position);
        switch (direction) {
            case UP:
                newHead.y -= snakeSpeed;
                break;
            case DOWN:
                newHead.y += snakeSpeed;
                break;
            case LEFT:
                newHead.x -= snakeSpeed;
                break;
            case RIGHT:
                newHead.x += snakeSpeed;
                break;
        }

        // Ajoute la nouvelle tête au début de snakeBody
        snakeBody.add(0, newHead);

        // Met à jour la position avec la nouvelle tête
        position = newHead;
        
        // Si le serpent ne grandit pas, retire le dernier élément
        if (snakeBody.size() > initialSize) {
            snakeBody.remove(snakeBody.size() - 1);
        }
        
    }

    public Direction getDirection(){
        return this.direction;
    }


    public void grow() {
        Point tail = snakeBody.get(snakeBody.size() - 1); 
        Point lastPointBeforeTail = snakeBody.get(snakeBody.size() - 2);
        Point newTail = new Point(tail); 

        if (lastPointBeforeTail.x == tail.x) { // Si le serpent se déplace verticalement
            newTail.y += (tail.y < lastPointBeforeTail.y) ? -snakeSpeed * 5 : snakeSpeed * 5;
        } else if (lastPointBeforeTail.y == tail.y) { // Si le serpent se déplace horizontalement
            newTail.x += (tail.x < lastPointBeforeTail.x) ? -snakeSpeed * 5 : snakeSpeed * 5;
        }
    
        snakeBody.add(newTail);
        initialSize++;
    }
    

    public boolean checkSelfCollision() {
        Point snakeHead = snakeBody.get(0);
        // Boucle qui parcourt les coordonnées du serpent et qui vérifie
        // Si la tête entre en collision avec le reste du corps du serpent.
        for(int i = 1 ; i < snakeBody.size() - 1; i++){
            if (snakeHead.x == (snakeBody.get(i)).x && snakeHead.y == (snakeBody.get(i)).y){
                return true;
            }
        }
        return false;
    }

    public boolean checkCollisionWithApple(ArrayList<Apple> apples) {
        Point snakeHead = snakeBody.get(0);
        for (int i = 0; i < apples.size(); i++) {
            Apple apple = apples.get(i);
            Point appleCenter = apple.getPosition();
            if (snakeHead.x >= appleCenter.x - 1 && snakeHead.x  <= appleCenter.x + 1) {
                if(snakeHead.y >= appleCenter.y - 1 && snakeHead.y  <= appleCenter.y + 1){
                    apples.remove(i);
                    this.grow();
                    return true; 
                }
            }
        }
        return false; 
    }

    public void setDirection(Direction newDirection) {
        /* Permet de changer la direction du serpent
         * Lorsque la direction actuelle est UP, 
         * le serpent ne peut pas changer sa direction en DOWN, et vice-versa...
         */
        switch (this.direction) {
            case UP:
                if (newDirection != Direction.DOWN) {
                    this.direction = newDirection;
                }
                break;
            case DOWN:
                if (newDirection != Direction.UP) {
                    this.direction = newDirection;
                }
                break;
            case LEFT:
                if (newDirection != Direction.RIGHT) {
                    this.direction = newDirection;
                }
                break;
            case RIGHT:
                if (newDirection != Direction.LEFT) {
                    this.direction = newDirection;
                }
                break;
        }
        nextDirection = newDirection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Position de la tête du serpent: ").append(position.toString()).append("\n");
        sb.append("Direction actuelle: ");
    
        switch (direction) {
            case UP:
                sb.append("Haut");
                break;
            case DOWN:
                sb.append("Bas");
                break;
            case LEFT:
                sb.append("Gauche");
                break;
            case RIGHT:
                sb.append("Droite");
                break;
        }
    
        sb.append("\nLongueur du corps du serpent: ").append(snakeBody.size());
        sb.append("\nCorps du serpent: ");
        for (Point point : snakeBody) {
            sb.append(point.toString()).append(" ");
        }
        return sb.toString();
    }
    
}
