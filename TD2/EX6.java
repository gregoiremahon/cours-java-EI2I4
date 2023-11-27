class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean sontIdentiques(Point a, Point b) {
        System.out.println("méthode de base sontIdentiques");
        return (a.x == b.x) && (a.y == b.y);
    }

    public boolean estIdentique(Point a) {
        return (a.x == x) && (a.y == y);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}

class PointNom extends Point {
    private char nom;

    public PointNom(int x, int y, char nom) {
        super(x, y);
        this.nom = nom;
    }

    public boolean estIdentique(Point autrePoint) {
        if (autrePoint instanceof PointNom) {
            PointNom autrePointNom = (PointNom) autrePoint;
            return super.estIdentique(autrePoint) && this.nom == autrePointNom.nom;
        }
        return false;
    }
    
    public static boolean sontIdentiques(PointNom a, PointNom b) {
        return (a.getX() == b.getX()) && (a.getY() == b.getY()) && (a.nom == b.nom);
    }
}

public class EX6 {
    public static void main(String[] args) {

        Point p = new Point(2, 4);
        PointNom pn1 = new PointNom(2, 4, 'A');
        PointNom pn2 = new PointNom(2, 4, 'B');

        System.out.println(p.estIdentique(pn2));
        System.out.println(p.estIdentique(pn1));
        System.out.println(pn1.estIdentique(p));
        System.out.println(Point.sontIdentiques(pn1, pn2));
        System.out.println(PointNom.sontIdentiques(pn1, pn2));
    }
}
