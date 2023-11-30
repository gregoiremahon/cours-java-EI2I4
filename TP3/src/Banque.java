import java.util.ArrayList;

public class Banque {
    private String nom;
    private ArrayList<Compte> comptes;

    public Banque(String nom) {
        this.nom = nom;
        this.comptes = new ArrayList<>();
    }

    public void ouvrirCompte(Compte compte) {
        comptes.add(compte);
    }

    public void supprimerCompte(int numeroCompte) {
        comptes.removeIf(compte -> compte.getNumero() == numeroCompte);
    }

    public void afficherComptes() {
        if (comptes.size() > 0){
            for (Compte compte : comptes) {
                System.out.println(compte);
            }
        } else System.out.println("Cette banque ne contient aucun compte pour le moment..." + "\n");
    }

    public void trierComptesParNumero() { // permet de les afficher dans l'ordre en fonction de leur numero
        for (int i = 0; i < comptes.size() - 1; i++) {
            for (int j = i + 1; j < comptes.size(); j++) {
                if (comptes.get(i).getNumero() > comptes.get(j).getNumero()) {
                    Compte temp = comptes.get(i);
                    comptes.set(i, comptes.get(j));
                    comptes.set(j, temp);
                }
            }
        }
    }

    public void trierComptesParSolde() { // tri par sélection ->
        /*
        * - Pour chaque position dans la liste (sauf la dernière), identifi le compte avec le plus grand solde
        *   parmi ceux qui ne sont pas encore triés. (boucle externe) 
        * - Échangez ce compte avec le compte à la position courante dans la boucle externe.
        * - Apres chaque itération de la boucle externe, le plus compte le plus riche non trié est déplacé 
        *   à sa position définitive dans la liste.
        */
        for (int i = 0; i < comptes.size() - 1; i++) {
            int indexSoldeMax = i;
            for (int j = i + 1; j < comptes.size(); j++) {
                if (comptes.get(j).getSolde() > comptes.get(indexSoldeMax).getSolde()) {
                    indexSoldeMax = j;
                }
            }
            Compte compteMax = comptes.get(indexSoldeMax);
            comptes.set(indexSoldeMax, comptes.get(i));
            comptes.set(i, compteMax);
        }
    }


    public void afficherComptesParType(String type) {
        for (Compte compte : comptes) {
            if (compte.getClass().getSimpleName().equals(type)) {
            System.out.println(compte);
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Compte> getComptes() {
        return new ArrayList<>(comptes); // Retourne une copie pour préserver l'encapsulation
    }

    @Override
    public String toString() {
        return "Banque{" +
               "nom='" + nom + '\'' +
               ", comptes=" + comptes +
               '}';
    }
}
