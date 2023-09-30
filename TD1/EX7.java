/*
     * Ecrire en Java un programme qui calcule les racines d'un trinome. 
     * Pour cela, vous définirez une classe trinôme avec les attributs appropriés et vous définirés les méthodes nécessaires 
     * au calcul des racines d'un trinome. Pour faciliter la programmation, vous ferez une méthode permettant d'afficher les attributs
     * d'un objet trinome
*/

class Trinome {

    double a, b, c;

    Trinome(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double discriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    double racine1() {
        double delta = discriminant();
        double racine1;
        if (delta < 0) {
            double partieReelle = -b / (2 * a);
            double partieImaginaire = Math.sqrt(-delta) / (2 * a);
            System.out.println("Partie reelle : " + partieReelle +  " + " + "partie imaginaire : " + partieImaginaire );
        }
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    double racine2() {
        double delta = discriminant();
        if (delta < 0) {
            double partieReelle = -b / (2 * a);
            double partieImaginaire = Math.sqrt(-delta) / (2 * a);
            System.out.println("Partie reelle : " + partieReelle +  " + " + "partie imaginaire : " + partieImaginaire );
        }
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

    void afficherAttributs() {
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
    }

    public static void main(String[] args) {
        Trinome trinomes[] = {
            new Trinome(1, 2, 3),
            new Trinome(0, 1, 0),
            new Trinome(1, -10, -59),
        };

        for(Trinome trinome : trinomes){
            trinome.afficherAttributs();
            System.out.println("Racine 1: " + trinome.racine1());
            System.out.println("Racine 2: " + trinome.racine2());
            System.out.println();
        }
        Trinome trinome = new Trinome(0, 0, 2);
        trinome.afficherAttributs();
        System.out.println("Racine 1: " + trinome.racine1());
        System.out.println("Racine 2: " + trinome.racine2());
    }
}



