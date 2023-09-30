import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;


// Exemple d'affichage dans la console
class classe1 {
    public static void main(String[] args) {
        System.out.println("Méthode main() de la classe n1");
    }
}


// Exemple de récupération des entrées clavier 
class EntreeTerminal {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez la variable que vous voulez enregistrer ? (double) ");
        double variable = clavier.nextDouble();
        System.out.println("Entrez maintenant une chaine de caracteres : ");
        clavier.nextLine(); // Enleve le caractère de validation de la réponse précédente
        String reponse2 = clavier.nextLine();
        System.out.println("Vos réponses : " + variable + " " + reponse2);
        clavier.close(); // Pas mentionné dans le cours mais warning demandant la fermeture du buffer Scanner (cf diapo 16 cm1)
    }
}

// Exemple affichage ASCII 
class AfficherCaractere{
    public static void main(String[] args){
        char c1 = 'E', c2 = 'I', c3 = '-', c4 = '2', c5 = 'I';
        System.out.println(c1 + c2 + c3 + c4 + c5); // Cette ligne additionne juste les caractères
        System.out.println(""+ c1 + c2 + c3 + c4 + c5); // Cette ligne concatene les caractères
    }
}

class Lettre{
    public static void main(String[] args){
        char premiereLettre = 'A';
        char lettreMystere = (char) (premiereLettre + 25);
        System.out.printf("Code de %c = %d\n", lettreMystere, lettreMystere); // Renvoie une exception
    }
}

// Exemple cast
class Promotion {
    public static void main(String[] args){
        for(byte i = 1; i < 10; i = (byte)(i + 1)){ // le calcul de i + 1 est transformé en int alors que i est un byte donc il faut le caster pour ne pas avoir d'erreur
            System.out.println(i);
        }
    }
}

// Exemple HashMap
class HashMap_exemple{
    public static void main(String[] args){
        Map<Character, Integer> romanToInteger = new HashMap<>();
        // Ici on ajoute des jeux clé - valeur à la HashMap romanToInteger (définie comme Character : Integer, mais on peut choisir les types de clé et de valeur comme souhaité)
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);

        // Pour récupérer une valeur à partir de sa clé : 

        int valeurExemple = romanToInteger.get('I'); // Récupère la valeur dans la HashMap qui correspond à la clé 'I'.

        System.out.println("Valeur récupérée à partir de la clé 'I' dans la HashMap : " + valeurExemple);
    }
}

// Exemple de définition de classe : (diapo 58)

class Identite{
    String nom;
    String prenom;
    int age;
    String adresse;
    boolean estValide;

    // constructeur
    Identite(String n, String p, int age, String adr, boolean v){
        nom = n;
        prenom = p;
        this.age = age; // age porte le meme nom donc on appelle bien le champ
        adresse = adr;
        estValide = v;
    }
    // Méthodes
    
    //void afficherIdentite()
}

// Exemple pour afficher les champs déclarés dans une classe : 

class classeExemple {
    private int champ1;
    public String champ2;

    public static void main(String[] args) {
        Class<?> classe = classeExemple.class; /* '<?>' = wildcard -> est appelé un "wildcard" (joker, en français) en génériques Java. 
         -> C'est un type inconnu lors de la compilation. 
         -> Il est souvent utilisé quand vous savez que vous avez un objet de type générique, mais vous ne savez pas ou ne voulez pas spécifier le type exact.*/

        // Récupère tous les champs déclarés pour cette classe (publics, privés, protégés, etc.)
        Field[] champs = classe.getDeclaredFields();

        for (Field champ : champs) {
            System.out.println(champ.getName());
        }
    }
}
