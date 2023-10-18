/*
 * Exercice 11 : Les tableaux
 * En vous aidant de la classe Math (voir API), écrire une méthode permettant de calculer un
 * nombre entier aléatoire compris entre deux valeurs. Vous éerirez ensuite une méthode qui 
 * retournera un tableau d'entiers pris au hasard entre deux valeurs dont les arguments seront
 * la taile du tableau et les deux valeurs de l'intervalle. Enfin, écrivez une méthode permettant
 * l'affichage de ce tableau.
 * 
 */

class EX11{

    public static int nombreAleatoireEntre(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static int[] tableauEntiersAleatoires(int taille, int min, int max) {
        int[] tableau = new int[taille];
        for (int i = 0; i < taille; i++) {
            tableau[i] = nombreAleatoireEntre(min, max);
        }
        return tableau;
    }

    public static void afficherTableau(int[] tableau) {
        System.out.print("[");
        for (int i : tableau) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] tableau = tableauEntiersAleatoires(10, 1, 100);
        afficherTableau(tableau);
    }
}
