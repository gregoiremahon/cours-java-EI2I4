public class EX2_recursive {

    static long sumOfStrictDivisors(int num, int divisor) {
        if (divisor > num / 2) {
            return 0;
        }
        if (num % divisor == 0) {
            return divisor + sumOfStrictDivisors(num, divisor + 1);
        } else {
            return sumOfStrictDivisors(num, divisor + 1);
        }
    }

    static boolean isPerfect(int num) {
        return sumOfStrictDivisors(num, 1) == num;
    }

    static void displayDivisors(int num, int divisor, long sumDivisors) {
        if (divisor > num / 2) {
            return;
        }
        if (num % divisor == 0) {
            System.out.printf("%d", divisor);
            if (divisor < sumDivisors - divisor) {  
                System.out.printf(" + ");
            }
            displayDivisors(num, divisor + 1, sumDivisors);  
        } else {
            displayDivisors(num, divisor + 1, sumDivisors);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100000; i++) {
            if (isPerfect(i)) {
                System.out.printf("%d = ", i);
                long sumDivisors = sumOfStrictDivisors(i, 1);
                displayDivisors(i, 1, sumDivisors);
                System.out.println();
            }
        }
    }
}
