import java.util.ArrayList;

public class Joueur {
    private PaquetCartes paquetCartes;

    public Joueur() {
        this.paquetCartes = new PaquetCartes();
    }

    public Carte jouerCarte() {
        return paquetCartes.jouerPremiereCarte();
    }

    public void gagnerCartes(ArrayList<Carte> cartesGagnees) {
        for (Carte carte : cartesGagnees) {
            paquetCartes.ajouterCarteAuDessous(carte);
        }
    }

    public boolean aEncoreDesCartes() {
        return !paquetCartes.estVide();
    }

    public PaquetCartes getPaquetCartes() {
        return paquetCartes;
    }
}
