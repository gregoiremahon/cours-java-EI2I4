import java.util.Scanner;

public class EX1 {

    static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static double pow(double n, int i) {
        double ans = 1.0;

        if(i != 0) {
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    ans *= n;
                }
            } else if (i < 0) {
                for (int j = 0; j < -i; j++) {
                    ans /= n;
                }
            }
        }
        return ans;
    }

    static double exponential(double x) {
        final int NUM_TERMS = 20; 
        double sum = 0.0; 
        for (int i = 0; i < NUM_TERMS; i++) {
            sum += pow(x, i) / factorial(i);
        }
        return sum;
    }
    public static void main(String[] args){

        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre pour calculer son exponentielle (double) :");
        double value = clavier.nextDouble();
        clavier.close();

        double exp = exponential(value);
        double bibValue = Math.exp(value);
        System.out.println("Valeur de la bibliothèque : " + bibValue);
        System.out.println("Valeur exponentielle de " + value + " = " + exp);
        System.out.println("Différence : " + (exp > bibValue ? exp - bibValue : bibValue - exp));
        long factorielle;
        for(int i = 0; i <= 20; i++){
            factorielle = factorial(i);
            System.out.println(i + "! = " + factorielle);
        }

    }
}