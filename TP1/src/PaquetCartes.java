import java.util.ArrayList;
import java.util.Collections;

public class PaquetCartes {
    private ArrayList<Carte> cartes;

    public PaquetCartes() {
        this.cartes = new ArrayList<>();
    }

    public void ajouterCarte(Carte carte) {
        cartes.add(carte);
        System.out.println("Création du jeu de carte : " + carte.getNom() + " de " + carte.getCouleur() + "; valeur : " + carte.getValeur());
    }

    public void melanger() {
        System.out.println("Mélange des cartes...");
        Collections.shuffle(cartes);
    }

    public ArrayList<ArrayList<Carte>> distribuer() {
        System.out.println("Distribution des cartes...");
        ArrayList<Carte> paquetJoueur1 = new ArrayList<>();
        ArrayList<Carte> paquetJoueur2 = new ArrayList<>();

        // distribue alternativement une carte sur deux à chaque joueur
        for (int i = 0; i < cartes.size(); i++) {
            if (i % 2 == 0) {
                paquetJoueur1.add(cartes.get(i));
            } else {
                paquetJoueur2.add(cartes.get(i));
            }
        }
        
        cartes.clear(); // le paquet principal est maintenant vide après la distribution
    
        ArrayList<ArrayList<Carte>> paquets = new ArrayList<>();
        paquets.add(paquetJoueur1);
        paquets.add(paquetJoueur2);
        return paquets;
    }
    

    public Carte jouerPremiereCarte() {
        if (cartes.isEmpty()) {
            return null;
        }
        return cartes.remove(0);
    }

    public void ajouterCarteAuDessous(Carte carte) {
        cartes.add(carte);
    }

    public boolean estVide() {
        return cartes.isEmpty();
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
}
