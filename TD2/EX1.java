public class EX1 {
    public static void main(String[] args){
        String uneChaine = "le java à Polytech, c'est Top";
        String unMessage = "le java à Polytech, c'est Top";
        String un = "le java à Polytech, ";
        String messageCoupe = "c'est Top";
        String messageColle = "le java à Polytech," + " c'est Top";
        String autosatisfaction = un + messageCoupe;
        //String test = autosatisfaction.intern(); // renvoie le contenu du string autosatisfaction donc devrait être égal à la chaine de caracteres et donc créée au mm endroit.
        String propagande = new String("le java à Polytech, c'est Top");
        String letmotiv = new String("le java à Polytech, c'est Top");

        System.out.println("1 : uneChaine == unMessage : " + (uneChaine == unMessage));
        System.out.println("2 : uneChaine == messageColle : " + (uneChaine == messageColle));
        System.out.println("3 : uneChaine == autosatisfaction : " + (uneChaine == autosatisfaction));
        System.out.println("4 : uneChaine == propagande : " + (uneChaine == propagande));
        System.out.println("5 : propagande == letmotiv : " + (propagande == letmotiv));
        System.out.println("5 : propagande == letmotiv : " + (propagande == letmotiv));
        System.out.println("5 : propagande : " + (propagande));
    }
}
