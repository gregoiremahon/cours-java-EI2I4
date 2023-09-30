public class EX2 {

    /* Un nombre est parfait s'il est égal à la somme de ses diviseurs stricts (par exemple 6 = 1 + 2 + 3) 
     * Ecrire en Java un programme qui permet d'établir la liste des nombres parfaits inférieurs à 100000.
     * Votre programme affichera la décomposition de chacun des nombres parfaits identifiés.
    */

    static int sumOfStrictDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    static boolean isPerfect(int num){
        return sumOfStrictDivisors(num) == num;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 100000; i++) {
            if (isPerfect(i)) { 
                System.out.printf("%d = ", i);
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) { // Si j est un diviseur de i
                        System.out.printf("%d", j);
                        if (j < sumOfStrictDivisors(i) - j) { // Vérification de si j est le dernier diviseur
                            System.out.printf(" + ");
                        } else break;
                    }
                }
                System.out.println();
            }
        }
    }
} 
