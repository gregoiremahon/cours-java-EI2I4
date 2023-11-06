import java.util.Scanner;

class Personne {
    private String nom;
    private int age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public Personne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom : ");
        this.nom = scanner.nextLine();
        System.out.print("Entrez l'âge : ");
        this.age = scanner.nextInt();
        scanner.close();
    }

    public void afficher() {
        System.out.println("Nom: " + nom + ", Âge: " + age);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Scolaire extends Personne {
    private String nomEtablissement;
    private String niveau;

    public Scolaire(String nom, int age, String nomEtablissement, String niveau) {
        super(nom, age);
        this.nomEtablissement = nomEtablissement;
        this.niveau = niveau;
    }

    public Scolaire() {
        super(); // Appelle le constructeur de Personne pour nom et age
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'établissement : ");
        this.nomEtablissement = scanner.nextLine();
        System.out.print("Entrez le niveau (Primaire, Secondaire, Supérieur) : ");
        this.niveau = scanner.nextLine();
        scanner.close();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Établissement: " + nomEtablissement + ", Niveau: " + niveau);
    }
}

class Etudiant extends Scolaire {
    private String formation;

    public Etudiant(String nom, int age, String nomEtablissement, String niveau, String formation) {
        super(nom, age, nomEtablissement, niveau);
        this.formation = formation;
    }

    public Etudiant() {
        super(); // Appelle le constructeur de Scolaire pour les autres attributs
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la formation : ");
        this.formation = scanner.nextLine();
        scanner.close();
    }

    @Override
    public void afficher() {
        super.afficher(); // Appelle la méthode afficher de Scolaire
        System.out.println("Formation: " + formation);
    }
}

class Lyceen extends Scolaire {
    private String filiereBac;

    public Lyceen(String nom, int age, String nomEtablissement, String niveau, String filiereBac) {
        super(nom, age, nomEtablissement, niveau);
        this.filiereBac = filiereBac;
    }

    public Lyceen() {
        super(); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la filière du bac (S, L, ...) : ");
        this.filiereBac = scanner.nextLine();
        scanner.close();
    }

    @Override
    public void afficher() {
        super.afficher(); 
        System.out.println("Filière bac: " + filiereBac);
    }
}

public class EX5 {
    public static void main(String[] args) {
        // avec args
        Etudiant etudiant = new Etudiant("Alice", 20, "Université de Polytechnique", "Supérieur", "Informatique");
        etudiant.afficher();

        // avec input
        Lyceen lyceen = new Lyceen();
        lyceen.afficher();
    }
}
