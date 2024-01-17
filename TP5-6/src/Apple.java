import java.awt.Point;

public class Apple {
    private Point position;

    public Apple(Point position) {
        this.position = position;
    }
    
    @Override
    public String toString() {
        return "Apple at " + position;
    }

    public Point getPosition() {
        return position;
    }

    public static Point generateRandomPosition(int width, int height) {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        return new Point(x, y);
    }
}
