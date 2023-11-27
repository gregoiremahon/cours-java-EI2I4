class Point2D {

    private double x;
    private double y;
    private double norme;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
        this.norme = calculateNorm();
    }

    public void display() {
        System.out.println("Point2D(" + x + ", " + y + ") avec une norme de " + norme);
    }

    public double calculateNorm() {
        return Math.sqrt(x * x + y * y);
    }

    public double dotProduct(Point2D other) {
        return this.x * other.x + this.y * other.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getNorme() {
        return norme;
    }

    public void setNorme(double norme){
        this.norme = norme;
    }

    public String toString(){
        return this.x + ", " + this.y + " norme : "+ this.norme;
    }

}


class Point3D extends Point2D{
    private double z;

    public Point3D(double x, double y, double z){
        super(x, y);
        this.z = z;
        setNorme(calculateNorm());
    }

    public double getZ() {
        return z;
    }

    public double calculateNorm() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    public void setNorme(double norme) {
            super.setNorme(norme);
    }

    public void display() {
        System.out.println("Point3D(" + getX() + ", " + getY() + ", " + z + ") avec une norme de " + getNorme());
    }

    public double dotProduct(Point3D other) {
        double dotProduct2D = super.dotProduct(other);

        return dotProduct2D + this.z * other.z;
    }

    public String toString(){
        return super.toString() + ", z : " + this.z;
    }

}

public class EX8{
    public static void main(String[] args){

        Point2D p1 = new Point2D(3.5, 5.2);
        Point2D p2 = new Point2D(2, 2);
        p1.display();
        double produitScalaireP1 = p1.dotProduct(p2);
        System.out.println("Résultat du produit scalaire en 2D : " + produitScalaireP1);
        System.out.println();
        Point3D p3D = new Point3D(1, 4, 3);
        Point3D p3D_2 = new Point3D(2, 6, 5);

        p3D.display();
        p3D_2.display();
        double produitScalaireP3D = p3D.dotProduct(p3D_2);
        System.out.println("Résultat du produit scalaire en 3D : " + produitScalaireP3D);

    }
}


class EX8avecToString{
    public static void main(String[] args){
        Point2D p1 = new Point2D(3.5, 5.2);
        Point2D p2 = new Point2D(2, 2);
        Point3D p3D = new Point3D(1, 4, 3);

        System.out.println(p1 + "\n" + p2 + "\n" + p3D);
    }
}
