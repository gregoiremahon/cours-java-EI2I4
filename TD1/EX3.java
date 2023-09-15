class EX3 {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}

class EX3_forEach {
    public static void main(String[] args) {
        for(String argument : args){
            System.out.println(argument);
        }
    }
}
