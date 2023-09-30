import java.util.Calendar;

// Apprentissage POO

class Personne {
    static int creationID = 0;
    int id;
    String nom;
    String prenom;
    int anneeNaissance;

    Calendar calendar = Calendar.getInstance();

    Personne(String n, String p, int anneeNaissance){
        id = creationID++;
        nom = n;
        prenom = p;
        this.anneeNaissance = anneeNaissance;
    }

    int calculerAge(int anneeNaissance){
        int anneeActuelle = calendar.get(Calendar.YEAR);
        return anneeActuelle - anneeNaissance;
    }

    void afficherPersonne(){
        int age = calculerAge(anneeNaissance);
        System.out.println(creationID + ", " + nom + ", " + prenom + ", " + anneeNaissance + ", age : " + age);
    }

    public static void main(String[] args) {
        Personne tabID[] = {
            new Personne("LELONG", "Armand", 2002),
            new Personne("PLAZE", "Sylvain", 2024),
        };

        for(Personne id : tabID){
            id.afficherPersonne();
        }
    }
}
