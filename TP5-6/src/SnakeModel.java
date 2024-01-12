import java.awt.Point;
import java.util.ArrayList;

public class SnakeModel {
    private Point position; // Position actuelle de la tête du serpent
    private Direction direction; // Direction actuelle du serpent
    private int initialSize;
    private ArrayList<Point> snakeBody; // Liste des points constituant le corps du serpent

    public SnakeModel() {
        initialSize = 15; // Taille initiale du serpent
        direction = Direction.RIGHT; // Direction initiale
        snakeBody = new ArrayList<>();

        // Initialiser la position de la tête
        position = new Point(initialSize, 0);

        // Initialiser le corps du serpent
        for (int i = 0; i < initialSize; i++) {
            snakeBody.add(new Point(i, 0)); // Ajoute les points en ligne droite
        }
    }

    public ArrayList<Point> getSnakeBody(){
        return this.snakeBody;
    }

    public void move() {
        // Calcule la nouvelle position de la tête en fonction de la direction
        Point newHead = new Point(position);
        switch (direction) {
            case UP:
                newHead.y -= 5;
                break;
            case DOWN:
                newHead.y += 5;
                break;
            case LEFT:
                newHead.x -= 1;
                break;
            case RIGHT:
                newHead.x += 1;
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

    public void grow() {
        // A implémenter
    }

    public boolean checkCollision() {
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
