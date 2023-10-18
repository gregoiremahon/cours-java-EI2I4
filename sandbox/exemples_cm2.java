class surcharge {

    public static float methodeInverse(int n){
        return 1.0f / (float)n;
    }

    public static float methodeInverse(int n, boolean verification){
        if(verification && (n == 0)){
            return 0.0f; // Permet de ne pas executer la méthode inverse avec un n nul qui causerait une erreur.
        } else return methodeInverse(n);
    }

    public static void main(String[] args){
        System.out.println("Inverse de 5 : " + methodeInverse(5, true));
    }
}