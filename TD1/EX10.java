/*
 * Implémentez une classe Vecteur qui modélisera un objet vecteur de N^3.
 * Votre classe Vecteur aura une méthode permettant de construire un vecteur selon des valeurs données dans le code, 
 * une méthode d'affichage, une méthode permettant de calculer la norme d'un vecteur (la norme étant un attribut de votre classe), 
 * une méthode calculant la somme de deux vecteurs passés en paramètre et enfin une méthode réalisant le produit scalaire.
 */

class Vecteur {

    String nom;
    double x, y, z;
    double norme;  

    Vecteur(String n, double x, double y, double z) {
        nom = n;
        this.x = x;
        this.y = y;
        this.z = z;
        this.norme = calculerNorme();
    }

    void afficherVecteur() {
        System.out.println(nom + ": " + "(" + x + ", " + y + ", " + z + ")");
    }

    static double mettreAuCarre(double num){
        return Math.pow(num, 2);
    }

    double calculerNorme() {
        return Math.sqrt(mettreAuCarre(x) + mettreAuCarre(y) + mettreAuCarre(z));
    }

    double getNorme() {
        return norme;
    }

    static Vecteur somme(Vecteur v1, Vecteur v2) {
        String name = "Somme des vecteurs: " + v1.nom + " et " + v2.nom;
        return new Vecteur(name, v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    static double produitScalaire(Vecteur v1, Vecteur v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static void main(String[] args) {
        Vecteur v1 = new Vecteur("v1", 1, 2, 3);
        Vecteur v2 = new Vecteur("v2", 4, 5, 6);

        v1.afficherVecteur();
        v2.afficherVecteur();

        System.out.println("Norme de v1: " + v1.getNorme());
        System.out.println("Norme de v2: " + v2.getNorme());

        Vecteur somme = Vecteur.somme(v1, v2);
        somme.afficherVecteur();

        double prodScalaire = Vecteur.produitScalaire(v1, v2);
        System.out.println("Produit scalaire de v1 et v2: " + prodScalaire);
    }
}

