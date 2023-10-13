/*
Exercice 8 : Méthodes de classe.
Dans cet exercice, vous allez définir une  "bibliothèque" de méthodes utilitaires pour la manipulation de nombres complexes. 
Pour cela, vous allez définir une classe Complexe ayant les attributs pr, pi, module (pr et pi désignant la partic réclle et la partie imaginaire d'un nombre complexe). 
Cette classe contiendra un constructeur et une méthode d'affichage. 
Vous définirez également une classe OperationComplexe contenant des méthodes utilitaires pour la manipulation de complexes. 
Les méthodes devant être implémentées sont : caleul du module. addition, multiplication. 
*/

class Complexe {
    private double pr; // partie reelle
    private double pi; // partie imaginaire
    private double module;

    public Complexe(double pr, double pi) {
        this.pr = pr;
        this.pi = pi;
        this.module = Math.sqrt(Math.pow(pr, 2) + Math.pow(pi, 2));
    }

    public void afficher() {
        System.out.println(pr + " + " + pi + "i");
    }

    public double getPr() {
        return pr;
    }

    public double getPi() {
        return pi;
    }

    public double getModule() {
        return module;
    }
}

class OperationComplexe {

    public static double calculModule(Complexe c) {
        return c.getModule();
    }

    public static Complexe addition(Complexe c1, Complexe c2){
        double pr = c1.getPr() + c2.getPr();
        double pi = c1.getPi() + c2.getPi();
        return new Complexe(pr, pi);
    }

    public static Complexe multiplication(Complexe c1, Complexe c2) {
        double pr = c1.getPr() * c2.getPr() - c1.getPi() * c2.getPi();
        double pi = c1.getPr() * c2.getPi() + c1.getPi() * c2.getPr();
        return new Complexe(pr, pi);
    }

    public static void main(String[] args){

        Complexe c1 = new Complexe(3, 1);
        Complexe c2 = new Complexe(1, 5);

        c1.afficher();
        c2.afficher();

        Complexe addition = OperationComplexe.addition(c1, c2);
        System.out.print("Résultat de la somme entre c1 et c2 : ");
        addition.afficher();

        Complexe produit = OperationComplexe.multiplication(c1, c2);
        System.out.print("Résultat du produit entre c1 et c2 : ");
        produit.afficher();

    }
}