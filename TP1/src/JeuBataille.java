import java.util.ArrayList;
import java.util.Collections;

public class JeuBataille {
    private Joueur joueur1;
    private Joueur joueur2;
    private ArrayList<Carte> cartesSurTable;

    public JeuBataille() {
        joueur1 = new Joueur();
        joueur2 = new Joueur();
        cartesSurTable = new ArrayList<>();
        initialiserJeu();
    }

    public void initialiserJeu() {
        PaquetCartes paquetCartesInitial = new PaquetCartes();

        // creation du jeu de cartes
        for (int i = 1; i <= 52; i++) {
            paquetCartesInitial.ajouterCarte(new Carte(i));
        }
        paquetCartesInitial.melanger();
    
        ArrayList<ArrayList<Carte>> paquetsDistribues = paquetCartesInitial.distribuer();
        for (Carte carte : paquetsDistribues.get(0)) {
            joueur1.getPaquetCartes().ajouterCarteAuDessous(carte);
        }
        for (Carte carte : paquetsDistribues.get(1)) {
            joueur2.getPaquetCartes().ajouterCarteAuDessous(carte);
        }
    }   

    public void jouerTour(boolean batailleEnCours) {
        Carte carteJoueur1, carteJoueur2;
    
        if (!batailleEnCours) { // si une bataille n'est pas en cours
            System.out.println("Début du tour : Statistiques des joueurs : ");
            System.out.println("Le joueur 1 a " + joueur1.getPaquetCartes().getCartes().size() + " carte(s).");
            System.out.println("Le joueur 2 a " + joueur2.getPaquetCartes().getCartes().size() + " carte(s).");
            carteJoueur1 = joueur1.jouerCarte();
            carteJoueur2 = joueur2.jouerCarte();
            cartesSurTable.add(carteJoueur1);
            cartesSurTable.add(carteJoueur2);
        } else { // Cas d'une bataille
            carteJoueur1 = cartesSurTable.get(cartesSurTable.size() - 2);
            carteJoueur2 = cartesSurTable.get(cartesSurTable.size() - 1);
        }

        if (carteJoueur1 == null || carteJoueur2 == null) {
            return; // Le jeu est terminé.
        } else {
            System.out.println("Carte du joueur 1 : " + carteJoueur1.infosCarte());
            System.out.println("Carte du joueur 2 : " + carteJoueur2.infosCarte());
            int resultat = carteJoueur1.comparerCarte(carteJoueur2);
            
            if (resultat > 0) {
                System.out.println("Le joueur 1 remporte les cartes sur la table !");
                Collections.shuffle(cartesSurTable); // Mélange les cartes
                joueur1.gagnerCartes(new ArrayList<>(cartesSurTable));
                System.out.println("Le joueur 2 perd " + (cartesSurTable.size() / 2)+ " cartes. Il a maintenant " + joueur2.getPaquetCartes().getCartes().size() + " cartes.");
                System.out.println("Le joueur 1 a maintenant " + joueur1.getPaquetCartes().getCartes().size() + " cartes.");
            } else if (resultat < 0) {
                System.out.println("Le joueur 2 remporte les cartes sur la table !");
                Collections.shuffle(cartesSurTable); // Mélange les cartes
                joueur2.gagnerCartes(new ArrayList<>(cartesSurTable));
                System.out.println("Le joueur 1 perd " + (cartesSurTable.size() / 2)+ " cartes. Il a maintenant " + joueur1.getPaquetCartes().getCartes().size() + " cartes.");
                System.out.println("Le joueur 2 a maintenant " + joueur2.getPaquetCartes().getCartes().size() + " cartes.");
            } else {
                System.out.println("Egalité entre les cartes ! Bataille !");
                System.out.println();
                bataille();
            }
        }

        cartesSurTable.clear();
    }

    public void bataille() {
        if (joueur1.aEncoreDesCartes()) {
            cartesSurTable.add(joueur1.jouerCarte());
        }
        if (joueur2.aEncoreDesCartes()) {
            cartesSurTable.add(joueur2.jouerCarte());
        }

        // Piocher la carte face visible pour la bataille
        if (joueur1.aEncoreDesCartes() && joueur2.aEncoreDesCartes()) {
            cartesSurTable.add(joueur1.jouerCarte());
            cartesSurTable.add(joueur2.jouerCarte());
            jouerTour(true); // rejoue un tour en mode bataille
        } else {
            if(joueur1.aEncoreDesCartes()){
                System.out.println("Le joueur 2 n'a plus de cartes pour la bataille. Le joueur 1 est donc vainqueur.");
            } else {
                System.out.println("Le joueur 1 n'a plus de cartes pour la bataille. Le joueur 2 est donc vainqueur.");
            }
        }
    }  

    public Joueur joueurGagnant() {
        if (joueur1.aEncoreDesCartes() && !joueur2.aEncoreDesCartes()) {
            return joueur1;
        } else if (!joueur1.aEncoreDesCartes() && joueur2.aEncoreDesCartes()) {
            return joueur2;
        } else {
            return null; // Match nul ou jeu en cours
        }
    }

    public Joueur getJoueur1(){
        return joueur1;
    }

    public Joueur getJoueur2(){
        return joueur2;
    }

    public ArrayList<Carte> getCartesSurTable(){
        return cartesSurTable;
    }

    public static void main(String[] args) {
        int nbTour = 0;

        JeuBataille jeu = new JeuBataille();
        while (jeu.joueur1.aEncoreDesCartes() && jeu.joueur2.aEncoreDesCartes()) {
            nbTour++;
            System.out.println("Tour n° : " + nbTour);
            jeu.jouerTour(false);
            System.out.println();

            if(nbTour > 100000){
                System.out.println("Le nombre de tours a dépassé 100 000. Cela peut se produire dans certains cas (peu probables) de distributions de paquets. Arrêt de la partie");
                return;
            }
        }

        Joueur gagnant = jeu.joueurGagnant();
        if (gagnant != null) {
            System.out.println("Le gagnant est : " + (gagnant == jeu.joueur1 ? "Joueur 1" : "Joueur 2"));
        } else {
            System.out.println("Match nul !");
        }
    }
}
